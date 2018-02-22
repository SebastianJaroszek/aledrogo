<%@ page import="pl.dominisz.ProductRepository" %>
<%@ page import="pl.dominisz.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Szczegóły produktu</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>

<div class="container">
    <%!
        ProductRepository productRepository = ProductRepository.getInstance();
    %>
    <h1>Szczegółowe dane o produkcie</h1>

    <%
        int id = Integer.valueOf(request.getParameter("id"));
        Product product = productRepository.findById(id);
        if (product != null) {

    %>Nazwa produktu: <%=product.getName()%>
    <br><br>Opis produktu: <%=product.getDescription()%>
    <br><br>Cena produktu: <%=product.getPrice()%> zł
    <form action="addToCart" method="POST">
        <br><br>Liczba sztuk: <input type="number" name="quantity" value="1">
        ilość dostępnych sztuk: <%=product.getCount()%>
        <br><br>
        <input type="hidden" name="id" value="<%=id%>">

        <br><input type="submit" value="dodaj do koszyka">
    </form>
    <%
            /*createBackLink(out);*/
        }
    %>

</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>
