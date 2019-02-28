<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <form class="form-horizontal" method="post" action="do?command=CreateAcc">
        <fieldset>

            <!-- Select Basic -->
            <legend>ACCOUNT CREATION</legend>

            <div class="form-group">
              <label class="col-md-4 control-label" for="currency">Choose account CURRENCY</label>
              <div class="col-md-4">
                <select id="currency" name="currency" class="form-control">
                  <option value="BYN">BYN</option>
                  <option value="USD">USD</option>
                  <option value="EUR">EUR</option>
                </select>
              </div>
            </div>

            <!-- Button -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="accountButton"></label>
              <div class="col-md-4">
                <button id="accountButton" name="accountButton" class="btn btn-success">CREATE ACCOUNT</button>
              </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>


