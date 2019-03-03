<html>
<%@ include file="/../include/head.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<body>
<div class="container">
    <%@ include file="/../include/menucashnew.jsp" %>
    <br>
    <p>Cash Operation ${message}</p>
    <form class="form-horizontal">
              <fieldset>
              <legend>Коммунальный платеж</legend>
              <div class="form-group">
                <label class="col-md-4 control-label" for="selectbasic">currency</label>
                <div class="col-md-4">
                  <select id="selectbasic" name="selectbasic" class="form-control">
                    <option value="643">Rossiya</option>
                    <option value="840">USD</option>
                    <option value="978">EUR</option>
                  </select>
                </div>
              </div>

              <div class="form-group">
                <label class="col-md-4 control-label" for="Summa">Summa</label>
                <div class="col-md-4">
                <input id="Summa" name="Summa" type="text" placeholder="summa" class="form-control input-md" required="">
                </div>
              </div>
              </fieldset>
    </form>
</div>
</body>
</html>
