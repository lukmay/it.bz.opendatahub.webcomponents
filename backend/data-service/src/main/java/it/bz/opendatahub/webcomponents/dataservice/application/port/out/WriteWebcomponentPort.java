package it.bz.opendatahub.webcomponents.dataservice.application.port.out;

import it.bz.opendatahub.webcomponents.dataservice.application.domain.Webcomponent;
import lombok.NonNull;

public interface WriteWebcomponentPort {
	Webcomponent saveWebcomponent(@NonNull Webcomponent webcomponent);
}