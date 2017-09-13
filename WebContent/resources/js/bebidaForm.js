$(function(){
    $('input[type=radio][name=alcoolica]').change(function() {
        if (this.value == '1') {
            $('#teorAlcool').attr('disabled', false);
        }
        else {
        	$('#teorAlcool').val("");
        	$('#teorAlcool').attr('disabled', true);
        }
    });
});
	