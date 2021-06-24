package deploy.deploytest.service.impl;


import deploy.deploytest.model.entities.ProductEntity;
import deploy.deploytest.model.entities.enums.GenderEnum;
import deploy.deploytest.model.service.ProductServiceModel;
import deploy.deploytest.repository.ProductRepository;
import deploy.deploytest.service.ProductService;
import deploy.deploytest.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final UserService userService;


    public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository, UserService userService) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.userService = userService;
    }



    @Override
    public List<ProductEntity> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }


    @Override
    public void addNewProduct(ProductServiceModel model) throws IOException {
        ProductEntity product = modelMapper.map(model, ProductEntity.class);
        productRepository.save(product);
//        System.out.println();
    }


    @Override
    public void initProducts() {
        if(productRepository.count()==0){
            //kucheta

            ProductEntity productEntity = new ProductEntity()
                    .setName("Koko")
                    .setBreed("Pekines")
                    .setGender(GenderEnum.MALES)
                    .setBirthDate(LocalDate.of(2020,10,22))
                    .setPrice(BigDecimal.valueOf(3432));
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Lucky")
                    .setBirthDate(LocalDate.of(2020,4,12))
                    .setPrice(BigDecimal.valueOf(1233))
                    .setGender(GenderEnum.MALES)
                    .setBreed("Golden retriver");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Gosho")
                    .setBirthDate(LocalDate.of(2020,6,14))
                    .setPrice(BigDecimal.valueOf(1233))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Bigal");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Sonya")
                    .setBirthDate(LocalDate.of(2020,12,28))
                    .setPrice(BigDecimal.valueOf(411))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Nemska ovcharka");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Hacki")
                    .setBirthDate(LocalDate.of(2020,7,9))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.MALES)
                    .setBreed("Akita anu");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Camila")
                    .setBirthDate(LocalDate.of(2020,8,14))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Chao Chao");
            this.productRepository.save(productEntity);

            // kotki
            productEntity = new ProductEntity()
                    .setName("Mara")
                    .setBirthDate(LocalDate.of(2020,4,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Yaponski bobtail");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Snow")
                    .setBirthDate(LocalDate.of(2020,4,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.MALES)
                    .setBreed("Sibirska kotka");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Roza")
                    .setBirthDate(LocalDate.of(2020,3,22))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Siamska kotka");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Puffy")
                    .setBirthDate(LocalDate.of(2021,2,18))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.MALES)
                    .setBreed("Persiiska kotka malka");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Mini")
                    .setBirthDate(LocalDate.of(2020,11,29))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Persiiska kotka golyama");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Faraon")
                    .setBirthDate(LocalDate.of(2020,4,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.MALES)
                    .setBreed("Kanadski sfinks");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Mila")
                    .setBirthDate(LocalDate.of(2020,12,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Britanska kasokosmesta");
            this.productRepository.save(productEntity);

        }//end of if count
    }



}
