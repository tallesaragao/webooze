$(function (){
	$.ajax({
		type: 'GET',
		url: 'categoriaConsultar?operacao=CONSULTAR&ajax=true&busca=',
		success: function(data) {
			console.log('I have friends!', data);
		}
	});
});