<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <p> ${user}</p>
    <p>*** Account Table *** ${accounts}</p>

    <form class="form-horizontal" method="post" action="do?command=Replenish">
        <fieldset>

            <!-- Form Name -->
            <legend>REPLENISHMENT</legend>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="accNumber">Enter account number</label>
              <div class="col-md-4">
              <input id="accNumber" name="accNumber" value="100000004" type="text" placeholder="" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="amount">Enter sum of refilling</label>
              <div class="col-md-4">
              <input id="amount" name="amount" value="10000" type="text" placeholder="" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Button -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="confirmTransfeButton"></label>
              <div class="col-md-4">
                <button id="confirmTransfeButton" name="confirmTransfeButton" class="btn btn-success">CONFIRM MONEY TRANSFER</button>
              </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>


