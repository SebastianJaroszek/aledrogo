package pl.dominisz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    private Cart cart;

    @BeforeEach
    void setUp(){
        cart = new Cart();
    }

    @Test
    void add() {
        cart.add(new CartItem(1, 3));
        cart.add(new CartItem(1, 4));
        cart.add(new CartItem(2, 5));
        List<CartItem> cartItems = cart.getCartItems();
        assertEquals(2, cartItems.size());
        assertEquals(1, cartItems.get(0).getId());
        assertEquals(7, cartItems.get(0).getQuantity());
        assertEquals(2, cartItems.get(1).getId());
        assertEquals(5, cartItems.get(1).getQuantity());
    }

    /*@Test
    void getTotalPrice() {
        cart.add(new CartItem(1, 3));
        cart.add(new CartItem(1, 4));
        cart.add(new CartItem(2, 5));

        result
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems){
            cart
        }
    }*/
}