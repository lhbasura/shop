package com.lhb.sh.model;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class Sku {
    private Integer id;

    private String title;

    private String description;

    private BigDecimal price;

    private Integer stock;

    private Integer productId;

    private Date createdAt;

    private Date updatedAt;
}