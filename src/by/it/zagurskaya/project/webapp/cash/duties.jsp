<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="/../include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="/../include/menucashnew.jsp" %>
    <br>
    <p>Cash DUTIES ${message}</p>
     <p>User: ${user}</p>
     <p>User: ${user.login}</p>
     <p>User: ${user.id}</p>
     <p>duties: ${duties}</p>
     <p>duties: ${duties.timestamp}</p>
     <p>duties: ${duties.id}</p>
           <form class="form-horizontal" action="do?command=Duties" method="post">
           <fieldset>

           <legend>Form Name</legend>

               <div class="form-group">
                 <label class="col-md-4 control-label" for="button1id">Duties</label>
                 <div class="col-md-8">
                   <button id="open" name="open" class="btn btn-success">Open</button>
                   <button id="close" name="close" class="btn btn-danger">Close</button>
                 </div>
               </div>

           </fieldset>
           </form>
</div>
</body>
</html>
