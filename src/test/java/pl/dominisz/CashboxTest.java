package pl.dominisz;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashboxTest {

    private static ProductRepository productRepository = ProductRepository.getInstance();

    @Test
    void shouldReturnProductsTotalPrice() {
        Cashbox cashbox = new Cashbox();

        Cart cart = createCart();

        BigDecimal totalPrice = cashbox.getTotalPrice(cart);

        BigDecimal expectedPrice = getExpectedTotalPrice(cart);

        assertEquals(expectedPrice, totalPrice);
    }

    private Cart createCart() {
        Cart cart = new Cart();
        cart.add(new CartItem(1, 3));
        cart.add(new CartItem(1, 3));
        cart.add(new CartItem(2, 4));
        cart.add(new CartItem(3, 5));
        return cart;
    }

    private BigDecimal getExpectedTotalPrice(Cart cart) {
        return new BigDecimal(1690).multiply(new BigDecimal(3))
                .add(new BigDecimal(1690).multiply(new BigDecimal(3)))
                .add(new BigDecimal(1348).multiply(new BigDecimal(4))
                .add(new BigDecimal(1299).multiply(new BigDecimal(5))));
    }
}
