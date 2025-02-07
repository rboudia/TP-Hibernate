<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>

<% if (request.getAttribute("message") != null) { %>
<h1><%= request.getAttribute("message") %>
</h1>
<% } %>


<h2>Entrez votre nom :</h2>

<form action="" method="post">
    <input type="text" name="nom" required>
    <button type="submit">Envoyer</button>
</form>

</body>
</html>


