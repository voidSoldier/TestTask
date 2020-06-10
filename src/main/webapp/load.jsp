<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

<%--    <form method="post" action="load" >--%>

</head>
<body>
<form:form method="post" action="load" enctype="multipart/form-data">
    <label for="file">Choose security files to upload</label>
    <input type="file" id="file" name="file" multiple>
    <input type="submit" value="Submit" />
</form:form>

<form:form method="post" action="loadHistory" enctype="multipart/form-data">
    <label for="file">Choose history files to upload</label>
    <input type="file" id="file" name="file" multiple>
    <input type="submit" value="Submit" />
</form:form>

<a href="index.jsp">Home</a>
</body>
</html>
