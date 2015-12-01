/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    
    $("#loginLink").click(function (event) {
        event.preventDefault();
        $("#overlay").fadeToggle("fast");
    });
    
    $("#registerLink").click(function (event) {
        event.preventDefault();
        $("#overlay2").fadeToggle("fast");
    });
    
    $("#close").click(function (event) {
        $("#overlay").fadeToggle("fast");
    });
    
    $("#close2").click(function (event) {
        $("#overlay2").fadeToggle("fast");
    });
    
    $(document).keyup(function (e) {
        if (e.keyCode === 27) {
            event.preventDefault();
            if($("#overlay").css("display") !== "none"){
                $("#overlay").fadeToggle("fast");
            }
            if($("#overlay2").css("display") !== "none"){
                $("#overlay2").fadeToggle("fast");
            }
            
        }
    });
    
});