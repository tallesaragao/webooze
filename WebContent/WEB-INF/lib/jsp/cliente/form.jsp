<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>HM - Cliente</title>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/hmweb.css">
</head>
<body>
	<c:import url="../cabecalho.jsp"/>
	<div class="container">
		<form class="form" role="form" action="#" method="post">
			<c:choose>
				<c:when test="${operacao eq 'ALTERAR'}">
					<h1 class="page-header titulo">Alteração de cliente</h1>	
				</c:when>
				<c:otherwise>
					<h1 class="page-header titulo">Cadastro de cliente</h1>				
				</c:otherwise>
			</c:choose>
			
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
			
			<fieldset>
				<legend>
					<span class="legend-logo glyphicon glyphicon-user"></span> Dados pessoais
				</legend>
				
				<input type="hidden" name="id" value="${cliente.id}"/>
				
				<div class="row">
					<div class="form-group col-sm-6 col-md-5">
						<label for="nome" class="control-label">Nome</label>
						<input type="text" name="nome" value="${cliente.nome}" class="form-control"/>
					</div>
					
					<div class="form-group col-sm-3 col-md-2 col-sm-offset-1">
						<label for="dataNascimento" class="control-label">Data Nascimento</label>
						<input type="text" name="dataNascimento" <c:if test="${operacao eq 'ALTERAR'}"> readonly </c:if> 
						class="form-control data" value="<fmt:formatDate value="${cliente.dataNascimento}" pattern="dd/MM/yyyy"/>"/>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-sm-3 col-md-2">
						<label for="rg" class="control-label">RG</label>
						<input type="text" <c:if test="${operacao eq 'ALTERAR'}"> readonly </c:if>
						name="rg" value="${cliente.rg}" class="form-control rg"
						/>
					</div>
					
					<div class="form-group col-sm-3 col-md-2 col-md-offset-1">
						<label for="cpf" class="control-label">CPF</label>
						<input type="text" <c:if test="${operacao eq 'ALTERAR'}"> readonly </c:if>
						name="cpf" value="${cliente.cpf}" class="form-control cpf"/>
					</div>
				</div>
			</fieldset>
			</br>
			<fieldset>
				<legend>
					<span class="legend-logo glyphicon glyphicon-map-marker"></span> Endereço
				</legend>
				
				<div class="row">
					
					<div class="form-group col-xs-12 col-sm-2">
						<label for="cep" class="control-label">CEP</label>
						<input type="text" id="cep" name="cep" value="${cliente.endereco.cep}" class="form-control cep"/>
					</div>
					
					<div class="form-group col-xs-9 col-sm-4 col-md-3 col-lg-3">
						<label for="cidade" class="control-label">Cidade</label>
						<input type="text" id="cidade" name="cidade" value="${cliente.endereco.cidade}" class="form-control"/>
					</div>
					
					<div class="form-group col-xs-3 col-sm-2">
						<label for="estado" class="control-label">Estado</label>
						<input type="text" id="estado" name="estado" value="${cliente.endereco.estado}" class="form-control estado"/>
					</div>
					
										
					<div class="form-group col-xs-12 col-sm-3">
						<label for="bairro" class="control-label">Bairro</label>
						<input type="text" id="bairro" name="bairro" value="${cliente.endereco.bairro}" class="form-control"/>
					</div>
					
				</div>
				<div class="row">
					<div class="form-group col-xs-12 col-sm-5">
						<label for="rua" class="control-label">Rua</label>
						<input type="text" id="rua" name="rua" value="${cliente.endereco.rua}" class="form-control"/>
					</div>
					
					<div class="form-group col-xs-3 col-sm-2 col-lg-1">
						<label for="numeroEnd" class="control-label">Número</label>
						<input type="text" id="numeroEnd" name="numeroEnd" value="${cliente.endereco.numero}" class="form-control"/>
					</div>
					
					<div class="form-group col-xs-9 col-sm-4 col-md-3 col-lg-4">
						<label for="complemento" class="control-label">Complemento</label>
						<input type="text" name="complemento" value="${cliente.endereco.complemento}" class="form-control"/>
					</div>
				</div>
			</fieldset>
			</br>
			<fieldset>
				<legend>
					<span class="legend-logo glyphicon glyphicon-earphone"></span> Telefone(s)
				</legend>

				<div class="row">
					<div class="form-group col-xs-3 col-sm-2 col-md-1">
						<label for="ddd" class="control-label">DDD</label>
						<input type="text" name="ddd" value="${cliente.telefone.ddd}" class="form-control ddd"/>
					</div>
					
					<div class="form-group col-xs-9 col-sm-4 col-md-3">
						<label for="numeroTel" class="control-label">Número</label>
						<input type="text" name="numeroTel" value="${cliente.telefone.numero}" class="form-control numeroTel"/>
					</div>
					
					<div class="form-group col-xs-12 col-sm-3 col-md-2">
						<label for="operadora" class="control-label">Operadora</label>
						<input type="text" name="operadora" value="${cliente.telefone.operadora}" class="form-control"/>
					</div>
				</div>
			</fieldset>
			</br>
			<div class="row">
				<c:choose>
					<c:when test="${operacao eq 'ALTERAR'}">
						<div class="form-group col-xs-1">
							<button type="submit" name="operacao" value="Alterar" formaction="clienteAlterar" class="btn btn-success">
								Alterar
							</button>
						</div>					
					</c:when>
					<c:otherwise>
						<div class="form-group col-xs-1">
							<button type="submit" name="operacao" value="Salvar" formaction="clienteSalvar" class="btn btn-success">
								Salvar
							</button>
						</div>					
					</c:otherwise>
				</c:choose>
				<div class="form-group col-xs-1 col-xs-offset-2 col-sm-offset-1 col-md-offset-0">
					<a href="clienteLista" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="resources/js/jquery-3.1.1.js"></script>
	<script src="resources/bootstrap/js/bootstrap.js"></script>
	<script src="resources/js/jquery.mask.js"></script>
	<script src="resources/js/clienteForm.js"></script>
</body>
</html>