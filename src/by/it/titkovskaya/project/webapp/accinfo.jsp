<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <p> ${user}</p>
    <p>*** Account Table *** ${accounts}</p>

    <form class="form-horizontal" method="post" action="do?command=AccInfo">
        <fieldset>

            <!-- Form Name -->
            <legend>ACCOUNT DETAILS</legend>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="AccInfo">For detailed information enter account number</label>
              <div class="col-md-4">
              <input id="accNumber" name="accNumber" value="100000004" type="text" placeholder="" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Button -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="accInfoButton"></label>
              <div class="col-md-4">
                <button id="accInfoButton" name="accInfoButton" class="btn btn-success">GET INFO</button>
              </div>
            </div>

        </fieldset>
    </form>

    <p> ${replenishments}</p>
    <p> ${payments}</p>

</div>
</body>
</html>


