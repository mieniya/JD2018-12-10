<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="/../include/head.jsp" %>
<body>
    <div class="container">
        <%@ include file="/../include/menucash.jsp" %>
        <%@ include file="/../include/menucashnew.jsp" %>
        <br>
        <p>Cash MAIN ${message}</p>
         <h5> Пользователь ${user.login}</h5>
         <p>duties: ${duties}</p>
         <p>notduties: ${notduties}</p>
    </div>
</body>
</html>
