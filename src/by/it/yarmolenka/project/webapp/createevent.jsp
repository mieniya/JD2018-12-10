<html>
	<%@ include file="include/head.jsp" %>
	<body>
		<div class="container">
			<%@ include file="include/menu.jsp" %>
			<form class="form-horizontal" action="do?command=createEvent" method="post">
				<fieldset>
					<legend>Create Event</legend>

					<div class="form-group">
						<label class="col-md-4 control-label" for="selectrace">Select Race</label>
						<div class="col-md-4">
							<select id="selectrace" name="selectrace" class="form-control">
								<c:forEach items="${races}" var="race">
									<option value="${race.id}">${race.description}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label" for="description">Description</label>
						<div class="col-md-4">
							<input id="description" name="description" type="text" placeholder="enter event description" class="form-control input-md" required="">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label" for="odds">Odds</label>
						<div class="col-md-4">
							<input id="odds" name="odds" type="text" placeholder="enter odds" class="form-control input-md" required="">
						<span class="help-block" style="color:green">use numbers, point and virgule</span>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label" for="confirm"></label>
						<div class="col-md-4">
							<button id="confirm" name="confirm" class="btn btn-primary">Confirm</button>
						</div>
					</div>

				</fieldset>
			</form>
		</div>
	</body>
</html>
