<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=OpenAcc" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>OpenAcc</legend>

            <!-- Select Basic -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="selectCurrency">Select currency to create an account</label>
              <div class="col-md-4">
                <select id="selectCurrency" name="selectCurrency" class="form-control">
                  <option value="">BYN</option>
                  <option value="">USD</option>
                  <option value="">EUR</option>
                  <option value="">RUB</option>
                </select>
              </div>
            </div>

            <!-- Button -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="accountButton"></label>
              <div class="col-md-4">
                <button id="accountButton" name="accountButton" class="btn btn-primary">CREATE ACCOUNT</button>
              </div>
            </div>

        </fieldset>
    </form>








</div>
</body>
</html>


