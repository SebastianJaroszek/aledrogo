package pl.dominisz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {
        "/allProducts",
        "/showProductDetails",
        "/addToCart",
        "/placeOrder",
        "/showCart"
})
public class AledrogoServlet extends HttpServlet {

    private ProductRepository productRepository = ProductRepository.getInstance();
    private Cashbox cashbox = new Cashbox();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestUri = req.getRequestURI();
        if (requestUri.endsWith("/allProducts")) {
            showAllProducts(req, resp);
        } else if (requestUri.endsWith("/showProductDetails")) {
            showProductDetails(req, resp);
        } else if (requestUri.endsWith("/showCart")) {
            showCart(req, resp);
        } else if (requestUri.endsWith("/placeOrder")) {
            placeOrder(req, resp);
        }
    }

    private void placeOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();
        Cart cart = (Cart) httpSession.getAttribute("cart");
        PrintWriter out = getPrintWriter(resp);
        if (cart != null && !cart.getCartItems().isEmpty()) {
            List<CartItem> cartItems = cart.getCartItems();
            for (CartItem cartItem : cartItems) {
                Product product = productRepository.findById(cartItem.getId());
                if (cartItem.getQuantity() <= product.getCount()) {
                    productRepository.setCount(product.getId(), product.getCount() - cartItem.getQuantity());
                }
            }
            cart.getCartItems().clear();
            out.println("<h1>Udało się złożyć zamówienie</h1>");
        } else {
            out.println("Koszyk jest pusty");
        }
        createBackLink(out);
    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();
        Cart cart = (Cart) httpSession.getAttribute("cart");
        PrintWriter out = getPrintWriter(resp);
        if (cart != null && !cart.getCartItems().isEmpty()) {
            out.println(printCart(cart));
            out.println("Całkowita wartość koszyka: " + cashbox.getTotalPrice(cart) + "zł");
        } else {
            out.println("Koszyk jest pusty");
        }
        createBackLink(out);
    }

    private String printCart(Cart cart) {
        String result = "<h1>Zawartość koszyka</h1><br><br>W Twoim koszyku znajdują się produkty:<br><br><ul>";
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            Product product = productRepository.findById(cartItem.getId());
            if (product != null) {
                result = result + "<li>" + product.getName() + "; cena: " + product.getPrice()
                        + "zł; ilość: " + cartItem.getQuantity() + "szt.; " + deleteProductLink(product) + "</li>";
            }
        }
        result = result + "</ul>";
        return result;
    }

    private String deleteProductLink(Product product) {
        return "<a href=\"deleteProduct?id=" + product.getCount() + "\">usuń produkt</a>";
    }

    private PrintWriter getPrintWriter(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        return resp.getWriter();
    }

    private void showProductDetails(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = getPrintWriter(resp);

        //TODO zabezpieczyć przed wpisaniem czegoś co nie jest liczbą
        int id = Integer.valueOf(req.getParameter("id"));
        Product product = productRepository.findById(id);
        if (product != null) {
            out.println("<h1>Szczegółowe dane o produkcie</h1>");

            out.println(printProductDetails(product));

            out.println("<form action=\"addToCart\" method=\"POST\">");
            out.println("<br><br>Liczba sztuk: <input type=\"number\" name=\"quantity\" value=\"1\"> ilość dostępnych sztuk: "
                    + product.getCount() + "<br><br>");
            out.println("<input type=\"hidden\" name=\"id\" value=\"" + id + "\">");

            out.println("<br><input type=\"submit\" value=\"dodaj do koszyka\">");
            out.println("</form>");
            createBackLink(out);
        }

    }

    private String printProductDetails(Product product) {
        return "Nazwa produktu: " + product.getName()
                + "<br><br>Opis produktu: " + product.getDescription()
                + "<br><br>Cena produktu: " + product.getPrice() + " zł";
    }

    private void showAllProducts(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = getPrintWriter(resp);
        out.println("<h1>Lista wszystkich produktów w sklepie</h1>");
        out.println("<ul>");

        List<Product> allProducts = productRepository.findAll();
        for (Product product : allProducts) {
            out.println(showProduct(product));
        }

        out.println("</ul>");

        createBackLink(out);
    }

    private void createBackLink(PrintWriter out) {
        out.println("<br><br><a href=\"homepage.jsp\">wróć</a>");
    }

    private String showProduct(Product product) {
        return "<li>" + product.getName()
                + ", cena: " + product.getPrice() + " zł, "
                + showProductDetailsLink(product)
                + "</li>";
    }

    private String showProductDetailsLink(Product product) {
        return "<a href=\"showProductDetails?id=" + product.getId()
                + "\">zobacz szczegóły</a>";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestUri = req.getRequestURI();
        if (requestUri.endsWith("/addToCart")) {
            addToCart(req, resp);
        }
    }

    private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //TODO zabezpieczenie przed NumberFormatException
        int id = Integer.parseInt(req.getParameter("id"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        CartItem cartItem = new CartItem(id, quantity);
        HttpSession httpSession = req.getSession();
        Cart cart = (Cart) httpSession.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            httpSession.setAttribute("cart", cart);
        }
        cart.add(cartItem);

        PrintWriter out = getPrintWriter(resp);
        out.println("<h1>Udało się dodać produkt do koszyka</h1>");
        createBackLink(out);
    }
}
