<%@ page import="pl.dominisz.Cart" %>
<%@ page import="pl.dominisz.CartItem" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="errorpage.jsp" %>
<html>
<head>
    <title>Dodaj do koszyka</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<div class="container">

    <%

        Cart cart = (Cart) session.getAttribute("cart");


        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        CartItem cartItem = new CartItem(id, quantity);
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        cart.add(cartItem);

    %>

    <h2>Udało się dodać produkt do koszyka</h2>

    <a class="btn waves-effect waves-light" href="pokaz_zawartosc_koszyka.jsp">POKAŻ ZAWARTOŚĆ KOSZYKA</a>
    <a class="btn waves-effect waves-light" href="pokaz_wszystkie_produkty.jsp">KONTYNUUJ ZAKUPY</a>
    <a class="btn waves-effect waves-light" href="homepage.jsp">WRÓĆ</a>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
</div>

</body>
</html>
