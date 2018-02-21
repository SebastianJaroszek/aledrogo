package pl.dominisz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {
        "/allProducts",
        "/showProductDetails",
        "/addToCart",
        "/placeOrder",
        "/showCart"
})
public class AledrogoServlet extends HttpServlet {

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

    private void placeOrder(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void showProductDetails(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void showAllProducts(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestUri = req.getRequestURI();
        if (requestUri.endsWith("/addToCart")) {
            addToCart(req, resp);
        }
    }

    private void addToCart(HttpServletRequest req, HttpServletResponse resp) {

    }
}
