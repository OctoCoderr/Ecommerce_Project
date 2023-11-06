package com.ecommerce.ecommerceweb.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDTO {

    private Long id;
    private double price;
    private String category;
    private  String description;
    private String image;
    private  String title;

}
