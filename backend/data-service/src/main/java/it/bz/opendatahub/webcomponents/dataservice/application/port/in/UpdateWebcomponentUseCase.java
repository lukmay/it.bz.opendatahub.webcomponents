package it.bz.opendatahub.webcomponents.dataservice.application.port.in;

import it.bz.opendatahub.webcomponents.common.data.struct.Author;
import it.bz.opendatahub.webcomponents.dataservice.application.domain.Webcomponent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public interface UpdateWebcomponentUseCase {
	Webcomponent updateWebcomponent(String webcomponentUuid, WebcomponentUpdateRequest request);

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	class WebcomponentUpdateRequest {
		private String title;

		private String description;

		private String descriptionAbstract;

		private String license;

		private String repositoryUrl;

		private List<Author> copyrightHolders;

		private List<Author> authors;

		private List<String> searchTags;
	}
}
