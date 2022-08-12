<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<table>
		<tr>
			<th>Id</th>
			<th>Appliance Name</th>
			<th>Quantity</th>
			
		</tr>
		<c:forEach var="appliance" items="${APPLIANCE_LIST}" >
			<tr>
				<td>${appliance.id}</td>
				<td>${appliance.ApplianceName}</td>
				<td>${appliance.Quantity}</td>
				
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>