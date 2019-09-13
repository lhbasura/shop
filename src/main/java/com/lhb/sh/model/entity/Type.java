package com.lhb.sh.model.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Type {
    private Integer id;

    private String name;

    private Date createdAt;

    private Date updatedAt;
}