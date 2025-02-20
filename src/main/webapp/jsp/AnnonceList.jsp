<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Liste des Annonces</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .card:hover {
            transform: translateY(-2px);
            transition: all 0.3s ease;
        }
    </style>
</head>

<body class="container mt-4">

<%@include file="menu.jsp"%>

<div class="d-flex justify-content-between align-items-center mb-4">
    <h1 class="text-primary">Liste des Annonces (${fn:length(annonceList)})</h1>
    <a href="./AnnonceAdd" class="btn btn-success">+ Ajouter une annonce</a>
</div>

<c:if test="${requestScope.message != null}">
    <div class="alert alert-warning" role="alert">
            ${requestScope.message}
    </div>
</c:if>

<c:if test="${fn:length(annonceList) eq 0}">
    <div class="alert alert-info" role="alert">
        <strong>Aucune annonce disponible.</strong>
        <a href="./AnnonceAdd" class="btn btn-sm btn-primary ms-2">Créer une annonce</a>
    </div>
</c:if>

<div class="row">
    <c:forEach var="item" items="${annonceList}">
        <div class="col-md-6 col-lg-4">
            <div class="card shadow-sm mb-4">
                <div class="card-body">
                    <h5 class="card-title text-primary">${item.title}</h5>
                    <p class="card-text text-muted">${item.mail}</p>
                    <p class="text-muted"><fmt:formatDate value="${item.date}" pattern="dd/MM/yyyy HH:mm:ss"/></p>
                    <a href="./AnnonceRead?id=${item.id}" class="btn btn-outline-primary btn-sm">
                        Voir plus
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    </a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
