package mz.co.devtec.scstockm2.datatables;

public class DatatablesColunas {


	public static final String[] CATEGORIAS = {"id", "designacao"};
	
	public static final String[] GRUPOS = {"id", "designacao", "categoria.designacao"};
	
	public static final String[] PRODUTOS = {"id", "designacao", "quantidade", "grupo.designacao"};
	
	public static final String[] UNIDADES = {"id", "designacao", "tipo.designacao"};
	
	public static final String[] TIPOS = {"id", "designacao"};

	public static final String[] ENTRADAS = {"id", "data_entrada"};

	

	

}



