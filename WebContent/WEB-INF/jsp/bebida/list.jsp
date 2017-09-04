<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>WeBooze</title>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/hmweb.css">
</head>
<body>
	<c:import url="../cabecalho.jsp"/>
	<div class="container">
		<h1 class="page-header titulo">Lista de categorias</h1>
		<c:if test="${sucesso != null}">
			<div class="alert alert-success alert-dismissible">
				<span class="glyphicon glyphicon-ok"></span>
				<strong>${sucesso}.</strong>				
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
			
		<c:if test="${erro != null}">
			<div class="alert alert-danger alert-dismissible">
				<span class="glyphicon glyphicon-alert"></span>
				<strong>${erro}.</strong>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<form action="#" method="post">
			<div class="row pesquisa">
				<div class="col-xs-12">
					<div class="row">
						<div class="col-xs-10 col-md-7">
							<div class="input-group input-group-md">
								<input type="text" name="busca" placeholder="Faça sua busca" class="form-control"/>
								<div class="input-group-btn">
									<button type="submit" class="btn btn-md btn-primary btn-icone"
									name="operacao" value="Consultar" formaction="categoriaConsultar">
										<span class="glyphicon glyphicon-search"></span>
									</button>
								</div>
							</div>
						</div>
						<div class="col-xs-2 col-md-3 btn-adicionar">			  	
							<button class="btn btn-primary btn-icone" type="submit" formaction="categoriaForm"
							data-toggle="tooltip" title="Adicionar categoria">
								<span class="glyphicon glyphicon-plus"></span>
							</button>
						</div>
					</div>
				</div>
			</div>	
			
			<c:if test="${not empty consulta}">
				<div class="row">
					<div class="table-responsive tabela-clientes">
						<div class="col-sm-11 col-md-8">
							<table class="table table-striped table-condensed">
								<thead>
									<tr>
										<th>NOME</th>
										<th>
											<span class="glyphicon glyphicon-cog icone-engrenagem"></span>
										</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${consulta}" var="c">
										<tr>
											<td>${c.nome}</td>
											<td>
												<button type="submit" name="view" data-toggle="tooltip" title="Visualizar" 
												class="btn btn-sm btn-default btn-icone" method="get" formaction="clienteView?operacao=Consultar&id=${c.id}">
													<span class="glyphicon glyphicon-eye-open"></span>
												</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</c:if>		
		</form>
		
	</div>
	<script src="resources/js/jquery-3.1.1.js"></script>
	<script src="resources/bootstrap/js/bootstrap.js"></script>
	<script src="resources/js/jquery.mask.js"></script>
	<script src="resources/js/clienteForm.js"></script>
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