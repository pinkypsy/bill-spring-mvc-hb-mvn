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
        <thead>
        <tr>
            <th rowspan="2">Utility Service</th>
            <th colspan="2">Usage</th>
            <th colspan="2" rowspan="2">Tariff Rate</th>
            <th rowspan="2">Charge</th>
        </tr>
        <tr>
            <td>Total</td>
            <td>Per Month</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Electricity</td>
            <td>${countedBillTable.electricity}</td>
            <td>-</td>

            <td>${tariffsTable.electricityBeforeDelimiterTariff} UAH</td>
            <td>${tariffsTable.electricityAfterDelimiterTariff} UAH</td>
            <td>${resultBillTable.electricity} UAH</td>
        </tr>
        <tr>
            <td>Cold Water</td>
            <td>${countedBillTable.coldWater}</td>
            <td>-</td>
            <td colspan="2">${tariffsTable.coldWaterTariff} UAH</td>
            <td>${resultBillTable.coldWater} UAH</td>
        </tr>
        <tr>
            <td>Hot Water</td>
            <td>${countedBillTable.hotWater}</td>
            <td>-</td>
            <td colspan="2">${tariffsTable.hotWaterTariff} UAH</td>
            <td>${resultBillTable.hotWater} UAH</td>
        </tr>
        <tr>
            <td>Sewage</td>
            <td>${countedBillTable.sewage}</td>
            <td>-</td>
            <td colspan="2">${tariffsTable.sewageTariff} UAH</td>
            <td>${resultBillTable.sewage} UAH</td>
        </tr>
        <tr>
            <td>Gas Supply</td>
            <td>${countedBillTable.gasSupply}</td>
            <td>-</td>
            <td colspan="2">${tariffsTable.gasSupplyTariff} UAH</td>
            <td>${resultBillTable.gasSupply} UAH</td>
        </tr>
        <tr>
            <td>House Heating</td>
            <td></td>
            <td>-</td>
            <td colspan="2">${fixedBillTable.houseHeatingPrice} UAH</td>
            <td>${resultBillTable.houseHeating} UAH</td>
        </tr>
        <tr>
            <td>Rent Service</td>
            <td></td>
            <td>-</td>
            <td colspan="2">${fixedBillTable.rentServicePrice} UAH</td>
            <td>${resultBillTable.rentService} UAH</td>
        </tr>
        <tr>
            <td>Garbage Removal</td>
            <td></td>
            <td>-</td>
            <td colspan="2">${fixedBillTable.garbageRemovalPrice } UAH</td>
            <td>${resultBillTable.garbageRemoval} UAH</td>
        </tr>
        <tr>
            <td><strong>Total to charge:</strong></td>
            <td colspan="5" style="text-align: right">${resultBillTable.totalToPay} UAH</td>
        </tr>
        </tbody>


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
<%--            <td>${resultBillTable.hotWater}</td>--%>
<%--            <td>${resultBillTable.coldWater}</td>--%>
<%--            <td>${resultBillTable.sewage}</td>--%>
<%--            <td>${resultBillTable.electricity}</td>--%>
<%--            <td>${resultBillTable.gasSupply}</td>--%>
<%--            <td>${resultBillTable.houseHeating}</td>--%>
<%--            <td>${resultBillTable.rentService}</td>--%>
<%--            <td>${resultBillTable.garbageRemoval}</td>--%>
<%--            <td>${resultBillTable.indicationDate}</td>--%>
<%--            <td>${resultBillTable.totalToPay}</td>--%>
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

