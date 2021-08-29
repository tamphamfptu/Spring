<%--
  Created by IntelliJ IDEA.
  User: Polaris
  Date: 8/24/2021
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>
    The customer is confirmed: ${customer.firstName} ${customer.lastName}
    <br>
    Free passes: ${customer.freePasses}
    <br>
    Postal Code:${customer.postalCode}

</body>
</html>