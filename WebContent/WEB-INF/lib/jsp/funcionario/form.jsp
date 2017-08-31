<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>HM - Funcionario</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/hmweb.css">
</head>
<body>
	<c:import url="../cabecalho.jsp"/>
	<div class="container">
		<form class="form" role="form" action="funcionarioSalvar" method="post">
			<h1 class="page-header">Cadastro de funcionário</h1>
			<c:if test="${mensagens != null}">
				<div class="alert alert-danger" role="alert">
					<span class="glyphicon glyphicon-alert"></span><strong> Problema(s) na inserção:</strong>
					</br>
					<c:forEach var="mensagem" items="${mensagens}">
						${mensagem}.
						</br>
					</c:forEach>
				</div>
			</c:if>
			</br>
			<div class="form-group">
				<label for="nome" class="control-label">Nome</label>
				<input type="text" name="nome" value="${funcionario.nome}" class="form-control">
			</div>
			<div class="form-group">
				<label for="cargo" class="control-label">Cargo</label>
				<input type="text" name="cargo" value="${funcionario.cargo}" class="form-control">
			</div>
			<div class="form-group">
				<label for="cpf" class="control-label">CPF</label>
				<input type="text" name="cpf" value="${funcionario.cpf}" class="form-control">
			</div>
			<div class="form-group">
				<label for="cpf" class="control-label">RNE</label>
				<input type="text" name="rne" value="${funcionario.rne}" class="form-control">
			</div>
			<div class="form-group">
				<input type="submit" name="operacao" value="Salvar" class="btn btn-success"/>
			</div>
		</form>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
</body>
</html>