<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>HM - Funcionário</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/hmweb.css">
</head>
<body>
	<c:import url="../cabecalho.jsp"/>
	<div class="container">
		<form action="funcionarioConsultar" method="post">
			<h1 class="page-header">Lista de funcionários</h1>
			<c:if test="${sucesso != null}">
				<div class="alert alert-success">
					<span class="glyphicon glyphicon-ok"></span>
					<strong>${sucesso}.</strong>
				</div>
			</c:if>
			<c:if test="${erro != null}">
				<div class="alert alert-danger">
					<span class="glyphicon glyphicon-alert"></span>
					<strong>${erro}.</strong>
				</div>
			</c:if>
			</br>
			<div class="input-group">
				<input type="text" name="busca" placeholder="Digite nome ou RNE" class="form-control"/>
				<div class="input-group-btn">
					<button type="submit" name="operacao" value="Consultar" class="btn btn-success" formaction="funcionarioConsultar">
						<span class="glyphicon glyphicon-search"></span> Buscar
					</button>
				</div>
			</div>
			</br>
			</br>
			<c:if test="${not empty consulta}">
				<div class="table-responsive">
					<table class="table table-striped table-condensed">
						<thead>
							<tr>
								<th>NOME</th>
								<th>CPF</th>
								<th>RNE</th>
								<th>CARGO</th>
								<th>
									<span class="glyphicon glyphicon-cog"></span> AÇÕES
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${consulta}" var="f">
								<tr>
									<td>${f.nome}</td>
									<td>${f.cpf}</td>
									<td>${f.rne}</td>
									<td>${f.cargo}</td>
									<td>
										<button type="submit" name="alterar" value="Alterar" method="get" class="btn btn-default" data-toggle="tooltip" title="Alterar"
										formaction="funcionarioAlterar?id=${f.id}&nome=${f.nome}&cpf=${f.cpf}&rne=${f.rne}&cargo=${f.cargo}">
											<span class="glyphicon glyphicon-pencil"></span>
										</button>
										<button type="submit" name="operacao" method="get" data-toggle="tooltip" title="Excluir"
										value="Excluir" onclick="return teste()" class="btn btn-danger"
										formaction="funcionarioExcluir?id=${f.id}">
											<span class="glyphicon glyphicon-trash"></span>
										</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
			</br>
			<button class="btn btn-success" type="submit" formaction="funcionarioForm">
				<span class="glyphicon glyphicon-plus"></span> Novo funcionário
			</button>
			</br>
		</form>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function(){
	   		$('[data-toggle="tooltip"]').tooltip();   
		});
		function teste(event) {
			if (confirm("Deseja realmente excluir?") == false) {
				return false;
			}
		}
	</script>
</body>
</html>