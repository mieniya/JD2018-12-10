<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action="do?command=LogOut" method="post">
<fieldset>

<!-- Form Name -->
<legend>LogOut</legend>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logout"></label>
  <div class="col-md-4">
    <button id="logout" name="logout" class="btn btn-primary">LogOut</button>
  </div>
</div>

</fieldset>
</form></div>
</body>
</html>

