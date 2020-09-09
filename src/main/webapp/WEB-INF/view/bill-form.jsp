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

<div id = "wrapper">
    <div id = "header">
        <h2>Utility Service Indications</h2>
    </div>
</div>

<div id = "container">
    <div id = "content">



        <form:form action="saveTariffs"  modelAttribute="tariffsTable" method="POST">

            <table>
                <tbody>

                <tr>
                    <td><label>${message}</label></td>
                </tr>
                <tr>
                    <td><label>Cold water tariff:</label></td>
                    <td><form:input path="coldWaterTariff"/></td>
                </tr>

                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>

                </tbody>
            </table>

            <form:form action="saveTariffs"  modelAttribute="countedBillTable" method="POST">
<%--                <form:hidden path="id"/>--%>
                <table>
                    <tbody>

                    <tr>
                        <td><label>${message}</label></td>
                    </tr>
                    <tr>
                        <td><label>Cold water indicat:</label></td>
                        <td><form:input path="coldWater"/></td>
                    </tr>

                    <tr>
                        <td><label></label></td>
                    </tr>

                    </tbody>
                </table>

            </form:form>

            <form:form action="saveTariffs"  modelAttribute="fixedBillTable" method="POST">--%>

                            <table>
                                <tbody>

                                <tr>
                                    <td><label>${message}</label></td>
                                </tr>
                                <tr>
                                    <td><label>Garbage Removal Price:</label></td>
                                    <td><form:input path="garbageRemovalPrice"/></td>
                                </tr>

                                <tr>
                                    <td><label></label></td>
                                </tr>

                                </tbody>
                            </table>

                        </form:form>

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