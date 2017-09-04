<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WeBooze</title>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap-theme.min.css">
</head>
<body>
	<c:import url="../cabecalho.jsp"/>
	<div class="container">
		<h1>Cadastro de Categoria</h1>
	</div>
		<div class="row">
			<div class="container">
				<form class="form" action="#" method="post">
					<fieldset>
						<legend>Dados da Categoria</legend>
						<div class="form-group">
							<label for="nome" class="control-label">Nome</label>
							<input type="text" name="nome" placeholder="Nome" class="form-control"/>
						</div>
						<div class="form-group">
							<label for="diasValidade" class="control-label">Validade</label>
							<input type="text" name="diasValidade" placeholder="Dias"
							class="form-control"/>
						</div>						
						<button type="submit" name="operacao" value="Salvar"
						formaction="categoriaSalvar" class="btn btn-primary">Salvar</button>
					</fieldset>
				</form>
			</div>
		</div>
	</form>
</body>
</html>