// JS para prencher a Combobox de modelos com base nas marcas
function listaCategorias(){
    var idCategoria = $("#categoria  option:selected").val();
	$
		.ajax({
		    method: "GET",
			url : '/produtos/grupos/categoria/' + idCategoria,
            async : true
		})
		.done(function(data) {		//O "data" eh o ResponseBody ou seja a Lista de Grupos que vem via HTPS GET vinda do controller
            $("#grupo").html(" <option>Selecione o grupo para o Produto </option>"); //Antes de listar os grupos com append mostra o seguinte texto
			$.each(data, function(key, value){
                $("#grupo").append($('<option>', {
					value : value.id,
					text :  value.designacao,
				}));
			});
		});
}


$("#categoria").change(function() {
	listaCategorias();
  });

