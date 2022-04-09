package com.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @Column(name = "productkey", nullable = false, length = 20)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String productkey;
    @Column(name = "productid", nullable = false, length = 20)
    private String productid;
    @Column(name = "productname")
    private String productname;
    @Column(name = "vendordemain")
    private String vendordemain;
    @Column(name = "manufacturers")
    private String manufacturers;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Double price;

    @Column(name = "status")
    private String statusid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeid")
    private TypeEntity type;

    public ProductEntity(){
    }

    public ProductEntity(String productkey, String productid, String productname, String vendordemain, String manufacturers, Integer quantity, Double price, String statusid, TypeEntity type) {
        this.productkey = productkey;
        this.productid = productid;
        this.productname = productname;
        this.vendordemain = vendordemain;
        this.manufacturers = manufacturers;
        this.quantity = quantity;
        this.price = price;
        this.statusid = statusid;
        this.type = type;
    }

    public String getProductkey() {
        return productkey;
    }

    public void setProductkey(String productkey) {
        this.productkey = productkey;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getVendordemain() {
        return vendordemain;
    }

    public void setVendordemain(String vendordemain) {
        this.vendordemain = vendordemain;
    }

    public String getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(String manufacturers) {
        this.manufacturers = manufacturers;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatusid() {
        return statusid;
    }

    public void setStatusid(String status) {
        this.statusid = status;
    }

    public TypeEntity getType() {
        return type;
    }

    public void setType(TypeEntity type) {
        this.type = type;
    }
}
