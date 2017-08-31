<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>HM - Cliente</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/hmweb.css">
</head>
<body>
	<c:import url="../cabecalho.jsp" />
	<div class="container">
		<h1 class="page-header titulo">Informações do cliente</h1>
		<form class="pull-right" action="#" method="post">
			<button class="botao-voltar btn-icone btn btn-sm btn-default" data-toggle="tooltip" title="Voltar">
				<span class="glyphicon glyphicon-arrow-left"></span>
			</button>
			<button type="submit" data-toggle="tooltip" title="Editar"
			class="btn btn-sm btn-default btn-icone" method="get" formaction="clienteEdit?operacao=Consultar&id=${cliente.id}">
				<span class="glyphicon glyphicon-pencil"></span>
			</button>
			<button type="submit" name="operacao" method="get" data-toggle="tooltip" title="Excluir" value="Excluir"
			onclick="return excluir()" class="btn btn-sm btn-danger botao-excluir btn-icone" formaction="clienteExcluir?id=${cliente.id}">
				<span class="glyphicon glyphicon-trash"></span>
			</button>
		</form>
	</div>
	<div class="container">
		<div class="row">
			<div class="container">
				<div class="panel-group">
					<div class="panel panel-lg panel-default col-md-4 painel primeiro">
						<div class="panel-heading">							
							<span class="glyphicon glyphicon-user"></span>
							<span class="titulo-painel">Dados Pessoais</span>
						</div>
						<div class="panel-body">
							<dl>
								<dt>Nome</dt>
								<dd>${cliente.nome}</dd>
								<dt>Data de nascimento</dt>
								<dd>${cliente.dataNascimento}</dd>
								<dt>CPF</dt>
								<dd>${cliente.cpf}</dd>
								<dt>RG</dt>
								<dd>${cliente.rg}</dd>
							</dl>
						</div>
					</div>
					<div class="panel panel-lg panel-default col-md-4 painel">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-map-marker"></span>
							<span class="titulo-painel">Endereço</span>
						</div>
						<div class="panel-body">
							<dl>
								<dt>CEP</dt>
								<dd>${cliente.endereco.cep}</dd>
								<dt>Rua</dt>
								<dd>${cliente.endereco.rua}</dd>
								<dt>Número</dt>
								<dd>${cliente.endereco.numero}</dd>
								<dt>Complemento</dt>
								<dd>${cliente.endereco.complemento}</dd>
								<dt>Bairro</dt>
								<dd>${cliente.endereco.bairro}</dd>
								<dt>Cidade</dt>
								<dd>${cliente.endereco.cidade}</dd>
								<dt>Estado</dt>
								<dd>${cliente.endereco.estado}</dd>
							</dl>
						</div>
					</div>
					<div class="panel panel-lg panel-default col-md-4 painel">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-earphone"></span>
							<span class="titulo-painel">Telefone</span>
						</div>
						<div class="panel-body">
							<dl>
								<dt>DDD</dt>
								<dd>${cliente.telefone.ddd}</dd>
								<dt>Número</dt>
								<dd>${cliente.telefone.numero}</dd>
								<dt>Operadora</dt>
								<dd>${cliente.telefone.operadora}</dd>
							</dl>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="resources/js/hmweb.js"></script>
</body>
</html>