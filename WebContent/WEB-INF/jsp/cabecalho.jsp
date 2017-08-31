<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>	
	#logo {
		height: 100%;
		position: absolute;
	}
	.navbar-logo {
		padding: 0;
		padding-left: 10px;	
	}
	.navbar-cabecalho {
		position: relative;
		height: 100%;
	}
</style>
<header>
	<nav id="navbar" role="navigation" class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header navbar-cabecalho">
				<a href="#" class="navbar-brand navbar-logo">
					<img id="logo" alt="Hayah Modas Logo" src="resources/img/hmlogo.png"/>
				</a>
				<button type="button" class="navbar-left navbar-toggle collapsed"
				data-toggle="collapse" data-target="#menu-collapse"
				aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>
			<div id="menu-collapse" class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="clienteLista">Cliente</a></li>
					<li><a href="funcionarioListar">Funcionário</a></li>
					<li><a href="#depoimentos">Sobre</a></li>
					<li><a href="#contato">Contato</a></li>
				</ul>
			</div>
		</div>
	</nav>
</header>