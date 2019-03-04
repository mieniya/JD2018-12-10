<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>

<body>
    <div class="container">
        <%@ include file="include/menu.jsp" %>

        <div class="row">
            <div class="col-md-3">NAME</div>
            <div class="col-md-3">PRICE</div>
            <div class="col-md-3">DESCRIPTION</div>
            <div class="col-md-3">CATEGORY</div>
        </div>
        <c:forEach items="${products}" var="product">
            <div class="row">
                <div class="col-md-3">${product.name}</div>
                <div class="col-md-3">${product.price}</div>
                <div class="col-md-3">${product.description}</div>
                <c:choose>
                    <c:when test="${product.categories_id == 1}">
                        <div class="col-md-3">consoles</div>
                    </c:when>
                    <c:when test="${product.categories_id == 2}">
                        <div class="col-md-3">games</div>
                    </c:when>
                    <c:when test="${product.categories_id == 3}">
                        <div class="col-md-3">assessorise</div>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:forEach>
    </div>
</body>

</html>