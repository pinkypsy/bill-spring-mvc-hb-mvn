<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <link rel="stylesheet" type="text/css"
    <%--the proper app name in curly braces--%>
          href="${pageContext.request.contextPath}/resources/css/style.css">
    <title>
        Bills by Month
    </title>
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Bills by Month</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <input type="button" value="Add New Bill"
               onclick="window.location.href = 'addIndicationsForm'; return false"
               class="add-button">
    </div>

    <%--    <div id = "content2">--%>
    <%--        <!--  add a search box -->--%>
    <%--        <form:form action="search" method="GET">--%>
    <%--            Search bill: <input type="text" name="theSearchName" />--%>

    <%--            <input type="submit" value="Search" class="add-button" />--%>
    <%--        </form:form>--%>
    <%--    </div>--%>

</div>
<%--<a href="${pageContext.request.contextPath}/bill/test">TEST</a>--%>

<table>
    <tr>
        <th>id</th>
        <th>Hot Water</th>
        <th>Cold Water</th>
        <th>Sewage</th>
        <th>Electricity</th>
        <th>Gas Supply</th>
        <th>House Heating</th>
        <th>Rent Service</th>
        <th>Garbage Removal</th>
        <th>Indication Date</th>
        <th>Total</th>
        <th>Bill Management</th>
    </tr>

    <c:forEach var="resultBillTable" items="${resultBillTableList}">

        <c:url var="detailsLink" value="/bill/details">
            <c:param name="billId" value="${resultBillTable.id}"/>
        </c:url>

        <c:url var="updateLink" value="/bill/update">
            <c:param name="billId" value="${resultBillTable.id}"/>
        </c:url>

        <c:url var="deleteLink" value="/bill/delete">
            <c:param name="billId" value="${resultBillTable.id}"/>
        </c:url>
        <tr>
            <td>${resultBillTable.id}</td>
            <td>${resultBillTable.hotWater}</td>
            <td>${resultBillTable.coldWater}</td>
            <td>${resultBillTable.sewage}</td>
            <td>${resultBillTable.electricity}</td>
            <td>${resultBillTable.gasSupply}</td>
            <td>${resultBillTable.houseHeating}</td>
            <td>${resultBillTable.rentService}</td>
            <td>${resultBillTable.garbageRemoval}</td>
            <td>${resultBillTable.formattedFillingDate}</td>
            <td>${resultBillTable.totalToPay}</td>
            <td>

                <a href="${detailsLink}">Details</a>
                |
                <a href="${updateLink}">Update</a>
                |
                <a href="${deleteLink}"
                   onclick="if (!(confirm('Are you sure you want to delete this bill?'))) return false">Delete</a>
            </td>
        </tr>
    </c:forEach>


</table>

</body>

</html>

