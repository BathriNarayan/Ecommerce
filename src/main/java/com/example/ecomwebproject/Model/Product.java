package com.example.ecomwebproject.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product
{
    //public Long getId;
    @Id
    // @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int price;
    private int quantity;
    private String description;
    private String brand;
    private String model;
    private Boolean available;
    private Date releaseDate;

    public long getId() {
        return id;
    }
}

