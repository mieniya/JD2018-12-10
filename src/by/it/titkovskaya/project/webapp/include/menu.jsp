<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href=".">TIT Co Payment System</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="do?command=ChangeLang">
            <img src="images/globus.png" height="25px">RU</a>
            <a class="nav-item nav-link" href="do?command=ResetDB">Reset Database</a>
            <c:choose>
                <c:when test="${user.roles_id==1}">
                    <a class="nav-item nav-link" href="do?command=EditUsers">List of Users</a>
                    <a class="nav-item nav-link" href="do?command=EditAcc">List of Accounts</a>
                    <a class="nav-item nav-link" href="do?command=Profile">Personal Cabinet</a>
                    <a class="nav-item nav-link" href="do?command=Logout">Logout</a>
                </c:when>
                <c:when test="${user.roles_id==2}">
                    <a class="nav-item nav-link" href="do?command=CreateAcc">Create Account</a>
                    <a class="nav-item nav-link" href="do?command=AccTrans">Account Transactions</a>
                    <a class="nav-item nav-link" href="do?command=AccInfo">Account Info</a>
                    <a class="nav-item nav-link" href="do?command=Profile">Personal Cabinet</a>
                    <a class="nav-item nav-link" href="do?command=Logout">Logout</a>
                </c:when>
                <c:otherwise>
                    <a class="nav-item nav-link" href="do?command=SignUp">Sign up</a>
                    <a class="nav-item nav-link" href="do?command=Login">Sign in</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>