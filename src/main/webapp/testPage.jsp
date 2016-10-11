<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Register</title>
    <link href="resources/css/login.css" rel="stylesheet" type="text/css" />
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<div class="header">
    <img src="resources/images/logo.png" style="margin-left: 15%; margin-top: 15px; height: 50px"/>
</div>

<div class="pages">
    <div class="authorization" style="margin-top: 10%; height: 270px">
        <div class="login">
            <form action="testController" method="post">
                <h3><span id="textMessage"> no message still</span></h3>
                <hr>
                <table class="data-table">
                    <tr>
                        <td width="120">Name</td>
                        <td><input id="name" name="name"/></td>
                    </tr>
                    <tr>
                        <td>Text</td>
                        <td><input id="text" name="text"/></td>
                    </tr>
                </table>
                <br>
                <input class="button" type="submit" style="width: 170px; height: 25px" value="Next" onclick="f();">
            </form>
            <button class="button" style="width: 170px; height: 25px" onclick="f()">bs</button><br>
        </div>
    </div>
</div>
<script>
    var span;

    $(function(){
        taskname = $('#name');
        tasktext = $('#text')
        span = $('#textMessage');
    });
    $.ajax({
        url:"/testController",
        method: "POST",
        data: {
            name: taskname,
            text: tasktext
        },
        success: function (result) {
            res = result;
            alert(result);
            span.text(result);
        }
    });
    function f(){
        var username = userNameInput.val();
        span.text("Задача " + taskname + " добавленна!");

    }
</script>
</body>
</html>