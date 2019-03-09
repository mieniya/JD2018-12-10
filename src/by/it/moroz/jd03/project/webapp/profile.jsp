<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action="do?command=Profile" method="post">
<fieldset>
    <h3>Hello, ${user.login}</h3>
    <div class="form-group">
    <label class="col-md-3 control-label" for="email">Email</label>
        <div class="col-md-3">
           <input id="email" name="email" type="text" placeholder="" class="form-control input-md"
           required="" value="${user.email}">
        </div>
    </div>
    <div class="form-group">
    <label class="col-md-3 control-label" for="address">Address</label>
        <div class="col-md-3">
           <input id="address" name="address" type="text" placeholder="" class="form-control input-md"
           required="" value="${user.address}">
        </div>
    </div>
    <div class="form-group">
    <label class="col-md-3 control-label" for="name">Name</label>
        <div class="col-md-3">
           <input id="name" name="name" type="text" placeholder="" class="form-control input-md"
           required="" value="${user.name}">
        </div>
    </div>
    <div class="form-group">
    <label class="col-md-3 control-label" for="surname">Surname</label>
        <div class="col-md-3">
           <input id="surname" name="surname" type="text" placeholder="" class="form-control input-md"
           required="" value="${user.surname}">
        </div>
    </div>
    <div class="form-group">
    <label class="col-md-3 control-label" for="numberphone">NumberPhone</label>
        <div class="col-md-3">
           <input id="numberphone" name="numberphone" type="text" placeholder="" class="form-control input-md"
           required="" value="${user.numberphone}">
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-0.5">
           <button id="save" name="save" class="btn btn-primary">Save</button>
        </div>
    </div>
     <p></p>
        <p>История заказов:</>
         <p>${orders}</p>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" class="btn btn-primary">Log out</button>
                </div>
            </div>

</fieldset>
</form>
</div>
</body>
</html>
