package cosas;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DAO {
	

    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;
    
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "entretenimiento";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";//`com.mysql.cj.jdbc.Driver'   
    
    protected void conectarBase() throws ClassNotFoundException,SQLException{
        try{
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?serverTimezone=UTC";
            conexion = DriverManager.getConnection(urlBaseDeDatos,USER,PASSWORD);
        }catch(ClassNotFoundException | SQLException ex){
            throw ex;
        }
    
    }   
    
    protected void desconectarBase() throws Exception{
        try{
            if(resultado != null){
                resultado.close();
            }
            if(sentencia != null){
                sentencia.close();
            }
            if(conexion != null){
                conexion.close();
            }
        
        }catch(Exception e){
            throw e;
        }
    
    }
    
    //este método no se usará en esta aplicación
    protected void insertarModificarEliminar(String sql) throws Exception {
        try{
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        
        }catch(SQLException | ClassNotFoundException ex){
            
            throw ex;
        
        }finally{
            desconectarBase();
        }
    
    }
    
    protected void consultarBase(String sql) throws Exception {
        
        try{
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        
        }catch(Exception e){
            
            throw e;
        
        }
       
    }

	public ResultSet getResultado() {
		return resultado;
	}


}
