<html>
	<%@ include file="include/head.jsp" %>
	<body>
		<div class="container">
			<%@ include file="include/menu.jsp" %>
			<p>${user}</p>
			<form class="form-horizontal" action="do?command=GetUsers" method="post">
				<fieldset>
					<div class="form-group">
						<button id="listusers" name="listusers" class="btn btn-primary">List of users</button>
					</div>
				</fieldset>
			</form>
			<form class="form-horizontal" action="do?command=GetRaces" method="post">
				<fieldset>
					<div class="form-group">
						<button id="listraces" name="listraces" class="btn btn-primary">List of races</button>
					</div>
				</fieldset>
			</form>
			<form class="form-horizontal" action="do?command=GetEvents" method="post">
				<fieldset>
					<div class="form-group">
						<button id="listevents" name="listevents" class="btn btn-primary">List of events</button>
					</div>
				</fieldset>
			</form>
		</div>
	</body>
</html>