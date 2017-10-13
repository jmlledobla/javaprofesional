package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import javabeans.Libro;
import javabeans.Tema;

public class GestionLibros {

DataSource ds;
	
	public GestionLibros() {
		//carga del driver
		try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	}
	
public List<Libro> recuperarTodos(){
		
		ArrayList<Libro> libros=new ArrayList<>();
		//creamos la conexiÛn contra la base de datos
				try (Connection cn=ds.getConnection()){							
					//definimos la instrucciÛn SQL y la enviamos a travÈs del objeto Statement
					String sql="Select * from libros";
					Statement st=cn.createStatement();
					ResultSet rs=st.executeQuery(sql);
					while(rs.next()) {
						libros.add(new Libro(rs.getInt("isbn"),
								             rs.getString("titulo"),
								             rs.getString("autor"),
								             rs.getDouble("precio"),
								             rs.getInt("paginas"), 
								             rs.getInt("idTema")));
								
					}										
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
		
		return libros;
	}

public List<Libro> recuperarLibrosTema(int id){
	
	ArrayList<Libro> libros=new ArrayList<>();
	//creamos la conexiÛn contra la base de datos
			try (Connection cn=ds.getConnection()){							
				//definimos la instrucciÛn SQL y la enviamos a travÈs del objeto Statement
				String sql="Select * from libros where idTema="+id;
				Statement st=cn.createStatement();
				ResultSet rs=st.executeQuery(sql);
				while(rs.next()) {
					libros.add(new Libro(rs.getInt("isbn"),
							             rs.getString("titulo"),
							             rs.getString("autor"),
							             rs.getDouble("precio"),
							             rs.getInt("paginas"), 
							             rs.getInt("idTema")));
							
				}										
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
	
	return libros;
}
	
}
