package com.dtcc.projects.productcategories.controllers;

import com.dtcc.projects.productcategories.repositories.AssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



@Controller
public class AssociationController {
    @Autowired
    private AssociationRepository associationRepository;

}
