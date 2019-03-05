<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
    <div class="container">
    <%@ include file="include/menu.jsp" %>
    <h5>${user.name}</h5>

    <h3>WELCOME!</h3>

    <form class="form-horizontal" action="do?command=Login" method="post">
        <fieldset>

            <!-- Text input-->
            <div class="row">
                <label class="col-md-4 control-label" for="login">Login</label>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <input id="login" name="login" value="testLogin" type="text" placeholder="YourLogin" class="form-control input-md" required="">
                </div>
            </div>

            <!-- Password input-->
            <div class="row">
                <label class="col-md-4 control-label" for="password">Password</label>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <input id="password" name="password" value="testPassword" type="password" placeholder="************" class="form-control input-md" required="">
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="loginButton"></label>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <button id="loginButton" name="loginButton" class="btn btn-success">SIGN IN</button>
                </div>
            </div>

        </fieldset>
    </form>

    <div class="row">
        <label class="col-md-4 control-label" for="message">${message}</label>
    </div>

</div>
</body>
</html>

