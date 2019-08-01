package it.bz.opendatahub.webcomponents.crawlerservice.data.api.github;

import it.bz.opendatahub.webcomponents.crawlerservice.repository.impl.GithubApiRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ref {
    private String ref;

    private String node_id;

    private String url;

    private RefObject object = new RefObject();

    @Getter
    @Setter
    public static class RefObject {
        private String type;

        private String sha;

        private String url;
    }
}
