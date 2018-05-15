<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%--<link rel="stylesheet" href="../../resources/static/css/style.css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>

    <title>Lookify Project</title>
</head>
<body>
<div class="home_container">
    <div class="foreground">
        <h1>Welcome to the License thing</h1>
        <br/>
        <%--<a href="/persons/all">See the people</a>--%>
        <button name="all_persons" class="btn-inverse" value="All Persons" onclick="location.href='/persons/all';">All Persons</button>

        <br/>
        <br/>
        <%--Or <a href="/persons/new">Add person to DB</a>--%>
        <button name="new_person" class="btn-inverse" value="New Person" onclick="location.href='/persons/new';">New Person</button>

        <br/>
        <br/>
        <br/>
        <br/>
        Message: ${message}
        <br/>

    </div>
</div>

</body>
</html>