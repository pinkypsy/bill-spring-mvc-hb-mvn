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
            <th colspan="2">Tariff Rate</th>
            <th rowspan="2">Charge</th>
        </tr>
        <tr>
            <td style="width: 50%">Total</td>
            <td style="width: 50%">${formFillMessages.get("usagePeriodMessage")}</td>
            <td style="width: 50%">Before ${formFillMessages.get("delimiterValue")} kWh</td>
            <td style="width: 50%">After ${formFillMessages.get("delimiterValue")} kWh</td>
<%--            <td style="width: 50%">${messagePreparator.get("usagePeriodMessage")}</td>--%>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Electricity</td>

            <td>${countedBillTableByID.electricity}</td>
            <td>${countedBillTableByID.electricity - previousCountedBillTableByID.electricity}</td>

            <td style="width: 50%">${tariffsTableByID.electricityBeforeDelimiterTariff} UAH</td>
            <td style="width: 50%">${tariffsTableByID.electricityAfterDelimiterTariff} UAH</td>
            <td>${resultBillTableByID.electricity} UAH</td>
        </tr>
        <tr>
            <td>Cold Water</td>
            <td>${countedBillTableByID.coldWater}</td>
            <td>${countedBillTableByID.coldWater - previousCountedBillTableByID.coldWater}</td>
            <td colspan="2">${tariffsTableByID.coldWaterTariff} UAH</td>
            <td>${resultBillTableByID.coldWater} UAH</td>
        </tr>
        <tr>
            <td>Hot Water</td>
            <td>${countedBillTableByID.hotWater}</td>
            <td>${countedBillTableByID.hotWater - previousCountedBillTableByID.hotWater}</td>
            <td colspan="2">${tariffsTableByID.hotWaterTariff} UAH</td>
            <td>${resultBillTableByID.hotWater} UAH</td>
        </tr>
        <tr>
            <td>Gas Supply</td>
            <td>${countedBillTableByID.gasSupply}</td>
            <td>${countedBillTableByID.gasSupply - previousCountedBillTableByID.gasSupply}</td>
            <td colspan="2">${tariffsTableByID.gasSupplyTariff} UAH</td>
            <td>${resultBillTableByID.gasSupply} UAH</td>
        </tr>
        <tr>
            <td>House Heating</td>
            <td>${countedBillTableByID.houseHeating}</td>
            <td>${countedBillTableByID.houseHeating - previousCountedBillTableByID.houseHeating}</td>
            <td colspan="2">${countedBillTableByID.houseHeating} UAH</td>
            <td>${resultBillTableByID.houseHeating} UAH</td>
        </tr>
        <tr>
            <td>Sewage</td>
            <td colspan="2">${countedBillTableByID.sewage}</td>
            <td colspan="2">${tariffsTableByID.sewageTariff} UAH</td>
            <td>${resultBillTableByID.sewage} UAH</td>
        </tr>
        <tr>
            <td>Rent Service</td>
<%--            <td colspan="4" style="text-align: right">${resultBillTable.fixedBillTable.rentServicePrice} UAH</td>--%>
            <td colspan="5" style="text-align: right">${resultBillTableByID.rentService} UAH</td>
        </tr>
        <tr>
            <td>Garbage Removal</td>
<%--            <td colspan="2">${resultBillTable.fixedBillTable.garbageRemovalPrice } UAH</td>--%>
            <td colspan="5" style="text-align: right">${resultBillTableByID.garbageRemoval} UAH</td>
        </tr>
        <tr>
            <td><strong>Total to charge:</strong></td>
            <td colspan="5" style="text-align: right">${resultBillTableByID.totalToPay} UAH</td>
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

