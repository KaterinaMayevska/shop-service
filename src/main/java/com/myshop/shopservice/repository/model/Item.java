package com.myshop.shopservice.repository.model;

import javax.persistence.*;


@Entity
@Table(name="items")
public final class  Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="articul")
    private String articul;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private Double price;

    public Item() {
        }

    public Item(String articul, String name, Double price) {
        this.articul = articul;
        this.name = name;
        this.price = price;
    }

    public String getArticul() {
        return articul;
    }

    public Long getId() {
        return id;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
