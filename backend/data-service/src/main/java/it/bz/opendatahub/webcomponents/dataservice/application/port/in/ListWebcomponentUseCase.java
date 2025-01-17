package it.bz.opendatahub.webcomponents.dataservice.application.port.in;

import it.bz.opendatahub.webcomponents.dataservice.application.domain.Webcomponent;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ListWebcomponentUseCase {
	List<Webcomponent> listAll();

	Page<Webcomponent> listPagedAndFiltered(@NonNull Pageable pageRequest, @NonNull WebcomponentFilter filter);

	@Getter
	@Setter
	class WebcomponentFilter {
		private String searchTerm;

		private List<String> tags;
	}
}
