<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    User: ${user}
    <br>

    <form class="form-horizontal" action="do?command=Login" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Log in</legend>

            <!-- Text input-->
            <div class="form-group">
                 <label class="col-md-4 control-label" for="email">Email</label>
                 <div class="col-md-4">
                     <input id="email" name="email" type="text" placeholder="" class="form-control input-md">

                 </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login"></label>
                <div class="col-md-4">
                    <button id="login" name="login" class="btn btn-primary">Log in</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
