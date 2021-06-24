package deploy.deploytest.web;


import deploy.deploytest.model.entities.ProductEntity;
import deploy.deploytest.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestProductController {
    private final ProductService productService;

    public RestProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("product/allRest")
    private List<ProductEntity> allProducts(){

        return productService.getAllProducts();
    }



}
