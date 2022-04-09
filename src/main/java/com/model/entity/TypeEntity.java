package com.model.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Proxy(lazy = false)
@Entity
@Table(name = "type" )
public class TypeEntity {
    @Id
    @Column(name = "typeid" , nullable = false, length = 20)
    private String typeid;
    @Column(name = "typename", nullable = false, length = 20)
    private String typename;
    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    private Set<ProductEntity> productsOnSup = new HashSet<ProductEntity>();


    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Set<ProductEntity> getProductsOnSup() {
        return productsOnSup;
    }

    public void setProductsOnSup(Set<ProductEntity> productsOnSup) {
        this.productsOnSup = productsOnSup;
    }
}
