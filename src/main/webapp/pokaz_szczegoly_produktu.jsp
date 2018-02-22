<%@ page import="pl.dominisz.ProductRepository" %>
<%@ page import="pl.dominisz.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="errorpage.jsp" %>
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
    <h2>Szczegółowe dane o produkcie</h2>

    <%
        int id = Integer.valueOf(request.getParameter("id"));
        Product product = productRepository.findById(id);

    %>
    <ul class="collection">
        <li class="collection-item">Nazwa produktu: <%=product.getName()%>
        </li>
        <li class="collection-item">Opis produktu: <%=product.getDescription()%>
        </li>
        <li class="collection-item">Cena produktu: <%=product.getPrice()%> zł</li>
        <li class="collection-item">
            <form action="dodaj_do_koszyka.jsp" method="POST">
                <br><br>Liczba sztuk: <input type="number" name="quantity" value="1">
                ilość dostępnych sztuk: <%=product.getCount()%>
                <br><br>
                <input type="hidden" name="id" value="<%=id%>">

                <input class="waves-effect waves-light btn" type="submit" value="DODAJ DO KOSZYKA">
            </form>
        </li>
    </ul>
    <a class="btn waves-effect waves-light" href="pokaz_wszystkie_produkty.jsp">WRÓĆ</a>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <br><br>
</div>

</body>
</html>
