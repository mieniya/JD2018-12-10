<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    Request: ${request}
    <br>

    <form class="form-horizontal" action="do?command=createRequest" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>createRequest</legend>


            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="type">type</label>
                <div class="col-md-4">
                    <input id="type" name="type" value="testTypen" type="text" placeholder="" class="form-control input-md" required="">
                </div>
            </div>


             <div class="form-group">
                 <label class="col-md-4 control-label" for="user_id">user_id</label>
                     <div class="col-md-4">
                     <input id="user_id" name="user_id" value="2" type="text" placeholder="" class="form-control input-md" required="">
                     </div>
             </div>

             <div class="form-group">
                              <label class="col-md-4 control-label" for="status_id">status_id</label>
                                  <div class="col-md-4">
                                  <input id="status_id" name="status_id" value="2" type="text" placeholder="" class="form-control input-md" required="">
                                  </div>
              </div>

             <div class="form-group">
                 <label class="col-md-4 control-label" for="address_id">address_id</label>
                 <div class="col-md-4">
                 <input id="address_id" name="user_id" value="2" type="text" placeholder="" class="form-control input-md" required="">
                 </div>
             </div>





            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="createrequest"></label>
                <div class="col-md-4">
                    <button id="requestButton" name="requestButton" class="btn btn-primary">Request</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>

