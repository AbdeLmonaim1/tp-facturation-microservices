package ma.enset.billingservice.entities;

import lombok.Data;

@Data
public class Product {
    private String id;
    private String name;
    private Double price;
    private int quantity;
}
