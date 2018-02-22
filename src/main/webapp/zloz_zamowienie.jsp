<%@ page import="pl.dominisz.Cart" %>
<%@ page import="pl.dominisz.CartItem" %>
<%@ page import="java.util.List" %>
<%@ page import="pl.dominisz.Product" %>
<%@ page import="pl.dominisz.ProductRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="errorpage.jsp" %>
<html>
<head>
    <title>Złóż zamówienie</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<div class="container">

    <%!
        ProductRepository productRepository = ProductRepository.getInstance();
    %>
    <%
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null && !cart.getCartItems().isEmpty()) {
            List<CartItem> cartItems = cart.getCartItems();
            for (CartItem cartItem : cartItems) {
                Product product = productRepository.findById(cartItem.getId());
                if (cartItem.getQuantity() <= product.getCount()) {
                    productRepository.setCount(product.getId(), product.getCount() - cartItem.getQuantity());
                }
            }
            cart.getCartItems().clear();
    %>
    <h2>Udało się złożyć zamówienie</h2>
    <%
    } else {
    %>
    <h2>Koszyk jest pusty</h2>
    <%
        }
    %>
    <a class="btn waves-effect waves-light" href="homepage.jsp">WRÓĆ<i class="material-icons right">send</i></a>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
</div>

</body>
</html>




