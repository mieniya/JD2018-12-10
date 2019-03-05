<html>
	<%@ include file="include/head.jsp" %>
	<body>
		<div class="container">
			<%@ include file="include/menu.jsp" %>
			<form class="form-horizontal" action="do?command=EditRace" method="post">
				<fieldset>
					<legend>${race==null?"Create":"Edit"} race</legend>

					<div class="form-group" width="80">
						<label class="col-md-4 control-label" for="time">Date</label>
						<div class="col-md-4">
							<input id="date" name="date" type="datetime-local" value="${race.date}" placeholder="date" class="form-control input-md" required="">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label" for="racetrack">Race track</label>
						<div class="col-md-4">
							<input id="racetrack" name="racetrack" type="text" value="${race.race_track}" placeholder="enter race track" class="form-control input-md" required="">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label" for="description">Description</label>
						<div class="col-md-4">
							<input id="description" name="description" type="text" value="${race.description}" placeholder="enter race description" class="form-control input-md" required="">
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