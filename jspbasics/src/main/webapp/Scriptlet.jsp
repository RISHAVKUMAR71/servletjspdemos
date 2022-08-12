

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="header.jsp" />

	<h3>For loop</h3>
	<%
		for (int i=1; i<=5; i++) {
			out.println("<br/> welcome - " + i);
		}
	%>

	<jsp:include page="footer.jsp" />

</body>
</html>