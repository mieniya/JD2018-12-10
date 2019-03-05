<html>
	<%@ include file="include/head.jsp" %>
	<body>
		<div class="container">
			<%@ include file="include/menu.jsp" %>
			<form class="form-horizontal" action="do?command=createRace" method="post">
				<fieldset>
					<legend>Create race</legend>

					<div class="form-group">
						<label class="col-md-4 control-label" for="date">Date</label>
						<div class="col-md-4">
							<input id="date" name="date" type="datetime-local" placeholder="date" class="form-control input-md" required="">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label" for="racetrack">Race track</label>
						<div class="col-md-4">
							<input id="racetrack" name="racetrack" type="text" placeholder="enter race track" class="form-control input-md" required="">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label" for="description">Description</label>
						<div class="col-md-4">
							<input id="description" name="description" type="text" placeholder="enter race description" class="form-control input-md" required="">
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