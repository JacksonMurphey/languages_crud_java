<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
                crossorigin="anonymous">
<meta charset="UTF-8">
<title>Language</title>
</head>
<body>
<jsp:include page="base.jsp"></jsp:include>

<h1 class="m-4"><c:out value="${lang.name}"/></h1>
<p class="m-4">Description: <c:out value="${lang.creator}"/></p>
<p class="m-4">Language: <c:out value="${lang.version}"/></p>

<a href="/languages/edit/${lang.id}" class="m-4">Edit</a>
<a href="/languages/delete/${lang.id}"class="m-4">Delete</a>

<a class="m-4 btn btn-primary" href="/languages">Home</a>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>
</body>
</html>