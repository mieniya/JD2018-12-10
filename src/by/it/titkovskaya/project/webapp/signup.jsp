<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <h5>${user.name}</h5>
    <h3>WELCOME! Fill in the form, please</h3>

    <form class="form-horizontal" action="do?command=Signup" method="post">
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
                <span class="help-block">at least 5 characters required</span>
              </div>
            </div>

            <!-- Text input-->
            <div class="row">
              <label class="col-md-4 control-label" for="name">Name</label>
            </div>
            <div class="row">
              <div class="col-md-4">
              <input id="name" name="name" value="Test Name" type="text" placeholder="Your Name" class="form-control input-md">
              </div>
            </div>

            <!-- Text input-->
            <div class="row">
              <label class="col-md-4 control-label" for="email">Email</label>
            </div>
            <div class="row">
              <div class="col-md-4">
              <input id="email" name="email" value="test@email.com" type="text" placeholder="email@address.com" class="form-control input-md">
              </div>
            </div>

            <!-- Button -->
            <div class="row">
              <label class="col-md-4 control-label" for="signup"></label>
            </div>
            <div class="row">
              <div class="col-md-4">
                <button id="signup" name="signup" class="btn btn-success">SIGN UP</button>
              </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>




