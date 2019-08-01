package it.bz.opendatahub.webcomponents.dataservice.repository;

import it.bz.opendatahub.webcomponents.dataservice.data.model.WebcomponentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebcomponentRepository extends JpaRepository<WebcomponentModel, String> {

}
