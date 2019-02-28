<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <p> ${user}</p>
    <p>*** Account Table *** ${accounts}</p>

    <form class="form-horizontal" method="post" action="do?command=AccLock">
        <fieldset>

            <!-- Form Name -->
            <legend>ACCOUNT LOCK</legend>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="accNumber">Enter account number</label>
              <div class="col-md-4">
              <input id="accNumber" name="accNumber" type="text" placeholder="" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Multiple Radios -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="accLock">Select operation required</label>
              <div class="col-md-4">
              <div class="radio">
                <label for="accLock-0">
                  <input type="radio" name="status" id="accLock-0" value="lock" checked="checked">
                  LOCK account
                </label>
            	</div>
              <div class="radio">
                <label for="accLock-1">
                  <input type="radio" name="status" id="accLock-1" value="unlock">
                  Send UNLOCK request
                </label>
            	</div>
              </div>
            </div>

            <!-- Button -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="lockButton"></label>
              <div class="col-md-4">
                <button id="lockButton" name="lockButton" class="btn btn-success">CONFIRM</button>
              </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>


