<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=Signup" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Signup</legend>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="login">Login</label>
              <div class="col-md-4">
              <input id="login" name="login" type="text" placeholder="YourLogin" class="form-control input-md" required="">
              <span class="help-block">Enter a login </span>
              </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="password">Password</label>
              <div class="col-md-4">
                <input id="password" name="password" type="password" placeholder="************" class="form-control input-md" required="">
                <span class="help-block">Enter a password (at least 5 characters)</span>
              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="name">Name</label>
              <div class="col-md-4">
              <input id="name" name="name" type="text" placeholder="Your Name" class="form-control input-md">
              <span class="help-block">How would you like to address you?</span>
              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="email">Email</label>
              <div class="col-md-4">
              <input id="email" name="email" type="text" placeholder="email@address.com" class="form-control input-md">
              <span class="help-block">Enter your email for getting feedback</span>
              </div>
            </div>

            <!-- Button -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="signup"></label>
              <div class="col-md-4">
                <button id="signup" name="signup" class="btn btn-primary">SIGN UP</button>
              </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>




