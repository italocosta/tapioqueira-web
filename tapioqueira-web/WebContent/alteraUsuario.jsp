<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Alteração de Usuários</title>
	</head>
	<body>
		<form action="sistema" method="post">
			<input type="hidden" name="acao" value="AlteraUsuario">
			<input type="hidden" name="cod" value="${user.cd_usuario }">
			Nome Completo : <input type="text" name="nome" value="${user.nm_usuario }"><br>
			Tipo : <select name="tipo">
						
						<option value="G" ${user.tp_usuario == 'G' ? 'selected' : '' }>Garçom</option>
						<option value="C" ${user.tp_usuario == 'C' ? 'selected' : '' }>Caixa</option>
				   </select><br>
			Login : <input type="text" name="login" value="${user.nm_login }"><br>
			Senha : <input type="password" name="senha"><br>
			<input type="submit" value="Salvar">
		</form>
	</body>
</html>