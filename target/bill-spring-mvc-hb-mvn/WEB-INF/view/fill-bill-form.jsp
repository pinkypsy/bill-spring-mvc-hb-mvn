<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>

    <%--    <link rel="stylesheet" type="text/css"--%>
    <%--    &lt;%&ndash;the proper app name in curly braces&ndash;%&gt;--%>
    <%--          href="${pageContext.request.contextPath}/resources/css/style.css">--%>

    <%--    <link rel="stylesheet" type="text/css"--%>
    <%--    &lt;%&ndash;the proper app name in curly braces&ndash;%&gt;--%>
    <%--          href="${pageContext.request.contextPath}/resources/css/add-indications-style.css">--%>

        <link rel="stylesheet" type="text/css"
        <%--the proper app name in curly braces--%>
              href="${pageContext.request.contextPath}/resources/css/style.css">

        <link rel="stylesheet" type="text/css"
        <%--the proper app name in curly braces--%>
              href="${pageContext.request.contextPath}/resources/css/add-indications-style.css">

    <title>
        Utility Service Indications
    </title>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Utility Service Indications</h2>
    </div>
</div>

<div id="container">
    <div id="content">

        <form:form action="saveBill" modelAttribute="resultBillTable" method="POST" cssClass="saveBillForm">
            <table>
                <tbody>

<%--                <tr>--%>
<%--                    <td><label>${message}</label></td>--%>
<%--                </tr>--%>

                <tr>
                    <td><label>Electricity Tariff Delimiter:</label></td>
                    <td><form:input path="tariffsTable.electricityTariffDelimiter" /></td>
                </tr>
                
                <tr>
                    <td><label>Cold Water Tariff:</label></td>
                    <td><form:input path="tariffsTable.coldWaterTariff"
                                    pattern = "\d+\.?\d*"
                                    title="Use decimal numbers and point as the separator"/></td>
                </tr>

                <tr>
                    <td><label>Cold Water indication, m<sup>3</sup>:</label></td>
                    <td><form:input path="countedBillTable.coldWater" /></td>
                </tr>

                <tr>
                    <td><label>Electricity Tariff Before Tariff Delimiter, kVt:</label></td>
                    <td><form:input path="tariffsTable.electricityBeforeDelimiterTariff"
                                    pattern = "\d+\.?\d*"
                                    title="Use decimal numbers and point as the separator"/></td>
                </tr>

                <tr>
                    <td><label>Electricity Tariff After Tariff Delimiter, kVt:</label></td>
                    <td><form:input path="tariffsTable.electricityAfterDelimiterTariff"
                                    pattern = "\d+\.?\d*"
                                    title="Use decimal numbers and point as the separator"/></td>
                </tr>

                <tr>
                    <td><label>Electricity indication, kVt:</label></td>
                    <td><form:input path="countedBillTable.electricity" /></td>
                </tr>
                <tr>
                    <td><label>Garbage Removal Price:</label></td>
                    <td><form:input path="fixedBillTable.garbageRemovalPrice" /></td>
                </tr>

                <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"></td>
                </tr>

                </tbody>
            </table>
        </form:form>

    </div>
</div>

<a href="${pageContext.request.contextPath}/bill/showResultTable">Back</a>

</body>
</html>