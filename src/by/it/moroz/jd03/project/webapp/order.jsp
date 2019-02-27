<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

<form class="form-horizontal" action="do?command=CreateOrder" method="post">
<fieldset>

<!-- Form Name -->
<legend>Menu</legend>

<!-- Button Drop Down -->
<div class="form-group">
  <label class="col-md-4 control-label" for="buttondropdown">Dish</label>
  <div class="col-md-4">
    <div class="input-group">
      <input id="buttondropdown" name="buttondropdown" class="form-control" placeholder="" type="text">
      <div class="input-group-btn">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">

          <span class="caret"></span>
        </button>
        <ul class="dropdown-menu pull-right">
          <li><a href="#">Option one</a></li>
          <li><a href="#">Option two</a></li>
          <li><a href="#">Option three</a></li>
        </ul>
      </div>
    </div>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="count">Count</label>
  <div class="col-md-4">
  <input id="count" name="count" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for=""></label>
  <div class="col-md-4">
    <button id="" name="" class="btn btn-primary">Order</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>