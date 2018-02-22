<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Random" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page errorPage="errorpage.jsp" %>
<html>
<body>

<%
    for (int i = 0; i < 5; i++) {
        out.write("numer: " + i + "<br>");
    }
%>

<%= "dzień dobry" %>

<br>
<br>
<br>
<h1>To jest przykład strony JSP</h1>
Dzisiaj jest:
<%
    LocalDateTime dateTime = LocalDateTime.now();
    out.write(dateTime.toString());
%>
<br>
Wpisany adres:
<%= request.getRequestURL().toString() %>
<br>
Losowe liczby:
<%
    Random random = new Random();
    int sum = 0;
    for (int i = 0; i < 10; i++) {
        int randomInt = random.nextInt(1000);
        sum = sum + randomInt;
        out.write(" " + randomInt);
    }
%>
<br>
Suma liczb:
<%= sum %>
<br>
<br>
<%!
    int licznikWywolan = 0;

    void powitanie() {
        String nic = "Tu nic nie ma";
    }

%>
Strona została wywołana <%= ++licznikWywolan %> razy
</body>
</html>
