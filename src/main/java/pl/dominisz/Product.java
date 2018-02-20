package pl.dominisz;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Klasa przechowująca informacje o produkcie
 * id, name, description, price, count
 */
@Data
@AllArgsConstructor
public class Product {

    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private int count;

}
