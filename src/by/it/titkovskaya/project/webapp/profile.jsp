<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <h5>${user.name}'s</h5>

    <h3>PERSONAL CABINET</h3>
    <p>____________________________________________</p>

    <form class="form-horizontal" action="do?command=Profile" method="get">
        <fieldset>
            <!-- Button -->
            <div class="row">
                <input id="command" name="command" type="hidden" placeholder=""
                class="form-control input-md" required="" value="Profile">
                <div class="col-md-6">
                     <button id="createAcc" name="createAcc" class="btn btn-inverse"> >>> CREATE Account</button>
                </div>
            </div>
        </fieldset>
    </form>

    <form class="form-horizontal" action="do?command=Profile" method="get">
        <fieldset>
            <!-- Button -->
            <div class="row">
                <input id="command" name="command" type="hidden" placeholder=""
                class="form-control input-md" required="" value="Profile">
                <div class="col-md-6">
                     <button id="accTrans" name="accTrans" class="btn btn-inverse"> >>> Account TRANSACTIONS</button>
                </div>
            </div>
        </fieldset>
    </form>




    <form class="form-horizontal" action="do" method="get">
        <fieldset>
            <!-- Button -->
            <div class="row">
                <input id="command" name="command" type="hidden" placeholder=""
                class="form-control input-md" required="" value="Profile">
                <div class="col-md-6">
                     <button id="accInfo" name="accInfo" class="btn btn-inverse"> >>> Current accounts INFORMATION</button>
                </div>
            </div>
        </fieldset>
    </form>

    <form class="form-horizontal" action="do?command=Profile" method="get">
        <fieldset>
            <!-- Button -->
            <div class="row">
                <input id="command" name="command" type="hidden" placeholder=""
                class="form-control input-md" required="" value="Profile">
                <div class="col-md-6">
                    <button id="accLock" name="accLock" class="btn btn-inverse"> >>> Account LOCK / UNLOCK</button>
                </div>
            </div>
        </fieldset>
    </form>

    <p>____________________________________________</p>

    <form class="form-horizontal" action="do?command=Profile" method="get">
        <fieldset>
            <!-- Button (Double) -->
            <div class="row">
                <input id="command" name="command" type="hidden" placeholder=""
                class="form-control input-md" required="" value="Profile">
                <div class="col-md-6">
                     <button id="userData" name="userData" class="btn btn-success">Update PERSONAL DATA</button>
                     <button id="logout" name="logout" class="btn btn-info">LOGOUT</button>
                </div>
            </div>
        </fieldset>
    </form>

</div>
</body>
</html>
