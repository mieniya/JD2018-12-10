<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <h5>${user.name}</h5>

    <h3>PERSONAL DATA</h3>
    <p>_____________________________________________________</p>

    <form class="form-horizontal" action="do?command=UserData" method="post">
        <fieldset>

            <div class="row">
              <label class="col-md-1 control-label" for="login">Login</label>
              <div class="col-md-3">
              <input id="login" name="login" value="${user.login}" type="text"
              placeholder="" class="form-control input-md" required="">
              </div>
            </div>

            <div class="row">
              <label class="col-md-1 control-label" for="password">Password</label>
              <div class="col-md-3">
                <input id="password" name="password" value="${user.password}" type="password"
                placeholder="" class="form-control input-md" required="">
              </div>
            </div>

            <div class="row">
              <label class="col-md-1 control-label" for="email">Email</label>
              <div class="col-md-3">
              <input id="email" name="email" value="${user.email}" type="text"
              placeholder="" class="form-control input-md">
              </div>
            </div>

            <div class="row">
              <label class="col-md-1 control-label" for="name">Name</label>
              <div class="col-md-3">
              <input id="name" name="name" value="${user.name}" type="text"
              placeholder="" class="form-control input-md">
              </div>
            </div>
    <p>_____________________________________________________</p>

            <!-- Button -->
            <div class="row">
              <label class="col-md-4 control-label" for="update"></label>
            </div>
            <div class="row">
              <div class="col-md-4">
                <button id="update" name="update" class="btn btn-success">UPDATE data</button>
                <button id="profileButton" name="profileButton" class="btn btn-info">Back to PERSONAL CABINET</button>
              </div>
            </div>

        </fieldset>
    </form>

    <p>${message}</p>

</div>
</body>
</html>