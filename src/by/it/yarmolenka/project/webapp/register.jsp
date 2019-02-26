<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action="do?command=Register" method="post">
    <fieldset>

    <!-- Form Name -->
    <legend>Registration</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="login">login</label>
      <div class="col-md-4">
      <input id="login" name="login" type="text" placeholder="enter login" class="form-control input-md" required="" pattern="\w+">
    <font color="red">${loginExists}</font>
    <span class="help-block" style="color:green">Use latin letters, numbers and underline</span>
      </div>
    </div>

    <!-- Email input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="email">email</label>
      <div class="col-md-4">
        <input id="email" name="email" type="email" placeholder="enter email" class="form-control input-md" required="" pattern="\w+@[a-z]{2,}\.[a-z]{2,}">

      </div>
    </div>

    <!-- Password input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="password">password</label>
      <div class="col-md-4">
        <input id="password" name="password" type="password" placeholder="enter password" class="form-control input-md" required="" pattern="\w+">
 <span class="help-block" style="color:green">Use latin letters, numbers and underline</span>
      </div>
    </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Submit">Submit</label>
      <div class="col-md-4">
        <button id="Submit" name="Submit" class="btn btn-primary">Submit</button>
      </div>
    </div>

    </fieldset>
    </form>
</div>
</body>
</html>
