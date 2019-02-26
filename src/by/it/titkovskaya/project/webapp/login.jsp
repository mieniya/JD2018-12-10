<html>
<%@ include file="include/head.jsp" %>
<body>
    <div class="container">
    <%@ include file="include/menu.jsp" %>

    User: ${user}
    <br>

    <form class="form-horizontal" action="do?command=Login" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Login</legend>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="login">Login</label>
              <div class="col-md-4">
              <input id="login" name="login" type="text" placeholder="YourLogin" class="form-control input-md" required="">
              <span class="help-block">Enter your login</span>
              </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="password">Password</label>
              <div class="col-md-4">
                <input id="password" name="password" type="password" placeholder="************" class="form-control input-md" required="">
                <span class="help-block">Enter your password</span>
              </div>
            </div>

            <!-- Button -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="loginButton"></label>
              <div class="col-md-4">
                <button id="loginButton" name="loginButton" class="btn btn-primary">SIGN IN</button>
              </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>

