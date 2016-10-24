$(function() {
  var login,
      email,
      password,
      password2,
      loginStat,
      emailStat,
      passwordStat,
      password2Stat;

$(function() {
  // Checking login
  $("#login").change(function(){
    login = $("#login").val();
    var expLogin = /^[a-zA-Z0-9_]+$/g;
    var resLogin = login.search(expLogin);
    if(resLogin == -1){
      $("#login").next().hide().text("Login incorrect").css("color","red").fadeIn(400);
      $("#login").removeClass().addClass("inputRed");
      loginStat = 0;
      buttonOnAndOff();
    }else{
      $.ajax({
        url: "registerController",
        type: "GET",
        data: { login : login},
        success: function(response){
          if(response == "false"){
            $("#login").next().hide().text("Username is not available.").css("color","red").fadeIn(400);
            $("#login").removeClass().addClass("inputRed");
          }else{
            $("#login").removeClass().addClass("inputGreen");
            $("#login").next().text("");
          }
        }
      });
      loginStat = 1;
      buttonOnAndOff();
    }

  });
  $("#login").keyup(function(){
    $("#login").removeClass();
    $("#login").next().text("");
  });

  // Checking email
  $("#email").change(function(){
    email = $("#email").val();
    var expEmail = /[-0-9a-z_]+@[-0-9a-z_]+\.[a-z]{2,6}/i;
    var resEmail = email.search(expEmail);
    if(resEmail == -1){
      $("#email").next().hide().text("Wrong format").css("color","red").fadeIn(400);
      $("#email").removeClass().addClass("inputRed");
      emailStat = 0;
      buttonOnAndOff();
    }else{
      $("#email").removeClass().addClass("inputGreen");
      $("#email").next().text("");
      emailStat = 1;
      buttonOnAndOff();
    }

  });
  $("#email").keyup(function(){
    $("#email").removeClass();
    $("#email").next().text("");
  });

  // checking password
  $("#password").change(function(){
    password = $("#password").val();
    if(password.length < 6){
      $("#password").next().hide().text("Password too short").css("color","red").fadeIn(400);
      $("#password").removeClass().addClass("inputRed");
      passwordStat = 0;
      buttonOnAndOff();
    }else{
      $("#password").removeClass().addClass("inputGreen");
      $("#password").next().text("");
      passwordStat = 1;
      buttonOnAndOff();
    }
  });
  $("#password").keyup(function(){
    $("#password").removeClass();
    $("#password").next().text("");
  });
  $("#password2").change(function(){
    if(password2 != password){
      $("#password2").next().hide().text("Passwords do not match").css("color","red").fadeIn(400);
      $("#password2").removeClass().addClass("inputRed");
      password2Stat = 0;
      buttonOnAndOff();
    }else{
      $("#password2").removeClass().addClass("inputGreen");
      $("#password2").next().text("");
    }
  });
  $("#password2").keyup(function(){
    password2 = $("#password2").val();
    if(password2 == password){
      password2Stat = 1;
      buttonOnAndOff();
    }else{
      password2Stat = 0;
      buttonOnAndOff();
    }
  });
  function buttonOnAndOff(){
    if(emailStat == 1 && passwordStat == 1 && password2Stat == 1 && loginStat == 1){
      $("#submit").removeAttr("disabled");
    }else{
      $("#submit").attr("disabled","disabled");
    }
  }
});

});
