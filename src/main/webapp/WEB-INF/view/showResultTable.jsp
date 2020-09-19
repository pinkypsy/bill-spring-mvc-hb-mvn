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
    <%--            Search customer: <input type="text" name="theSearchName" />--%>

    <%--            <input type="submit" value="Search" class="add-button" />--%>
    <%--        </form:form>--%>
    <%--    </div>--%>

</div>


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
            <td>${resultBillTable.hotWater / 100}</td>
            <td>${resultBillTable.coldWater / 100}</td>
            <td>${resultBillTable.sewage / 100}</td>
            <td>${resultBillTable.electricity / 100}</td>
            <td>${resultBillTable.gasSupply / 100}</td>
            <td>${resultBillTable.houseHeating / 100}</td>
            <td>${resultBillTable.rentService / 100}</td>
            <td>${resultBillTable.garbageRemoval / 100}</td>
            <td>${resultBillTable.indicationDate}</td>
            <td>${resultBillTable.totalToPay / 100}</td>
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


    <%--    <c:forEach var="customer" items="${customerList}">--%>

    <%--        construct an update link with customer id--%>
    <%--        <c:url var="updateLink" value="/customer/showFormUpdateCustomer">--%>
    <%--            <c:param name="customerId" value="${customer.id}"/>--%>
    <%--        </c:url>--%>

    <%--        <c:url var="deleteLink" value="/customer/delete">--%>
    <%--            <c:param name="customerId" value="${customer.id}"/>--%>
    <%--        </c:url>--%>

    <%--        <tr>--%>
    <%--            <td>${customer.id}</td>--%>
    <%--            <td>${customer.firstName}</td>--%>
    <%--            <td>${customer.lastName}</td>--%>
    <%--            <td>${customer.email}</td>--%>
    <%--            <td>${customer.photo}</td>--%>
    <%--            <td>--%>
    <%--                    &lt;%&ndash;            display the update link&ndash;%&gt;--%>
    <%--                <a href="${updateLink}">Update</a>--%>
    <%--                |--%>
    <%--                <a href="${deleteLink}"--%>
    <%--                   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>--%>
    <%--            </td>--%>
    <%--        </tr>--%>
    <%--    </c:forEach>--%>
</table>

</body>

</html>

