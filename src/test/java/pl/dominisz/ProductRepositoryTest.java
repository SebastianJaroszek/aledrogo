package pl.dominisz;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository productRepository = ProductRepository.getInstance();

    @Test
    void findAllShouldReturnAllProducts() {
        //zaszyta na stałe lista produktów w konstruktorze nie jest dobra pod kątem testów, lepiej dostarczać listę
        //produktów z zewnątrz, np. setter/add
        List<Product> products = productRepository.findAll();
        assertTrue(products.size() == 10);
    }

    @Test
    void findById1ShouldReturnProductsButFindById500ShouldReturnNull() {
        Product existProduct = productRepository.findById(3);
        Product notExistProduct = productRepository.findById(500);

        assertNotNull(existProduct);
        assertEquals(existProduct.getId(), 3);
        assertNull(notExistProduct);
    }

    @Test
    void setCountShouldChangeCountOfProducts() {
        Product product = productRepository.findById(1);
        productRepository.setCount(1, 450);
        int countAfterChange = product.getCount();
        assertEquals(countAfterChange, 450);

    }

    @Test
    void getInstance(){
        ProductRepository productRepository = ProductRepository.getInstance();
        productRepository = ProductRepository.getInstance();
    }
}