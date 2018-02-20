package pl.dominisz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Przechowuje informacje o produktach dostępnych w sklepie
 * - lista produktów
 * - konstruktor tworzący kilka produktów
 * - znalezienie wszystkich produktów
 * - znalezienie produktu o podanym id
 * - zmniejszenie stanu produktu o podanym id, o podaną liczbę sztuk
 */

public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    public ProductRepository() {
        this.products.add(
                new Product(
                        1,
                        "Electrolux EAP450",
                        "Zanieczyszczone powietrze zasysane jest za pomocą wentylatora do wnętrza urządzenia. Filtr wstępny ma za zadanie zatrzymać włosy i sierść, które nagromadzone w dużej ilości zmniejszają przepływ powietrza.",
                        new BigDecimal(1690),
                        10
                )
        );
        this.products.add(
                new Product(
                        2,
                        "GOPRO HERO5 Black",
                        "HERO5 Black to łatwa w użyciu, najbardziej zaawansowana z dotychczas oferowanych kamer GoPro, co osiągnięto dzięki możliwości nagrywania filmów 4K, funkcji sterowania głosem, prostej obsłudze jednym przyciskiem, wyświetlaczowi dotykowemu i wodoodpornej konstrukcji.",
                        new BigDecimal(1348),
                        43
                )
        );
        this.products.add(
                new Product(
                        3,
                        "Zmywarka BOSCH SPS 53E18 EU",
                        "Innowacyjna technologia ActiveWater zapewnia maksymalną wydajność oraz ekologiczne płukanie z doskonałymi rezultatami. ",
                        new BigDecimal(1299),
                        5)
        );
        this.products.add(
                new Product(
                        4,
                        "Telewizor TOSHIBA 48L3663DG Smart TV WiFi Netflix",
                        "Odkryj doskonałej jakości obraz na ekranie telewizora Toshiba Full HD. Z ekranem o rozdzielczości 1080p można cieszyć się idealnie ostrą klarownością obrazu oraz najdrobniejszymi szczegółami i żywymi koloru.",
                        new BigDecimal(1399),
                        15)
        );
        this.products.add(
                new Product(
                        5,
                        "Wściekłe Pięści Węża 3",
                        "Wściekły Wąż powraca po latach w średniej formie. Tym razem będzie musiał pomścić śmierć swojego brata i stawić czoło wojskowemu Cyborgowi, który uciekł z konwoju. Jak zwykle na swojej drodze spotka szesnastu Braci Bliźniaków. Czy dokona zemsty?! Czy przeżyje?! A może zginie, tak jak w drugiej części? Wiemy jedno - keczup po raz pierwszy leje się w jakości HD!",
                        new BigDecimal(19),
                        10)
        );
        this.products.add(
                new Product(
                        6,
                        "Maska konia",
                        "Rewelacyjny sposób na wyróznianie siępodczas  imprezy.Zaskocz swoich znajomych! ",
                        new BigDecimal(20),
                        59)
        );
        this.products.add(
                new Product(
                        7,
                        "Klawiatura Logitech G413 Carbon",
                        "Klawiatura G413 została przemyślana, zaprojektowana i wyprodukowana w celu dostarczenia zaawansowanej wydajności z właściwym zestawem funkcji. ",
                        new BigDecimal(299),
                        10)
        );
        this.products.add(
                new Product(
                        8,
                        "Karcher WV 2 Premium 1.633-430.0",
                        "W Twoim domu jest dużo okien? Wybierz model o wydajności 75 m2. Taka myjka umożliwi Ci umycie większej ilości szyb przy jednym ładowaniu urządzenia.",
                        new BigDecimal(229),
                        50)
        );
        this.products.add(
                new Product(
                        9,
                        "Głośniki komputerowe Edifier R2600",
                        "R2600 to głośniki komputerowe w kolorze czarnym marki Edifier. Jest to zestaw głośników multimedialnym w konfiguracji 2.0 składający się z dwóch głośników. Moc głośników wynosi RMS 2 × 30W + 2 × 32W.",
                        new BigDecimal(694),
                        6)
        );
        this.products.add(
                new Product(
                        10,
                        "Samsung UE50MU6172",
                        "Oglądaj filmy w wysokiej klasy rozdzielczości UHD 4K. Jakość potwierdzona Certyfikatem Stowarzyszenia Digital Europe.",
                        new BigDecimal(2199),
                        100
                )
        );
    }

    /**
     * Zwraca listę wszystkich produktów ze sklepu
     *
     * @return lista wszystkich produktów
     */
    public List<Product> findAll() {
        return products;
    }

    /**
     * Zwraca produkt o podanym id
     *
     * @param id id produktu do wyszukania
     * @return znaleziony produkt, null jeżeli nie znaleziono produktu
     */
    public Product findById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Ustawia liczbę sztuk produktu w magazynie
     *
     * @param id    id produktu
     * @param count nowa liczba sztuk w magazynie
     */
    public void setCount(int id, int count) {
        Product product = findById(id);
        if (product != null) {
            product.setCount(count);
        }
    }

}
