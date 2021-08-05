<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Current Weather</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/info.css">
</head>

<body>

<table>
    <tr>
        <td>
            <div id="bloc1">

                <div class="row">
                    <h4>Current Condition</h4>
                    <label>
                        <c:out value='${currentWeather.description}'/>
                    </label>
                </div>

                <div class="row">
                    <h4>Wind Speed</h4>
                    <label>
                        <c:out value='${currentWeather.windSpeed}'/> mph
                    </label>
                </div>

        </td>

        <td>
            <div id="bloc2">

                <div class="row">
                    <h4>Temperature</h4>
                    <label>
                        <c:out value='${currentWeather.temperature}'/> &#8451
                    </label>
                </div>

                <div class="row">
                    <h4>Feels Like</h4>
                    <label>
                        <c:out value='${currentWeather.feelsLike}'/> &#8451
                    </label>
                </div>

            </div>
        </td>
    </tr>
</table>

<div class="link">
    <a href="javascript:history.back()">Go back</a>
</div>

</body>
</html>
