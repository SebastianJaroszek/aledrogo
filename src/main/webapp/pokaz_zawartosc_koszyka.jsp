<%@ page import="java.util.List" %>
<%@ page import="pl.dominisz.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="errorpage.jsp" %>
<html>
<head>
    <title>Zawartość koszyka</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<div class="container">

    <%!
        ProductRepository productRepository = ProductRepository.getInstance();
        Cashbox cashbox = new Cashbox();
    %>
    <%
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null && !cart.getCartItems().isEmpty()) {


    %>
    <h2>Zawartość koszyka</h2>
    W Twoim koszyku znajdują się produkty:
    <ul class="collection">
        <%
            List<CartItem> cartItems = cart.getCartItems();
            for (CartItem cartItem : cartItems) {
                Product product = productRepository.findById(cartItem.getId());
                if (product != null) {
        %>
        <li class="collection-item">
            <%=product.getName()%>; cena: <%=product.getPrice()%>zł; ilość: <%=cartItem.getQuantity()%> szt.;
            <a href="usun_z_koszyka.jsp">USUŃ Z KOSZYKA</a>
        </li>
        <%
                }
            }
        %>
        <li class="collection-item">
            Całkowita wartość koszyka: <%=cashbox.getTotalPrice(cart)%>zł
        </li>
    </ul>
    <a class="btn waves-effect waves-light" href="zloz_zamowienie.jsp">ZŁÓŻ ZAMÓWIENIE</a>
    <%


    } else {
    %><h2>Koszyk jest pusty</h2><%
    }
%>

    <a class="btn waves-effect waves-light" href="homepage.jsp">WRÓĆ NA STRONĘ GŁÓWNĄ<i class="material-icons right">send</i></a>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
</div>

</body>
</html>
