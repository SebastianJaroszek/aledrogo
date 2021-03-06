<%@ page import="pl.dominisz.ProductRepository" %>
<%@ page import="pl.dominisz.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="errorpage.jsp" %>
<html>
<head>
    <title>Pokaż wszystkie produkty</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<div class="container">
    <%!
        ProductRepository productRepository = ProductRepository.getInstance();
    %>
    <h2>Lista wszystkich produktów w sklepie</h2>
    <%
        List<Product> allProducts = productRepository.findAll();
    %>
    <ul class="collection">
        <%
            for (Product product : allProducts) {
                /*out.write(showProduct(product));*/
        %>
        <li class="collection-item">
            <%= product.getName() %>, cena: <%= product.getPrice()%> zł,
            <a href="pokaz_szczegoly_produktu.jsp?id=<%= product.getId()%>">pokaż szczegóły</a>
        </li>
        <%
            }

        %>
    </ul>
    <%
        /*createBackLink(out);*/
    %>
    <a class="btn waves-effect waves-light" href="homepage.jsp">WRÓĆ<i class="material-icons right">send</i></a>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <br><br>
</div>

</body>
</html>
