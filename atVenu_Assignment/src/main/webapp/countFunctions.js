/* Author: Brett Dawson
* This JS file contains functions that do the on-the-fly calculations in the browser.
* Note that jQuery must be imported/available for these functions to work.
*/

// Function for calculating Total In
$(document).ready(function() {
    var selectors = $("#countIn,#addIn");
    selectors.keyup(function(){
        var totalIn = parseInt($("#countIn").val()) + parseInt($("#addIn").val());
        $("#totalIn").val(totalIn);
        $("#inTotal").text($("#totalIn").val()); /* NOTE: this isn't the proper way to display a column total in the bottom row
        All it is doing is grabbing the value from the row above and setting the paragraph's text equal to it.
        This would need to be done properly (i.e., sum of all rows above) in a real app. */
    });
});

// Function for calculating Total Sold
$(document).ready(function() {
    var selectors = $("#countOut,#comp");
    selectors.keyup(function(){
        var totalOut = parseInt($("#totalIn").val()) - parseInt($("#countOut").val())
            - parseInt($("#comp").val());
        var gross = 10*totalOut;
        $("#totalSold").val(totalOut);
        $("#compTotal").text($("#comp").val());
        $("#countoutTotal").text($("#countOut").val());
        $("#cumulativeSold").text($("#totalSold").val());
        $("#gross").val(gross);
    });
});


// async function totalIn(){
//     const countIn = $("#countIn").on('change', function(){
//         console.log($(this).val());
//     });
//
// }

