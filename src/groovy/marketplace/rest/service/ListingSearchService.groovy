package marketplace.rest.service

import marketplace.Listing
import marketplace.search.SearchCriteria
import marketplace.search.SearchResult
import org.elasticsearch.index.query.FilterBuilder
import org.elasticsearch.index.query.FilterBuilders
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.index.query.QueryBuilder
import org.elasticsearch.search.sort.FieldSortBuilder
import org.elasticsearch.search.sort.ScoreSortBuilder
import org.elasticsearch.search.sort.SortBuilder
import org.elasticsearch.search.sort.SortOrder
import org.grails.plugins.elasticsearch.ElasticSearchService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

@Service
class ListingSearchService {

    @Autowired ElasticSearchService elasticSearchService

    public SearchResult<Listing> searchListings(SearchCriteria sc) {
        def searchOptions = [
                size: sc.max,
                from: sc.offset,
                types: ['marketplace.Listing'],
                sort: [getSortBuilder(sc)]
        ]

        def searchData = elasticSearchService.search(searchOptions, getQueryBuilder(sc))
        def result = new SearchResult<Listing>()

        result.with {
            searchCriteria = sc
            total = searchData.total
            items = searchData.searchResults
        }

        result
    }

    /**
     * Create the query builder that will ultimately be passed to the elasticsearch client from the criteria.
     * Conditionally creates either a filter query (if there are filters) or a simple query string query.
     *
     * @param searchCriteria
     * @return
     */
    private static QueryBuilder getQueryBuilder(SearchCriteria searchCriteria) {
        if(searchCriteria.filters) {
            QueryBuilders.filteredQuery(
                getQueryStringQueryBuilder(searchCriteria),
                getFilterBuilder(searchCriteria)
            )
        } else {
            getQueryStringQueryBuilder(searchCriteria)
        }
    }

    /**
     * Create a simple query string query builder
     *
     * @param searchCriteria
     * @return
     */
    private static QueryBuilder getQueryStringQueryBuilder(SearchCriteria searchCriteria) {
        def queryStringQueryBuilder = QueryBuilders.queryString(searchCriteria.queryString)
        searchCriteria.fields.each { queryStringQueryBuilder.field(it) }

        queryStringQueryBuilder
    }

    /**
     * Create the filter builder from the criteria. In general, the filter clause is a bool filter
     * with a must clause - containing a single query filter - for each filtered field.
     * In the cases where the field is in a nested object, the query filter is a nested filter which
     * handles the multipart path.
     *
     * @param searchCriteria
     * @return
     */
    private static FilterBuilder getFilterBuilder(SearchCriteria searchCriteria) {
        def boolFilterBuilder = FilterBuilders.boolFilter()
        searchCriteria.filters.each { String field, List values ->
            if(field.contains(".")) {
                String nestedPath = field.split("\\.")[0]
                values.each { String value ->
                    boolFilterBuilder.must(
                        FilterBuilders.nestedFilter(
                            nestedPath,
                            QueryBuilders
                                .queryString("\"$value\"")
                                .defaultField(field)
                        )
                    )
                }
            } else {
                values.each { String value ->
                    boolFilterBuilder.must(
                        FilterBuilders.queryFilter(
                            QueryBuilders
                                .queryString("\"$value\"")
                                .defaultField(field)
                        )
                    )
                }
            }
        }

        boolFilterBuilder
    }

    private static SortBuilder getSortBuilder(SearchCriteria searchCriteria) {
        SortOrder order = SortOrder.valueOf(searchCriteria.order)
        if(searchCriteria.sort == 'score') {
            new ScoreSortBuilder().order(order)
        } else {
            new FieldSortBuilder(searchCriteria.sort).order(order)
        }
    }
}
