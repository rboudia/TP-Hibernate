<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Mise à jour de l'Annonce</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>

<body class="container mt-4">

<h1 class="mb-4">Mise à jour de l'Annonce</h1>

<!-- Message d'alerte -->
<c:if test="${not empty message}">
    <div class="alert alert-warning" role="alert">
            ${message}
    </div>
</c:if>

<c:if test="${not empty annonce}">
    <form action="AnnonceUpdate" method="post">
        <!-- Champ caché pour l'ID -->
        <input type="hidden" name="id" value="${annonce.id}" />

        <div class="mb-3">
            <label for="title" class="form-label">Titre</label>
            <input type="text" class="form-control" id="title" name="title" value="${annonce.title}" required>
        </div>

        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <textarea class="form-control" id="description" name="description" required>${annonce.description}</textarea>
        </div>

        <div class="mb-3">
            <label for="adress" class="form-label">Adresse</label>
            <input type="text" class="form-control" id="adress" name="adress" value="${annonce.adress}" required>
        </div>

        <div class="mb-3">
            <label for="mail" class="form-label">Email</label>
            <input type="email" class="form-control" id="mail" name="mail" value="${annonce.mail}" required>
        </div>

        <button type="submit" class="btn btn-primary">Mettre à jour l'annonce</button>
    </form>
</c:if>

<a href="./AnnonceList" class="btn btn-secondary mt-4">Retour à la liste des annonces</a>

<!-- Bootstrap JS (optionnel) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
