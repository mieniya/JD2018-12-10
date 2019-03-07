<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<a href = "<c:url value = "/do?command=EditUsers"/>">EDIT USERS</a><br>
<a href = "<c:url value = "/do?command=CreateUser"/>">CREATE USER</a><br>
<a href = "<c:url value = "/do?command=ViewUsers"/>">VIEW USERS</a><br>

</div>
</body>
</html>