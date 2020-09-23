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
            <td>${usagePeriodMessage}</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Electricity</td>

            <td>${resultBillTable.countedBillTable.electricity}</td>
            <td>${resultBillTable.countedBillTable.electricity - previousResultBillTable.countedBillTable.electricity}</td>

            <td style="width: 50%">${resultBillTable.tariffsTable.electricityBeforeDelimiterTariff} UAH</td>
            <td style="width: 50%">${resultBillTable.tariffsTable.electricityAfterDelimiterTariff} UAH</td>
            <td>${resultBillTable.electricity} UAH</td>
        </tr>
        <tr>
            <td>Cold Water</td>
            <td>${resultBillTable.countedBillTable.coldWater}</td>
            <td>${resultBillTable.countedBillTable.coldWater - previousResultBillTable.countedBillTable.coldWater}</td>
            <td colspan="2">${resultBillTable.tariffsTable.coldWaterTariff} UAH</td>
            <td>${resultBillTable.coldWater} UAH</td>
        </tr>
        <tr>
            <td>Hot Water</td>
            <td>${resultBillTable.countedBillTable.hotWater}</td>
            <td>${resultBillTable.countedBillTable.hotWater - previousResultBillTable.countedBillTable.hotWater}</td>
            <td colspan="2">${resultBillTable.tariffsTable.hotWaterTariff} UAH</td>
            <td>${resultBillTable.hotWater} UAH</td>
        </tr>
        <tr>
            <td>Sewage</td>
            <td colspan="2">${resultBillTable.countedBillTable.sewage}</td>
            <td colspan="2">${resultBillTable.tariffsTable.sewageTariff} UAH</td>
            <td>${resultBillTable.sewage} UAH</td>
        </tr>
        <tr>
            <td>Gas Supply</td>
            <td>${resultBillTable.countedBillTable.gasSupply}</td>
            <td>${resultBillTable.countedBillTable.gasSupply - previousResultBillTable.countedBillTable.gasSupply}</td>
            <td colspan="2">${resultBillTable.tariffsTable.gasSupplyTariff} UAH</td>
            <td>${resultBillTable.gasSupply} UAH</td>
        </tr>
        <tr>
            <td>House Heating</td>
            <td>${resultBillTable.countedBillTable.houseHeating}</td>
            <td>${resultBillTable.countedBillTable.houseHeating - previousResultBillTable.countedBillTable.houseHeating}</td>
            <td colspan="2">${resultBillTable.countedBillTable.houseHeating} UAH</td>
            <td>${resultBillTable.houseHeating} UAH</td>
        </tr>
        <tr>
            <td>Rent Service</td>
<%--            <td colspan="4" style="text-align: right">${resultBillTable.fixedBillTable.rentServicePrice} UAH</td>--%>
            <td colspan="3" style="text-align: right">${resultBillTable.rentService} UAH</td>
        </tr>
        <tr>
            <td>Garbage Removal</td>
<%--            <td colspan="2">${resultBillTable.fixedBillTable.garbageRemovalPrice } UAH</td>--%>
            <td colspan="3" style="text-align: right">${resultBillTable.garbageRemoval} UAH</td>
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

