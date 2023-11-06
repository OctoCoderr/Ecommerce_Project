package com.ecommerce.ecommerceweb.Controller;

import com.ecommerce.ecommerceweb.DTO.GenericProductDTO;
import com.ecommerce.ecommerceweb.Service.ProductService;
import com.ecommerce.ecommerceweb.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService= productService;
    }
//    @GetMapping
//    public List<GenericProductDTO> getAllProducts(){
//        return  productService.getAllProducts();
//
//    }
//    @GetMapping("{id}")
//    public GenericProductDTO getProductById(@PathVariable("id") Long id) throws NotFoundException {
//        return productService.getProductById(id);
//
//    }
//
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<GenericProductDTO> deleteProductById(@PathVariable("id") Long Id){
//        ResponseEntity<GenericProductDTO> response=new ResponseEntity<>(productService.deleteProduct(Id), HttpStatus.OK);
//        return  response;
//    }
//    @PostMapping
//    public  GenericProductDTO createProduct(@RequestBody GenericProductDTO product){
//        return  productService.createProduct(product);
//
//    }
//    @PutMapping("{id}")
//    public  GenericProductDTO updateProductById(@PathVariable("id") Long Id,@RequestBody GenericProductDTO updateproduct){
//            return productService.UpdateProduct(Id,updateproduct);
//    }
//    @GetMapping("{limit}")
//    public List<GenericProductDTO> LimitResult(@PathVariable("limit") int  lim) throws NotFoundException {
//        return productService.getlimitedProduct(lim);
//
//    }
//    @GetMapping
//    public List<String> getAllCategory(){
//        return  productService.getAllCategory();
//
//    }

//    @GetMapping("{Category}")
//    public List<GenericProductDTO> GetInCategory(@PathVariable("Category") String  Category) throws NotFoundException {
//        return productService.getInCategory(Category);
//
//    }

    @GetMapping("{order}")
    public List<GenericProductDTO> GetSortedResult(@PathVariable("order") String  order) throws NotFoundException {
        return productService.getSortedOrder(order);

    }



}
