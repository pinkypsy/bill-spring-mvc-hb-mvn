<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>

    <%--    <link rel="stylesheet" type="text/css"--%>
    <%--    &lt;%&ndash;the proper app name in curly braces&ndash;%&gt;--%>
    <%--          href="${pageContext.request.contextPath}/resources/css/style.css">--%>

    <%--    <link rel="stylesheet" type="text/css"--%>
    <%--    &lt;%&ndash;the proper app name in curly braces&ndash;%&gt;--%>
    <%--          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">--%>

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


        <form:form action="saveTariffs" modelAttribute="monsterBill" method="POST">
            <table>
                <tbody>

                <tr>
                    <td><label>${message}</label></td>
                </tr>

                <tr>
                    <td><label>Electricity Tariff Delimiter:</label></td>
                    <td><form:input path="electricityTariffDelimiter" /></td>
                </tr>
                
                <tr>
                    <td><label>Cold Water Tariff:</label></td>
                    <td><form:input path="coldWaterTariff"
                                    pattern = "\d+\.\d*"
                                    title="Use decimal numbers and point as the separator"/></td>
                </tr>

                <tr>
                    <td><label>Cold Water indication:</label></td>
                    <td><form:input path="coldWater" /></td>
                </tr>

                <tr>
                    <td><label>Electricity Before ${monsterBill.electricityTariffDelimiter} kVt Tariff:</label></td>
                    <td><form:input path="electricityBeforeDelimiterTariff"
                                    pattern = "\d+\.\d*"
                                    title="Use decimal numbers and point as the separator"/></td>
                </tr>

                <tr>
                    <td><label>Electricity After ${monsterBill.electricityTariffDelimiter} kVt Tariff:</label></td>
                    <td><form:input path="electricityAfterDelimiterTariff"
                                    pattern = "\d+\.\d*"
                                    title="Use decimal numbers and point as the separator"/></td>
                </tr>

                <tr>
                    <td><label>Electricity indication, kVt:</label></td>
                    <td><form:input path="electricity" /></td>
                </tr>
                <tr>
                    <td><label>Garbage Removal Price:</label></td>
                    <td><form:input path="garbageRemovalPrice" /></td>
                </tr>

                <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"></td>
                </tr>

                </tbody>
            </table>

            <%--            <form:form action="saveTariffs" modelAttribute="countedBillTable" method="POST">--%>
            <%--                &lt;%&ndash;                <form:hidden path="id"/>&ndash;%&gt;--%>
            <%--                <table>--%>
            <%--                    <tbody>--%>

            <%--                    <tr>--%>
            <%--                        <td><label>${message}</label></td>--%>
            <%--                    </tr>--%>
            <%--                    <tr>--%>
            <%--                        <td><label>Cold water indicat:</label></td>--%>
            <%--                        <td><form:input path="coldWater"/></td>--%>
            <%--                    </tr>--%>


            <%--                    </tbody>--%>
            <%--                </table>--%>

            <%--            </form:form>--%>

            <%--            <form:form action="saveTariffs" modelAttribute="fixedBillTable" method="POST">--%>

            <%--                <table>--%>
            <%--                    <tbody>--%>

            <%--                    <tr>--%>
            <%--                        <td><label>${message}</label></td>--%>
            <%--                    </tr>--%>
            <%--                    <tr>--%>
            <%--                        <td><label>Garbage Removal Price:</label></td>--%>
            <%--                        <td><form:input path="garbageRemovalPrice"/></td>--%>
            <%--                    </tr>--%>
            <%--                    <tr>--%>
            <%--                        <td><label></label></td>--%>
            <%--                        <td><input type="submit" value="Save" class="save"></td>--%>
            <%--                    </tr>--%>

            <%--                    </tbody>--%>
            <%--                </table>--%>

            <%--            </form:form>--%>


        </form:form>

        <%--        <form:form action="saveIndicationsCounted"  modelAttribute="countedBillTable" method="POST">--%>

        <%--            <table>--%>
        <%--                <tbody>--%>

        <%--                <tr>--%>
        <%--                    <td><label>Cold water indications:</label></td>--%>
        <%--                    <td><form:input path="coldWater"/></td>--%>
        <%--                </tr>--%>

        <%--                <tr>--%>
        <%--                    <td><label></label></td>--%>
        <%--                    <td><input type="submit" value="Save" class="save"></td>--%>
        <%--                </tr>--%>

        <%--                </tbody>--%>
        <%--            </table>--%>

        <%--        </form:form>--%>

        <%--        <form:form action="saveFixedValues"  modelAttribute="fixedBillTable" method="POST">--%>

        <%--            <table>--%>
        <%--                <tbody>--%>

        <%--                <tr>--%>
        <%--                    <td><label>Garbage Removal Price:</label></td>--%>
        <%--                    <td><form:input path="garbageRemovalPrice"/></td>--%>
        <%--                </tr>--%>

        <%--                <tr>--%>
        <%--                    <td><label></label></td>--%>
        <%--                    <td><input type="submit" value="Save" class="save"></td>--%>
        <%--                </tr>--%>

        <%--                </tbody>--%>
        <%--            </table>--%>

        <%--        </form:form>--%>

    </div>
</div>

<%--<a href="/customer/list">Back</a>--%>

</body>
</html>