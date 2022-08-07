<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>User Info</h2>
<br>

<form:form action="saveUser" modelAttribute="user">

    <form:hidden path="id"/>


    Name <form:input path="name"/>
    <br><br>
    LastName <form:input path="lastName"/>
    <br><br>
    Age <form:input path="age"/>
    <br><br>
    <input type="submit" value="Create">


</form:form>






</body>


</html>