package com.scaler.productservice.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private double price;
    private String imageUrl;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;
}