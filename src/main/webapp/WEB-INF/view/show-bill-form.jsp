<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <link rel="stylesheet" type="text/css"
    <%--the proper app name in curly braces--%>
          href="${pageContext.request.contextPath}/resources/css/style.css">
    <title>
        Bill Details
    </title>
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Utility Bill Details</h2>
    </div>
</div>

<div id="container">

    <table>
        <%--        <thead>--%>
        <tr>
            <th>Utility Service</th>
            <th>Usage</th>
            <th  colspan="2">Tariff Rate</th>
            <th>Charge</th>
        </tr>
        <%--        </thead>--%>
        <%--        <tbody>--%>
        <tr>
            <td>Electricity</td>
            <td>${countedBillTable.electricity}</td>

            <td>${tariffsTable.electricityBeforeDelimiterTariff / 100}</td>
            <td>${tariffsTable.electricityAfterDelimiterTariff / 100}</td>

            <td>${resultBillTable.electricity / 100}</td>
        </tr>
        <tr>
            <td>Cold Water</td>
            <td>${countedBillTable.coldWater}</td>
            <td  colspan="2">${tariffsTable.coldWaterTariff / 100}</td>
            <td>${resultBillTable.coldWater / 100}</td>
        </tr>
        <%--        </tbody>--%>

        Total: ${resultBillTable.totalToPay / 100} UAH

    </table>
    <a href="${pageContext.request.contextPath}/bill/showResultTable">Back</a>
</div>


<%--    <c:forEach var="resultBillTable" items="${resultBillTableList}">--%>

<%--        <c:url var="detailsLink" value="/bill/details">--%>
<%--            <c:param name="billId" value="${resultBillTable.id}"/>--%>
<%--        </c:url>--%>

<%--        <c:url var="updateLink" value="/bill/update">--%>
<%--            <c:param name="billId" value="${resultBillTable.id}"/>--%>
<%--        </c:url>--%>

<%--        <c:url var="deleteLink" value="/bill/delete">--%>
<%--            <c:param name="billId" value="${resultBillTable.id}"/>--%>
<%--        </c:url>--%>
<%--        <tr>--%>
<%--            <td>${resultBillTable.id}</td>--%>
<%--            <td>${resultBillTable.hotWater / 100}</td>--%>
<%--            <td>${resultBillTable.coldWater / 100}</td>--%>
<%--            <td>${resultBillTable.sewage / 100}</td>--%>
<%--            <td>${resultBillTable.electricity / 100}</td>--%>
<%--            <td>${resultBillTable.gasSupply / 100}</td>--%>
<%--            <td>${resultBillTable.houseHeating / 100}</td>--%>
<%--            <td>${resultBillTable.rentService / 100}</td>--%>
<%--            <td>${resultBillTable.garbageRemoval / 100}</td>--%>
<%--            <td>${resultBillTable.indicationDate}</td>--%>
<%--            <td>${resultBillTable.totalToPay / 100}</td>--%>
<%--            <td>--%>

<%--                <a href="${detailsLink}">Details</a>--%>
<%--                |--%>
<%--                <a href="${updateLink}">Update</a>--%>
<%--                |--%>
<%--                <a href="${deleteLink}"--%>
<%--                   onclick="if (!(confirm('Are you sure you want to delete this bill?'))) return false">Delete</a>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>


</body>

</html>

