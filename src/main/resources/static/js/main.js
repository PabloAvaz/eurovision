$(window).on("load", function(){
	$('#personaCombo').change(function(e){
		$("#formCambioPersona").submit();
	});
})