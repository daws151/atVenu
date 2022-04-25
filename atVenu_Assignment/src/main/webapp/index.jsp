<!-- Author: Brett Dawson
This Java Server Page (JSP) file contains all of HTML I wrote for the assignment. This obviously isn't ideal, and for a "real"
app there would be a lot more division (i.e., separate files for the header and footer sections) and other things like a
navbar, links, etc.
Please note that the URL for this page is http://localhost:8080/poster_sales/index.jsp when deployed on a WildFly server.
-->
<%--The following 3 lines are JSP page directives--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="settlement.CountsServlet,model.Unit" %>
<%@ page import="settlement.DataAccess" %>
<%--The following scriptlet declares variables for use below--%>
<%
//    String id = request.getParameter("id");
    Unit unit = DataAccess.getProductById(Integer.parseInt("1")); // a variable should be passed in here rather than a hard-coded value
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="atVenu Programming Assignment">
    <meta name="keywords" content="HTML">
    <meta name="author" content="Brett Dawson">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Counts</title>
    <!--my custom CSS sheet to override Bootstrap defaults where necessary-->
    <link href="custom.css" rel="stylesheet" type="text/css">
    <!--3rd-party library I was trying to use for the popover feature-->
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <!--I used Bootstrap 4, wasn't sure if 5 worked with JSP-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <!--jQuery is needed for my JS functions to work-->
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <!--JS functions-->
    <script src="countFunctions.js"></script>
    <script type="module" src="popover.js"></script>

</head>
<body>
<div class="container">
    <form method="post" action="index.jsp" class="form-inline" id="mainForm">
        <div class="form-group">
            <div class="row">
            <div class="col-sm img-fluid">
                <img src="https://i.imgur.com/QJAJNmZ.jpg" id="posterimg"/>
                <!--the JSP expression within the figure caption below pulls the poster's unit price from the database-->
                <figcaption>$<%=unit.getUnitPrice()%></figcaption>
          </div>
            <div class="col-xs">
                <fieldset>
                    <label>QTY Avail.</label>
                    <!--the JSP expression within the figure caption below pulls the poster's quantity available from the database-->
                    <input readonly class="form-control" id="qtyAvail" value="<%=unit.getQtyAvail()%>">
                    <div class="row w-100" id="secondCol"><p>. </p></div>
                </fieldset>

            </div>
            <div class="col-xs">
                <fieldset>
                    <label>Count In</label>
                    <input type="number" class="form-control" id="countIn">
                    <!--Below is the button I was trying to assign a popover to, but couldn't get it to work-->
                    <div class="row w-100"><button id="moreBtn" aria-describedby="tooltip">More</button></div>
                    </fieldset>
            </div>
            <div class="col-xs">
                <fieldset>
                    <label>Add</label>
                    <input type="number" class="form-control" id="addIn"/>
                    <div class="row w-100"><p>.</p></div>
                </fieldset>

            </div>
            <div class="col-xs">
                <fieldset>
                    <label>Total In</label>
                    <input readonly class="form-control" id="totalIn"/>
                    <div class="row w-100" id="fifthCol"><p id="inTotal">.</p></div>
                </fieldset>

            </div>
            <div class="col-xs">
                <fieldset>
                    <label>Comp</label>
                    <input type="number" class="form-control" id="comp">
                    <div class="row w-100" id="sixthCol"><p id="compTotal">.</p></div>
                </fieldset>

            </div>
            <div class="col-xs">
                <fieldset>
                    <label>Count Out</label>
                    <input type="number" class="form-control" id="countOut">
                    <div class="row w-100" id="seventhCol"><p id="countoutTotal">.</p></div>
                </fieldset>

            </div>
            <div class="col-xs">
                <fieldset>
                    <label>Total Sold</label>
                    <input readonly class="form-control" id="totalSold">
                    <div class="row w-100" id="eighthCol"><p id="cumulativeSold">.</p></div>
                </fieldset>

            </div>
            <div class="col-xs">
                <fieldset>
                    <label>Gross</label>
                    <input readonly class="form-control" id="gross">
                    <input type="hidden" name="id" value="1">
                    <div class="row w-100"><p>.</p></div>
                </fieldset>
            </div>
            <div id="tooltip" role="tooltip">Popover tooltip</div>
        </div>
        </div>
    </form>
    <div class="row">
    <div class="col-md-10 text-md-right">
        <p id="totalText">TOTAL</p><br><br>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 text-md-right">
            <!--The Settle button below doesn't do anything. I was going to have it complete a POST operation and send an
             update to the database, but I ran out of time to get it working. Would be relatively easy to implement this.-->
            <button type="submit">SETTLE</button>
        </div>
    </div>
</div>

</body>

</html>