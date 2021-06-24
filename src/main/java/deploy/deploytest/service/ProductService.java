package deploy.deploytest.service;



import deploy.deploytest.model.entities.ProductEntity;
import deploy.deploytest.model.service.ProductServiceModel;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    void initProducts();
    List<ProductEntity> getAllProducts();

    void deleteById(Long id);

    void addNewProduct(ProductServiceModel model) throws IOException;

}
