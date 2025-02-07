<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Détails de l'Annonce</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>

<body class="container mt-4">

<h1 class="mb-4 text-center">Détails de l'Annonce</h1>

<!-- Message d'alerte si l'annonce n'a pas été trouvée -->
<c:if test="${not empty message}">
  <div class="alert alert-warning" role="alert">
      ${message}
  </div>
</c:if>

<!-- Si l'annonce est présente, afficher ses détails -->
<c:if test="${not empty annonce}">
  <div class="card">
    <div class="card-header">
      <h3 class="card-title">${annonce.title}</h3>
    </div>
    <div class="card-body">
      <p><strong>Description :</strong> ${annonce.description}</p>
      <p><strong>Adresse :</strong> ${annonce.adress}</p>
      <p><strong>Email :</strong> ${annonce.mail}</p>
      <p><strong>Date de publication :</strong>
        <fmt:formatDate value="${annonce.date}" pattern="dd/MM/yyyy HH:mm:ss" />
      </p>
    </div>
  </div>
  <a href="./AnnonceList" class="btn btn-primary mt-4">Retour à la liste des annonces</a>
  <a href="./AnnonceUpdate?id=${annonce.id}" class="btn btn-primary mt-4">Update</a>
  <a href="./AnnonceDelete?id=${annonce.id}" class="btn btn-primary mt-4">Delete</a>
</c:if>



</body>
</html>
