package com.lhb.sh.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class Product {
    private Integer id;

    private String title;

    private String description;

    private String image;

    private Boolean onSale;

    private Double rating;

    private Integer soldCount;

    private Integer reviewCount;

    private BigDecimal price;

    private Date createdAt;

    private Date updatedAt;
}