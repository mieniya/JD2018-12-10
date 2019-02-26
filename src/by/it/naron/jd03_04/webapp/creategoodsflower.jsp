<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>


    <form class="form-horizontal" method="post" action="do?command=createGoodsFlower">
        <fieldset>

            <!-- Form Name -->
            <legend>Greate item flower</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Name</label>
                <div class="col-md-4">
                    <input id="name" value="TestValue name" name="name" type="text" placeholder="" class="form-control input-md">
                    <span class="help-block"></span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="colour">Colour</label>
                <div class="col-md-4">
                    <input id="colour" name="colour" value="TestValue colour" type="text" placeholder="" class="form-control input-md">
                    <span class="help-block"></span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="size">Size</label>
                <div class="col-md-4">
                    <input id="size" name="size" value="70" type="text" placeholder="" class="form-control input-md">
                    <span class="help-block"></span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Price</label>
                <div class="col-md-4">
                    <input id="price" name="price" value="6.5" type="text" placeholder="" class="form-control input-md">
                    <span class="help-block"></span>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="add item"></label>
                <div class="col-md-4">
                    <button id="add item" name="add item" class="btn btn-primary">Add item</button>
                </div>
            </div>

        </fieldset>
    </form>


</div>
</body>
</html>


