package com.ecommerce.ecommerceweb.Service;

import com.ecommerce.ecommerceweb.DTO.GenericProductDTO;
import com.ecommerce.ecommerceweb.exception.NotFoundException;

import java.util.List;

public interface ProductService {
    GenericProductDTO createProduct(GenericProductDTO product);

    GenericProductDTO getProductById(Long id) throws NotFoundException;

    List<GenericProductDTO> getAllProducts();

    GenericProductDTO deleteProduct(Long id);

    GenericProductDTO UpdateProduct(Long id,GenericProductDTO updateproduct);
    List<GenericProductDTO> getlimitedProduct(int limit);

    List<String> getAllCategory();

    List<GenericProductDTO> getInCategory(String category);
    List<GenericProductDTO> getSortedOrder(String order);

}
