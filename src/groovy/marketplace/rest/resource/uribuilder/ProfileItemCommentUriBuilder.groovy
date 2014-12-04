package marketplace.rest.resource.uribuilder

import javax.ws.rs.core.UriBuilder

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.Profile
import marketplace.ItemComment

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ProfileResource

import marketplace.rest.ChildObjectCollection

class ProfileItemCommentUriBuilder implements
        ChildCollectionUriBuilder<Profile, ItemComment>,
        ObjectUriBuilder<ItemComment> {
    private ApplicationRootUriBuilderHolder uriBuilderHolder
    private ObjectUriBuilder<ItemComment> itemCommentUriBuilder

    protected ProfileItemCommentUriBuilder(
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            ObjectUriBuilder<ItemComment> itemCommentUriBuilder) {
        this.uriBuilderHolder = uriBuilderHolder
    }

    /**
     * delegates to ItemCommentUriBuilder.getUri
     */
    URI getUri(ItemComment itemComment) {
        itemCommentUriBuilder.getUri(itemComment)
    }

    private UriBuilder getCollectionBuilder() {
        uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'getItemCommentsByAuthorId')
    }

    URI getCollectionUri(ChildObjectCollection<Profile, ItemComment> collection) {
        getCollectionUri(collection.parent)
    }

    URI getCollectionUri(Profile parent) {
        getCollectionBuilder().buildFromMap(profileId: parent.id)
    }

    CollectionUriBuilder<ItemComment> getCollectionUriBuilder(
            ChildObjectCollection<Profile, ItemComment> collection) {
        { -> getCollectionUri(collection) } as CollectionUriBuilder<ItemComment>
    }

    CollectionUriBuilder<ItemComment> getCollectionUriBuilder(Profile parent) {
        { -> getCollectionUri(parent) } as CollectionUriBuilder<ItemComment>
    }

    @Component
    public static class Factory implements
            ChildCollectionUriBuilder.Factory<Profile, ItemComment>,
            ObjectUriBuilder.Factory<ItemComment> {
        @Autowired ItemCommentUriBuilder.Factory itemCommentUriBuilderFactory

        ProfileItemCommentUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ProfileItemCommentUriBuilder(uriBuilderHolder,
                itemCommentUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
