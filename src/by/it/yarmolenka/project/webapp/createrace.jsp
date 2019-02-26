<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=createRace" method="post">
    <fieldset>

    <!-- Form Name -->
    <legend>Create race</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="time">Time</label>
      <div class="col-md-4">
      <input id="time" name="time" type="datetime-local" placeholder="time" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
    <label class="col-md-4 control-label" for="racetrack">Race track</label>
    <div class="col-md-4">
    <input id="racetrack" name="racetrack" type="text" placeholder="enter race track" class="form-control input-md" required="">

    </div>

    <!-- Text input-->
    <div class="form-group">
    <label class="col-md-4 control-label" for="description">Description</label>
    <div class="col-md-4">
    <input id="description" name="description" type="text" placeholder="enter race description" class="form-control input-md" required="">

    </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="submit"></label>
      <div class="col-md-4">
        <button id="submit" name="submit" class="btn btn-primary">Submit</button>
      </div>
    </div>

    </fieldset>
    </form>

</div>
</body>
</html>
