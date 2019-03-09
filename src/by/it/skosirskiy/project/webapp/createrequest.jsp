<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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

<!-- Form Name
             <div class="form-group">
                 <label class="col-md-4 control-label" for="user_id">user_id</label>
                     <div class="col-md-4">
                     <input id="user_id" name="user_id" value="2" type="text" placeholder="" class="form-control input-md" required="">
                     </div>
             </div>
             -->




              
              <select name="status_id" id="status_id" class="form-control">
                  <c:forEach  items="${statuses}" var="status">
                  <option value="${status.id}" >${status.status}</option>
                  </c:forEach>
              </select>

             <div class="form-group">
                   <label class="col-md-4 control-label" for="city">city</label>
                   <div class="col-md-4">
                   <input id="city" name="city" value="minsk" type="text" placeholder="" class="form-control input-md" required="">
                   </div>
              </div>



             <div class="form-group">
                 <label class="col-md-4 control-label" for="street">street</label>
                 <div class="col-md-4">
                 <input id="street" name="street" value="tanka" type="text" placeholder="" class="form-control input-md" required="">
                 </div>
             </div>



             <div class="form-group">
                              <label class="col-md-4 control-label" for="house">house</label>
                              <div class="col-md-4">
                              <input id="house" name="house" value="24B" type="text" placeholder="" class="form-control input-md" required="">
                              </div>
             </div>

             <div class="form-group">
                              <label class="col-md-4 control-label" for="flat">flat</label>
                              <div class="col-md-4">
                              <input id="flat" name="flat" value="2" type="text" placeholder="" class="form-control input-md" required="">
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

