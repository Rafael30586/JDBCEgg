package cosas;

import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ResultSet resultado;
		
		DAO dao = new DAO();
		dao.consultarBase("select nombre from consolas");
		
		resultado = dao.getResultado();
		
		//System.out.print(resultado);
		
		while (resultado.next()) {
            System.out.print(resultado.getString("Nombre") + "\t");
            System.out.println("");
        }

	}

}
