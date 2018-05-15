<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<%--<link rel="stylesheet" href="../../resources/static/css/style.css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
    <title>New license Form</title>
</head>
<body>
<div class="container">
    <t:generic_navbar>
            <jsp:attribute name="top_nav">
            </jsp:attribute>
    </t:generic_navbar>

    <div class="foreground">

        <h3>Submit a new license!</h3>
        <br/>

        <form:form method="POST" action="/licenses/new" modelAttribute="license">

            <%--DONE: Generate dropdown of existing people on which a license can be added--%>

            <form:select path="person" items="${persons}" itemLabel="firstName"></form:select>

            <form:label path="state"> State
                <%--<br/>--%>
                <form:errors path="state" cssClass="error"/>
                <br/>
                <form:input path="state"/>
            </form:label>

            <form:label path="expirationDate"> Expiration Date
                <%--<br/>--%>
                <form:errors path="expirationDate" cssClass="error"/>
                <br/>
                <form:input path="expirationDate" id="datepicker"/>
            </form:label>

            <form:hidden path="number"/>
            <input type="submit">

        </form:form>
    </div>
</div>

</body>
</html>
