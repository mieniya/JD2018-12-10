<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <!-- Form Name -->
    <legend>Checkout</legend>
    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="name">Name</label>
      <div class="col-md-4">
      <input id="name" name="name" type="text" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="tel">Telephone</label>
      <div class="col-md-4">
      <input id="tel" name="tel" type="text" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="cardnumber">Card Number</label>
      <div class="col-md-4">
      <input id="cardnumber" name="cardnumber" type="text" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Button (Double) -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="button1id"></label>
      <div class="col-md-8">
        <button id="button1id" name="button1id" class="btn btn-success">Payment</button>
        <button id="button2id" name="button2id" class="btn btn-danger">Cancel</button>
      </div>
    </div>
</div>
</body>
</html>