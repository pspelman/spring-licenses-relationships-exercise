<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="top_nav" fragment="true" %>
<%@attribute name="song_header" fragment="true" %>

<HTML>

<body>
<div class="top_nav">
    <jsp:invoke fragment="top_nav" />
    <button name="all_persons" class="btn-inverse" value="All Persons" onclick="location.href='/persons/all';">All Persons</button>
    <button name="new" class="btn-inverse" value="Add New" onclick="location.href='/licenses/new';">Add License</button>
    <button name="new_person" class="btn-inverse" value="New Person" onclick="location.href='/persons/new';">New Person</button>

<%--<button name="top10" class="btn-inverse" value="Top 10" onclick="location.href='/songs/topTen';">Top 10</button>--%>
    <%--<form name="artist_search_form" action="/songs/search/artist" method="get" class="form-inline nav_artist_search">--%>
        <%--<input type="text" name="artistNameString">--%>
        <%--<input type="submit" class="btn-inverse" value="search">--%>
        <%--<span class="alert-danger">${artist_search_error}</span>--%>
    <%--</form>--%>
</div>
</body>
</HTML>