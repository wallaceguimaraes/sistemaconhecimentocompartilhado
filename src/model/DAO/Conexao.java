package model.DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	
	
	
	
	

	private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static String url = "jdbc:derby:C:/Users/Wallace Guimaraes/SCC;create=true";
	private static String user = "SCC";
	private static String password = "scc123";
	private static Connection conn;
	public  ResultSet rs;
	public  java.sql.Statement stm ;
	public  Connection con;
	public Connection conectando;
	
	
	public static Connection getConnection(){

		try {
			Class.forName(driver);

			
			return DriverManager.getConnection(url, user, password);
			//System.setProperty("jdbc.Drivers", driver);	// seta a propriedade do driver de conexao			
			
			//con = DriverManager.getConnection(url,user,password);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro na conex�o!"+e);
		}

	}
	
	
	public Connection conexao (){ // m�todo respons�vel por realizar a conexao com o banco
		
		try {
			System.setProperty("jdbc.Drivers", driver);	// seta a propriedade do driver de conexao			
			
			conectando = DriverManager.getConnection(url,user,password);// realiza a conexao com o banco
		
//			JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro de conex�o!\n Erro:"+e.getMessage());

		}
		return conectando;
	
	
	}
	
	

	
	public void executaSQL(String sql) {
		// TODO Auto-generated method stub
		try {
			try {
				stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				rs = stm.executeQuery(sql);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//ResultSet res = ps.executeQuery();//ex
		
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "erro no executa SQL"+e);
			//e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	public static void desconectaConexao(Connection con){
		try{
			if(con != null)
			con.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void closeConnection(Connection con, PreparedStatement pst){
		
	   	desconectaConexao(con);
		try{
			if(pst != null){
				pst.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
public static void closeConnection(Connection con, PreparedStatement pst, ResultSet rs){// Sobrecarga de m�todos, polimorfismo
		
       closeConnection(con, pst);		
		try{
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
}
