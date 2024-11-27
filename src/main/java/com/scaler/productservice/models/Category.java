package com.scaler.productservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE},
    fetch = FetchType.EAGER)
    @JsonIgnore
    @Fetch(FetchMode.JOIN)
    private List<Product> products;
}
