<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" context="/springmvc"/>">
<title>Insert title here</title>
</head>
<body>
	<table class= "table table-striped col-xl-6 col-lg-6" style="margin-left:20px">
		<thead class="panel-heading" style="background-color: #C88A7D">
			<tr>
				<th>Prenom</th>
				<th>Nom</th>
				<th>Email</th>
				<th>Role</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<!-- items="${users}" : Cela veut dire qu'on est entrain de demander � JSP d'aller 
		vers le MODEL, et chercher un attribut qui s'appeller users 
		
		${user.prenom} : Il fait appel au getter (getPrenom....)
		-->
		<tbody style="background-color:#F5F6F2">
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.prenom}</td>
					<td>${user.nom}</td>
					<td>${user.email}</td>
					<td>${user.role}</td>
					<td>
						<c:url value="/admin/users/delete/${user.id}" context="/springmvc" var="urldelete"/>
						<a href="${urldelete}" onclick="return confirm('Are you sure ?')">Delete</a>
					<td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>