package com.dtcc.projects.productcategories.repositories;

import com.dtcc.projects.productcategories.models.Association;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AssociationRepository extends CrudRepository<Association,Long> {

}
