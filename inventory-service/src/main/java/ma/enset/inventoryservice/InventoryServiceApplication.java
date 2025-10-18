package ma.enset.inventoryservice;

import ma.enset.inventoryservice.entities.Product;
import ma.enset.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.saveAll(List.of(
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Laptop")
                            .price(1200.0)
                            .quantity(10)
                            .build(),
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Smartphone")
                            .price(800.0)
                            .quantity(25)
                            .build(),
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Headphones")
                            .price(150.0)
                            .quantity(40)
                            .build(),
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Monitor")
                            .price(300.0)
                            .quantity(15)
                            .build()
            ));

            productRepository.findAll().forEach(System.out::println);
        };
    }
}
