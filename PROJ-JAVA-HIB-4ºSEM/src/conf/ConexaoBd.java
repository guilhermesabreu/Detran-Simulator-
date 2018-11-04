package conf;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class ConexaoBd {
		
		public static Connection faz_conexao() throws SQLException{
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
			   return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_placas","root","");
			   
			}
		    catch(ClassNotFoundException e) {
		    	JOptionPane.showMessageDialog(null, e.toString());
		    	
		    }
			catch(SQLException e2) {
		    	JOptionPane.showMessageDialog(null, e2.toString());
		    	
			}
			return null;
		} 

}