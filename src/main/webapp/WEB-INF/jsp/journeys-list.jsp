<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Travel History</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/table.css">
</head>

<body>

<button type="button" class="button1"><a class="homepage"
                                         href="${pageContext.request.contextPath}/journeys/add">Add Journey</a>
</button>

<div>

    <form action="${pageContext.request.contextPath}/journeys/delete" method="post">
        <table id="customers">

            <caption><h2>Journeys</h2></caption>
            <tr>
                <th>ID</th>
                <th>Country</th>
                <th>City</th>
                <th>Current Weather</th>
                <th>Year</th>
                <th>Description</th>
                <th>User</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach var="journey" items="${listJourneys}">
                <tr>
                    <td><c:out value="${journey.id}"/></td>
                    <td><c:out value="${journey.country}"/></td>
                    <td><c:out value="${journey.city}"/></td>
                    <td><c:out value="${journey.currentWeather}"/></td>
                    <td><c:out value="${journey.year}"/></td>
                    <td><c:out value="${journey.description}"/></td>
                    <td><c:out value="${journey.user}"/></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/journeys/edit?id=<c:out value='${journey.id}'/>">
                            Edit</a>
                    </td>
                    <td>
                        <label><input type="checkbox" name="delete" value="${journey.id}">Delete</label>
                    </td>
                </tr>
            </c:forEach>

            <tr class="right">
                <td>
                    <input type="submit" value="Delete"/>
                </td>
            </tr>

        </table>
    </form>

    <c:if test="${lastPageNo >= 1}">
        <c:forEach var="i" begin="0" end="${lastPageNo-1}">
            <button type="button" class="button2">
                <a class="pages" href="${pageContext.request.contextPath}/journeys/list?pageNo=${i}">
                        ${i+1}</a></button>
        </c:forEach>
    </c:if>

    <c:if test="${lastPageNo < 1}">
        <c:forEach var="i" begin="0" end="${lastPageNo}">
            <button type="button" class="button2">
                <a class="pages" href="${pageContext.request.contextPath}/journeys/list?pageNo=${i}">
                        ${i+1}</a></button>
        </c:forEach>
    </c:if>

</div>
</body>
</html>
