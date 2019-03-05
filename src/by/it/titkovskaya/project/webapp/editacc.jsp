<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <h5>${user.name}</h5>

    <h3>ACCOUNTS </h3>
    <div class="row">
        <div class=col-md-2>Account №</div>
        <div class=col-md-2>Account Balance</div>
        <div class=col-md-1>Currency</div>
        <div class=col-md-1>User ID</div>
        <div class=col-md-2>Account Status</div>
    </div>
    <c:forEach items="${accounts}" var="account">
        <form class="form-horizontal-${account.id}" action="do?command=EditAcc" method="post">
            <div class="row">
                <input id="id" name="id" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${account.id}">

                <div class="col-md-2">
                    <input id="number" name="number" type="text" placeholder="" class="form-control input-md"
                           required="" value="${account.number}">
                </div>

                <div class="col-md-2">
                    <input id="number" name="number" type="text" placeholder="" class="form-control input-md"
                           required="" value="${account.number}">
                </div>

                <div class="col-md-1">
                    <input id="currency" name="currency" type="text" placeholder="" class="form-control input-md"
                           required="" value="${account.currency}">
                </div>

                <div class="col-md-1">
                    <input id="users_id" name="users_id" type="text" placeholder="" class="form-control input-md"
                           required="" value="${account.users_id}">
                </div>

                <div class="col-md-2">
                    <select id="account_status_id" name="account_status_id" class="form-control">
                        <c:forEach items="${accstatuses}" var="status">
                        <option value="${status.id}"
                        ${account.account_status_id==status.id?"selected":""}>${status.status}</option>
                        </c:forEach>
                    </select>
                </div>

                <!-- Button -->
                <div class="col-md-2">
                    <button id="update" name="update" class="btn btn-success">Update status</button>
                </div>
            </div>
        </form>
    </c:forEach>

    <form class="form-horizontal" action="do?command=Profile" method="post">
        <fieldset>
            <!-- Button -->
            <div class="row">
                <div class="col-md-4">
                     <button id="profileButton" name="profileButton" class="btn btn-info">Back to PERSONAL CABINET</button>
                </div>
            </div>
        </fieldset>
    </form>

</div>
</body>
</html>