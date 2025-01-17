package it.bz.opendatahub.webcomponents.dataservice.application.port.out;

import it.bz.opendatahub.webcomponents.dataservice.application.domain.SpdxLicense;
import lombok.NonNull;

import java.util.List;
import java.util.Map;

public interface ReadSpdxLicensePort {
	SpdxLicense getById(@NonNull String id);

	Map<String, SpdxLicense> listByIds(@NonNull List<String> licenseIds);
}
