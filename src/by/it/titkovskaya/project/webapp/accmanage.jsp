<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <p> ${user}</p>
    <p>*** Account Table *** ${accounts}</p>

    <form class="form-horizontal" method="post" action="do?command=AccManage">
        <fieldset>

            <!-- Form Name -->
            <legend>ACCOUNT MANAGEMENT</legend>

            <!-- Multiple Radios -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="operation">SELECT OPERATION REQUIRED</label>
              <div class="col-md-4">
              <div class="radio">
                <label for="operation-0">
                  <input type="radio" name="operation" id="operation-0" value="Replenish" checked="checked">
                  Replenish account
                </label>
            	</div>
              <div class="radio">
                <label for="operation-1">
                  <input type="radio" name="operation" id="operation-1" value="Payment">
                  Make payment
                </label>
            	</div>
              <div class="radio">
                <label for="operation-2">
                  <input type="radio" name="operation" id="operation-2" value="AccLock">
                  Lock/Unlock account
                </label>
            	</div>
              </div>
            </div>

            <!-- Button -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="accManageButton"></label>
              <div class="col-md-4">
                <button id="accManageButton" name="accManageButton" class="btn btn-success">CONFIRM</button>
              </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>


