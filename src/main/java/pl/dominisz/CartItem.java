package pl.dominisz;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Pozycja w koszyku, na którą skada się
 * id - id produktu
 * quantity - liczba sztuk
 */

@Data
@AllArgsConstructor
public class CartItem {
    private int id; // id produktu
    private int quantity; // sztuki w koszyku
}
