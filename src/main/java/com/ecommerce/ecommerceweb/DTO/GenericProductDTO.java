package com.ecommerce.ecommerceweb.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenericProductDTO {
    private  Long id;
    private String title;
    private String description;
    private  String image;
    private String category;
    private  double price;
}
