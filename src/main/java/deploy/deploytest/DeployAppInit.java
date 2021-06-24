package deploy.deploytest;

import deploy.deploytest.service.ProductService;
import deploy.deploytest.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DeployAppInit implements CommandLineRunner {
    private final ProductService productService;
    private final UserService userService;

    public DeployAppInit(ProductService productService, UserService userService ) {
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.productService.initProducts();
        this.userService.seedUsers();
//test

    }
}
