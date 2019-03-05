<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <h5>${user.name}</h5>

    <h3>ACCOUNT DETAILS</h3>
    <p>____________________________________________________________________________________________________</p>
    <div class="row">
        <div class="col-md-2">Number</div>
        <div class="col-md-2">Account Balance</div>
        <div class="col-md-2">Currency</div>
        <div class="col-md-2">Status</div>
    </div>
    <p>____________________________________________________________________________________________________</p>
    <c:forEach items="${accounts}" var="account">
        <form class="form-horizontal-${account.id}" action="do" method="get">
            <div class="row">
                <input id="command" name="command" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="AccInfo">

                <input id="id" name="id" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${account.id}">

                <div class="col-md-2">${account.number}</div>
                <div class="col-md-2">${account.number}</div>
                <div class="col-md-2">${account.currency}</div>
                <c:forEach items="${accstatuses}" var="status">
                    <c:if test="${account.account_status_id==status.id}">
                        <div class="col-md-1">${status.status}</div>
                    </c:if>
                </c:forEach>


                <!-- Button -->
                <div class="col-md-4">
                    <button id="accInfoButton" name="accInfoButton" class="btn btn-success">Get ACCOUNT STATEMENT</button>
                </div>
            </div>
        </form>
    </c:forEach>
    <p>____________________________________________________________________________________________________</p>

    <h5>${messageInfo}</h5>
    <p>${headInfo}</p>
    <h6>${replenInfo}</h6>
    <c:forEach items="${replenishments}" var="replenishment">
        <form class="form-horizontal-${account.id}">
            <div class="row">
                <input id="id" name="id" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${replenishment.id}">
                <div class="col-md-1">${replenishment.amount}</div>
                <div class="col-md-2">${replenishment.date}</div>
            </div>
        </form>
    </c:forEach>

    <h6>${paymentInfo}</h6>
    <c:forEach items="${payments}" var="payment">
        <form class="form-horizontal-${account.id}">
            <div class="row">
                <input id="id" name="id" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${payment.id}">
                <div class="col-md-1">${payment.amount}</div>
                <div class="col-md-2">${payment.date}</div>
                <div class="col-md-3">${payment.recipient}</div>
            </div>
        </form>
    </c:forEach>

    <form class="form-horizontal" action="do?command=Profile" method="post">
        <fieldset>
            <!-- Button -->
            <div class="row">
                <div class="col-md-4">
                     <button id="profileButton" name="profileButton" class="btn btn-info">Back to PERSONAL CABINET</button>
                </div>
            </div>
        </fieldset>
    </form>

</div>
</body>
</html>


