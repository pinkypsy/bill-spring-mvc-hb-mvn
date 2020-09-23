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
        Utility Service TEST
    </title>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Utility Service TEST</h2>
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

<%--                <tr>--%>
<%--                    <td><label>Electricity Tariff Delimiter:</label></td>--%>
<%--                    <td><form:input path="countedBillTable.electricity" /></td>--%>
<%--                </tr>--%>

                <tr>
                    <td><label>Cold Water Tariff:</label></td>
                    <td><form:input path="tariffsTable.coldWaterTariff"
                                    /></td>
                </tr>

                <tr>
                    <td><label>Cold Water indication:</label></td>
                    <td><form:input path="countedBillTable.coldWater" /></td>
                </tr>

                <tr>
                    <td><label>Electricity Before  kVt Tariff:</label></td>
                    <td><form:input path="tariffsTable.electricityBeforeDelimiterTariff"
                                    /></td>
                </tr>

                <tr>
                    <td><label>Electricity After  kVt Tariff:</label></td>
                    <td><form:input path="tariffsTable.electricityAfterDelimiterTariff"
                                   /></td>
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