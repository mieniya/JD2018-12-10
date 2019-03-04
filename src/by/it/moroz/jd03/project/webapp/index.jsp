<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <div class="row">
        <div class="col-md-2">Dish</div>
        <div class="col-md-2">Price</div>
    </div>

    <c:forEach items="${menu}" var="menu">
    <div class="row">
        <div class="col-md-2">${menu.name}</div>
        <div class="col-md-2">${menu.price}</div>
    </div>
    </c:forEach>
</div>
</body>
</html>
