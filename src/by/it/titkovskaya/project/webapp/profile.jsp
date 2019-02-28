<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <p>Glad to see you again ${user}</p>
    <p>Счета пользователя (на русском для проверки работы encode): ${accounts}</p>

    <form class="form-horizontal" action="do?command=Logout" method="post">
            <fieldset>

                <!-- Form Name -->
                <legend>PROFILE</legend>

                <p>For getting information on current accounts select ACCOUNT INFO</p>
                <p>For conducting transfers select ACCOUNT MANAGEMENT</p>
                <p>For opening an additional account select CREATE ACCOUNT</p>

                <!-- Button -->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="logoutButton">If you already finished your work press:</label>
                  <div class="col-md-4">
                    <button id="logoutButton" name="logoutButton" class="btn btn-success">Logout</button>
                  </div>
                </div>

            </fieldset>
        </form>

</div>
</body>
</html>
