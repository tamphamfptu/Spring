<%--
  Created by IntelliJ IDEA.
  User: Polaris
  Date: 8/23/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">
       First Name: <form:input path="firstName" />
        <br>
        Last Name: <form:input path="lastName" />
        <br>
        Country:
        <form:select path="country">
            <form:options items="${student.countryOptions}"/>
<%--            <form:option value="STH" label="STH"/>--%>
<%--            <form:option value="STH" label="STH"/>--%>
<%--            <form:option value="STH" label="STH"/>--%>
<%--            <form:option value="STH" label="STH"/>--%>
        </form:select>
        <br><br>
        Favorite Language:
        <br>
        <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>
        <br>
        Operating System:
        <br>
        Linux <form:checkbox path="operatingSystem" value="Linux"/>
        Windows <form:checkbox path="operatingSystem" value="Windows"/>
        MacOS <form:checkbox path="operatingSystem" value="MacOS"/>
        <br>
        <input type="submit" value="Submit">
    </form:form>
</body>
</html>
