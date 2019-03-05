<html>
	<%@ include file="include/head.jsp" %>
	<body>
		<div class="container">
			<%@ include file="include/menu.jsp" %>
			<p>${user}</p>
			<form class="form-horizontal">
				<fieldset>
					<div class="form-group">
					  <div class="col-md-12">
						<button id="editevents" name="editevents" class="btn btn-success">Edit Events</button>
						<button id="editraces" name="editraces" class="btn btn-success">Edit Races</button>
						<button id="editusers" name="editusers" class="btn btn-success">Edit Users</button>
					  </div>
					</div>
				</fieldset>
			</form>
		</div>
	</body>
</html>
