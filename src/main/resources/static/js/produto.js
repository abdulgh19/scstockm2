// JS para prencher a Combobox de produtos com base nas categorias
function listaCategorias(){
    var idMarca = $("#marca  option:selected").val();
	$
		.ajax({
		    method: "GET",
			url : '/viaturas/modelos/marca/' + idMarca,
            async : true
		})
		.done(function(data) {
            $("#modelo").html(" <option>Selecione o modelo da Viatura</option>"); //Antes de listar os modelos com appen mostra o seguinte texto
			$.each(data, function(key, value){
                $("#modelo").append($('<option>', {
					value : value.id,
					text :  value.designacao,
				}));
			});
		});
}


$("#marca").change(function() {
    //var marca = $("#marca option:selected").text();
    //console.log(marca);
	listaCategorias();
  });










