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

import javabeans.Tema;

public class GestionTemas {
	
	DataSource ds;
	
	public GestionTemas() {
		
		try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	}
	
	public List<Tema> recuperarTemas(){
		
		ArrayList<Tema> temas=new ArrayList<>();
		//creamos la conexiÛn contra la base de datos
				try (Connection cn=ds.getConnection()){							
					//definimos la instrucciÛn SQL y la enviamos a travÈs del objeto Statement
					String sql="Select * from temas";
					Statement st=cn.createStatement();
					ResultSet rs=st.executeQuery(sql);
					while(rs.next()) {
						temas.add(new Tema(rs.getInt("idTema"),
								rs.getString("tema")));
								
					}										
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
		
		return temas;
	}

}
