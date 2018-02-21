package pl.dominisz;

import java.math.BigDecimal;
import java.util.List;

public class Cashbox {

    private ProductRepository productRepository = ProductRepository.getInstance();

    public BigDecimal getTotalPrice(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (CartItem cartItem : cartItems){
            int id = cartItem.getId();
            Product foundedProduct = productRepository.findById(id);
            BigDecimal price = foundedProduct.getPrice();
            BigDecimal multipliedPrice = price.multiply(new BigDecimal(cartItem.getQuantity()));
            totalPrice = totalPrice.add(multipliedPrice);
        }
        return totalPrice;
    }

}
