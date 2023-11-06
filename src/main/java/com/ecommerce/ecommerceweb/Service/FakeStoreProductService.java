package com.ecommerce.ecommerceweb.Service;

import com.ecommerce.ecommerceweb.DTO.FakeStoreProductDTO;
import com.ecommerce.ecommerceweb.DTO.GenericProductDTO;
import com.ecommerce.ecommerceweb.exception.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements  ProductService {
    private RestTemplateBuilder restTemplateBuilder;

    private String getProuctRequestURL = "https://fakestoreapi.com/products/{id}";
    private String createProuctRequestURL = "https://fakestoreapi.com/products";
    private String ProductRequestBaseURL = "https://fakestoreapi.com/products";

    private String UpdateProductUrl = "https://fakestoreapi.com/products/{id}";
    private String limitresult = "https://fakestoreapi.com/products?limit={limit}";

    private String getCategories = "https://fakestoreapi.com/products/categories";

    private  String getspecificCategory="https://fakestoreapi.com/products/category/{category}";

    private String sorturl="https://fakestoreapi.com/products?sort={order}";


    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private GenericProductDTO convertFakeStoretoGenericProdcut(FakeStoreProductDTO fakeStoreProductDTO) {
        GenericProductDTO product = new GenericProductDTO();
        product.setId(fakeStoreProductDTO.getId());
        product.setImage(fakeStoreProductDTO.getImage());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setCategory(fakeStoreProductDTO.getCategory());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setTitle(fakeStoreProductDTO.getTitle());

        return product;
    }


    @Override
    public GenericProductDTO getProductById(Long id) throws NotFoundException {
        //  FakeStoreProductService fakeStoreProductService = new FakeStoreProductService();
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity(getProuctRequestURL, FakeStoreProductDTO.class, id);
        // response.getStatusCode();
        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();

        if (fakeStoreProductDTO == null) {
            throw new NotFoundException("Product with id" + id + "does not exist");
        }
        return convertFakeStoretoGenericProdcut(fakeStoreProductDTO);
    }

    public GenericProductDTO createProduct(GenericProductDTO product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDTO> response = restTemplate.postForEntity(createProuctRequestURL, product, GenericProductDTO.class);
        return response.getBody();
    }

    public List<GenericProductDTO> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(ProductRequestBaseURL, FakeStoreProductDTO[].class);
        List<GenericProductDTO> ans = new ArrayList<>();
        for (FakeStoreProductDTO fakeStoreProductDTO : response.getBody()) {

            ans.add(convertFakeStoretoGenericProdcut(fakeStoreProductDTO));

        }

        return ans;
    }

    public GenericProductDTO deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDTO.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.execute(getProuctRequestURL, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
        return convertFakeStoretoGenericProdcut(fakeStoreProductDTO);

    }

    public GenericProductDTO UpdateProduct(Long id, GenericProductDTO updateproduct) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        // restTemplate.put(UpdateProductUrl,FakeStoreProductDTO.class,id);


        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDTO.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.execute(UpdateProductUrl, HttpMethod.PUT, requestCallback, responseExtractor, id, updateproduct);
        return convertFakeStoretoGenericProdcut(response.getBody());


    }

    public List<GenericProductDTO> getlimitedProduct(int limit) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(limitresult, FakeStoreProductDTO[].class, limit);
        List<GenericProductDTO> ans = new ArrayList<>();
        List<GenericProductDTO> ans1 = new ArrayList<>();

        for (FakeStoreProductDTO fakeStoreProductDTO : response.getBody()) {

            ans.add(convertFakeStoretoGenericProdcut(fakeStoreProductDTO));

        }


        for (int i = 0; i < limit; i++) {
            ans1.add(ans.get(i));
        }
        return ans1;
    }


    public List<String> getAllCategory(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String> response = restTemplate.getForEntity(getCategories,String.class);
        List<String> Categorys =new ArrayList<>();

            Categorys.add(response.getBody());

        return  Categorys;
    }

    public List<GenericProductDTO> getInCategory(String Category){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(getspecificCategory,FakeStoreProductDTO[].class,Category);
        List<GenericProductDTO> ans = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO: response.getBody())
        {
            ans.add(convertFakeStoretoGenericProdcut(fakeStoreProductDTO));
        }
        return  ans;



    }

    public List<GenericProductDTO> getSortedOrder(String order){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(sorturl,FakeStoreProductDTO[].class,order);
        List<GenericProductDTO> ans = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO: response.getBody())
        {
            ans.add(convertFakeStoretoGenericProdcut(fakeStoreProductDTO));
        }
        return  ans;


    }
}














