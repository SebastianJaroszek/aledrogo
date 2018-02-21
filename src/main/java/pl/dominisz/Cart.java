package pl.dominisz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Przechowuje koszyk
 * - lista CartItem
 * - dodanie CartItem do koszyka
 * - obliczenie łącznej ceny towarów
 */
public class Cart {

    private List<CartItem> cartItems = new ArrayList<>();

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    private CartItem findById(int id) {
        return cartItems.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void add(CartItem cartItem) {
        CartItem existingCartItem = findById(cartItem.getId());
        if (existingCartItem != null) {
            int existingQuantity = existingCartItem.getQuantity();
            existingCartItem.setQuantity(existingQuantity + cartItem.getQuantity());
        } else {
            cartItems.add(cartItem);
        }
    }
}
