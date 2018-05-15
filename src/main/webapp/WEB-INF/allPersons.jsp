<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>

    <title>All Persons</title>
</head>
<body>

${search_errors}
<div class="container">
    <t:generic_navbar>
            <jsp:attribute name="top_nav">
            </jsp:attribute>
    </t:generic_navbar>
    <br/>
    <div class="allPersonsList">
        <%--${loop.index+1}. ${song} <br/>--%>
        <h3>All Peeps</h3>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">
                    #
                </th>
                <th scope="col">
                    First
                </th>
                <th scope="col">
                    Last
                </th>
                <th scope="col">
                    License #
                </th>
                <th scope="col">
                    State
                </th>
                <th scope="col">
                    Exp
                </th>
            </tr>
            </thead>
            <tbody>
            <%--for loop can go here, or in the tr tag --%>
            <c:forEach var="person" items="${persons}" varStatus="loop" >
                <tr>
                    <th scope="row">
                            ${loop.index+1}
                    </th>
                    <th scope="row">
                        <%--<a href="songs/view/${song.id}">${song.title}</a>--%>
                        ${person.firstName}

                    </th>
                    <td>
                            ${person.lastName}

                    </td>
                    <td>
                        ${person.getLicense().getNumber()}
                            <%--License Number { ex: 001234 }--%>
                    </td>
                    <td>
                            ${person.getLicense().getState()}
                        <%--State { ex: WA }--%>
                    </td>
                    <td>
                            ${person.getLicense().getExpirationDateString()}
                        <%--Exp dater { ex: 06/07/2018 }--%>
                    </td>
                    <td>
                        <%--<button name="delete" class="table-btn btn-danger" value="Delete" onclick="location.href='/persons/delete/${song.id}';">remove</button>--%>
                        <button name="delete" class="table-btn btn-danger" value="Delete" onclick="location.href='/persons/delete/${person.id}';">remove</button>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>






</div>

</body>
</html>

