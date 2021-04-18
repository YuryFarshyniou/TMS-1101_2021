<%--
  Created by IntelliJ IDEA.
  User: USER1
  Date: 4/13/2021
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-8">

            <a href="change" target="_self">Edit</a>&nbsp &nbsp
            <a href="remove" target="_self">Remove</a>&nbsp &nbsp
            <a href="login" target="_self">Login</a>&nbsp &nbsp
            <a href="addPhone" target="_self">Add new Phone</a>&nbsp &nbsp
            <a href="admin" target="_self">Admin page</a>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Processor</th>
                </tr>

                </thead>
                <tbody>
                <c:forEach var="phone" items="${phones}" varStatus="status">
                    <tr>
                        <td>${status.index +1}</td>
                        <td>${phone.name}</td>
                        <td>${phone.price}</td>
                        <td>${phone.processor}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
            crossorigin="anonymous"></script>
</div>
</body>
</html>
