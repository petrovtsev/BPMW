<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Search</title>
    <link href="../resources/css/inbox.css" rel="stylesheet" type="text/css" />
</head>



<body>
<div class="header">
    <img src="../resources/images/logo.png" style="margin-left: 15%; margin-top: 15px; height: 50px"/>
</div>

<div class="menu">
    <form action="${pageContext.request.contextPath}/taskList" method="post">
        <a href="personal_area.jsp" style="margin-top: 10px; margin-left: 15%; width: 15%">User name: Admin</a>
        <a href="inbox.jsp" style="height: 15px; width: 7%; margin-left: 25%; margin-top: 10px" class="button">Back to list</a>
        <a href="../login.jsp" style="height: 15px; width: 7%; margin-left: 16%; margin-top: 10px" class="button">Exit</a></form>
</div>
<div class="pages">
    <div class="sidebar">
        <h3 style="margin-left: 40px">Tasks</h3>
        <hr>
        <ul>
            <c:forEach var="task" items="#{taskModel.returnAllTasks()}">
                <a href="#">${task.name}</a><br>
            </c:forEach>
        </ul>
        <hr>
        <input href="#" style="height: 23px; width: 120px; margin-left: 20px" type="submit" name="addQuery" value="Add new task" class="button"/>
    </div>
    <div class="content">
        <h3 style="margin-left: 10%">Search</h3>
        <hr>

        <form>
            <table class="data-table">
                <tr>
                    <td style="width: 150px">Name task</td>
                    <td><input value=""/></td>
                </tr>
                </tr>
                    <td>Show</td>
                    <td><input type="radio" name="browser" value="all"> all<br>
                        <input type="radio" name="browser" value="completed"> completed<br>
                        <input type="radio" name="browser" value="notCompleted"> not completed</td>
                </tr>
                <tr>
                    <td>Date</td>
                    <td><input name="dateStart" type="date" value=""/> - <input name="dateEnd" type="date" value=""/></td>
                </tr>
                <tr>
                    <td>Date complete</td>
                    <td><input value=""/></td>
                </tr>
                <tr>
                    <td>User complete</td>
                    <td><input value=""/></td>
                </tr>
            </table>


            <dialog>
                <input type="text" id="return_value" value="" placeholder="Введите значение">
                <button id="close">Отправить</button>
            </dialog>
            <button id="show">Открыть диалог</button>

            <script>
                var dialog = document.querySelector('dialog');
                document.querySelector('#show').onclick = function() {
                    dialog.show(); // открыть диалоговое окно
                };

                document.querySelector('#close').onclick = function() {
                    var value = document.querySelector('#return_value').value;
                    dialog.close(value); // отправить значение поля
                };

                document.querySelector('dialog').addEventListener('close', function() {
                    alert(this.returnValue);
                })
                </script>
        </form>
    </div>

    <div class="footer">
        <a href="#" class="button" style="margin-top: 7px; margin-left: 34%">Save</a>
        <a href="#" class="button">Remove</a>
        <a href="inbox.jsp" class="button">Back</a>
    </div>
</div>
</body>
</html>