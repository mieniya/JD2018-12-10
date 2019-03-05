<html>
	<%@ include file="include/head.jsp" %>
	<body>
	<div class="container">
		<%@ include file="include/menu.jsp" %>
		<form class="form-horizontal" action="do?command=Login" method="post">
			<fieldset>
				<legend>Sign In</legend>

				<div class="form-group">
					<label class="col-md-4 control-label" for="login">Login</label>
					<div class="col-md-4">
						<input id="login" name="login" type="text" value="admin" placeholder="enter login" class="form-control input-md" required="">
						<font color="red">${noUser}</font>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="password">Password</label>
					<div class="col-md-4">
						<input id="password" name="password" type="password" value="adminpass" placeholder="enter password" class="form-control input-md" required="">
						<font color="red">${incorrectPass}</font>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-4">
						<button id="confirm" name="confirm" class="btn btn-primary">Confirm</button>
					</div>
				</div>

			</fieldset>
		</form>
	</div>
	</body>
</html>




