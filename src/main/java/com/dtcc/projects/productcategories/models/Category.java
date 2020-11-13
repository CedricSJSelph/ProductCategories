package com.dtcc.projects.productcategories.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

    @Column(name = "CATEGORY_NAME")
    private String value;

    @Column(name = "CREATED_AT")
    private Date created_at;

    @Column(name = "UPDATED_AT")
    private Date updated_at;

    @ManyToMany
    @JoinTable(name = "categories_products", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> productList;

    public Category(String value, Date created_at, Date updated_at) {
        this.value = value;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
