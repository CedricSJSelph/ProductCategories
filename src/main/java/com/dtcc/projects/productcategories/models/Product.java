package com.dtcc.projects.productcategories.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "PRDOCUT_NAME")
    private String productName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "CREATED_AT")
    private Date created_at;

    @Column(name = "UPDATED_AT")
    private Date updated_at;

    @ManyToMany
    @JoinTable(name = "categories_products", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categoryList;

    public Product(String productName, String description, Double price, Date created_at, Date updated_at) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
