<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%! String makeItUpper(String data){
return data.toUpperCase();
	}
   %>
   
   Upper case "Hello World":<%= makeItUpper("hEllo woRLD") %>

</body>
</html>
