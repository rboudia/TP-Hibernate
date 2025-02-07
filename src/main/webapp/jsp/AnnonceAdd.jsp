<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Annonce Add</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div>
    <h1>Add Annonce</h1>

    <c:if test="${requestScope.message != null}">
        <div class="alert alert-warning" role="alert">
                ${requestScope.message}
        </div>
    </c:if>

    <form role="form" method="post" action="" name="annonceForm" class="well">
        <div class="form-group">
            <label for="title">Title :</label>
            <input type="text" class="form-control" name="title" id="title" placeholder="Enter title"
                   required>
        </div>

        <div class="form-group">
            <label for="description">Description :</label>
            <textarea class="form-control" name="description" id="description" placeholder="Description"
                      required></textarea>
        </div>

        <div class="form-group">
            <label for="adress">Adress :</label>
            <input type="text" class="form-control" name="adress" id="adress" placeholder="Enter adress"
                   required>
        </div>

        <div class="form-group">
            <label for="mail">Mail :</label>
            <input type="email" class="form-control" name="mail" id="mail" placeholder="Enter mail"
                   required>
        </div>

        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
</body>
</html>
