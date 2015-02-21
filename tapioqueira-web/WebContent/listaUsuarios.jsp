<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Lista de Usuários</title>
	</head>
	<body>
		<form action="cadUser.jsp" method="post">
			<input type="submit" value="Novo Usuario">
		</form>
		<table border="1">
			<tr>
				<td>ID</td>
				<td>Nome</td>
				<td>Login</td>
				<td>Tipo</td>
				<td>Alterar</td>
				<td>Excluir</td>
			</tr>
			<c:forEach var="c" items="${lista }">
				<tr>
					<td>${c.cd_usuario }</td>
					<td>${c.nm_usuario }</td>
					<td>${c.nm_login }</td>
					<td>${c.tp_usuario }</td>
					<td><form action="sistema?acao=CarregaAlteraUsuario&cod=${c.cd_usuario }" method="post"><input type="submit" value="altera"></form></td>
					<td><form action="sistema?acao=DeletaUsuario&cod=${c.cd_usuario }" method="post"><input type="submit" value="exclui"></form></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>