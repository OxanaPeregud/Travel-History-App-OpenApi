<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Journey Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/form.css">
    <script src="${pageContext.request.contextPath}/js/validation.js"></script>
</head>

<body>

<button type="button" class="button"><a class="homepage"
                                        href="${pageContext.request.contextPath}/journeys/list">All Journeys</a>
</button>

<div>
    <c:if test="${journey != null}">
    <form name="journeyForm" onsubmit="return validateForm()"
          action="${pageContext.request.contextPath}/journeys/update" method="post">
        </c:if>

        <c:if test="${journey == null}">
        <form name="journeyForm" onsubmit="return validateForm()"
              action="${pageContext.request.contextPath}/journeys/insert" method="post">
            </c:if>

            <caption>
                <h2>Journey Information</h2>
            </caption>

            <c:if test="${journey != null}">
                <input type="hidden" name="id" value="<c:out value='${journey.id}' />"/>
            </c:if>

            <div class="row">
                <label>Country</label>
                <label>
                    <input type="text" name="country"
                           value="<c:out value='${journey.country}' />"
                    />
                </label>
                <div class="error" id="countryErr"></div>
            </div>

            <div class="row">
                <label>Year</label>
                <label>
                    <input type="text" name="year" maxlength="4"
                           value="<c:out value='${journey.year}' />"
                    />
                </label>
                <div class="error" id="yearErr"></div>
            </div>

            <div class="row">
                <label>Description</label>
                <label>
                    <input type="text" name="description"
                           value="<c:out value='${journey.description}' />"
                    />
                </label>
            </div>

            <div class="row">
                <label>User</label>
                <label>
                    <input type="text" name="user"
                           value="<c:out value='${journey.user}' />"
                    />
                </label>
                <div class="error" id="userErr"></div>
            </div>

            <div class="row">
                <input type="submit" value="Submit">
            </div>

        </form>

</div>
</body>
</html>
