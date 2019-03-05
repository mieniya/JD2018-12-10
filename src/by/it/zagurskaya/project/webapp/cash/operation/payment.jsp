<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="/../include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="/../include/menucashnew.jsp" %>
    <br>
    <br>
    <br>
    <p>Cash Operation ${message}</p>
     <form class="form-horizontal" action="do?command=Payment" method="post">
        <fieldset>
        <legend>Select Operation</legend>
            <div class="col-md-4">
                <select id="SprOperationsId" name="SprOperationsId" class="form-control">
                    <c:forEach items="${sprOperationsAll}" var="sprOperationsAll">
                    <option value="${sprOperationsAll.id}" >${sprOperationsAll.name}</option>
                    </c:forEach>
                </select>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="enterButton"></label>
                <div class="col-md-4">
                    <button id="enterButton" name="enterButton" class="btn btn-primary">Вперед</button>
                </div>
            </div>
        </fieldset>
     </form>
</div>
</body>
</html>
