<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ajouter une Annonce</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-body">
            <h1 class="text-center text-primary">Ajouter une Annonce</h1>

            <c:if test="${requestScope.message != null}">
                <div class="alert alert-warning text-center" role="alert">
                        ${requestScope.message}
                </div>
            </c:if>

            <form method="post" action="" name="annonceForm">
                <div class="mb-3">
                    <label for="title" class="form-label">Titre :</label>
                    <input type="text" class="form-control" name="title" id="title" placeholder="Entrez le titre" required>
                </div>

                <div class="mb-3">
                    <label for="description" class="form-label">Description :</label>
                    <textarea class="form-control" name="description" id="description" rows="3" placeholder="Entrez la description" required></textarea>
                </div>

                <div class="mb-3">
                    <label for="adress" class="form-label">Adresse :</label>
                    <input type="text" class="form-control" name="adress" id="adress" placeholder="Entrez l'adresse" required>
                </div>

                <div class="mb-3">
                    <label for="mail" class="form-label">Email :</label>
                    <input type="email" class="form-control" name="mail" id="mail" placeholder="Entrez l'email" required>
                </div>

                <button type="submit" class="btn btn-primary w-100">Enregistrer</button>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
