package marketplace.testutil

import org.hibernate.Criteria

import grails.orm.PagedResultList
import grails.test.GrailsMock

class MockPagedResultList {
    PagedResultList createPagedResultList(List yourList, Integer size = null) {
        //from http://stackoverflow.com/a/19216929
        def mockC = new GrailsMock(Criteria, false)
        mockC.demand.list { return [] } //PagedResultList constructor calls this

        return new PagedResultList(null, mockC.createMock()) {{
           list = yourList
           totalCount = size ?: yourList.size()
        }}
    }
}
