<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hello World</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<%@include file="menu.jsp"%>

<div class="d-flex justify-content-between align-items-center mb-4">
    <% if (request.getAttribute("message") != null) { %>
    <h1><%= request.getAttribute("message") %></h1>
    <% } %></div>



<h2 class="mb-4">Entrez votre nom :</h2>

<form action="" method="post">
    <div class="mb-3">
        <input type="text" name="nom" class="form-control" required placeholder="Votre nom">
    </div>
    <button type="submit" class="btn btn-primary">Envoyer</button>
</form>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
