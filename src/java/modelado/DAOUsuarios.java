
package modelado;

import java.sql.*;
import java.util.*;
import uml.*;

public class DAOUsuarios {
    Database db = new Database();
    
    
     public List<Usuarios> accesar(String usuario, String contra) {
       List<Usuarios> datos = new ArrayList<>();
       Connection conn;
       PreparedStatement pst;
       ResultSet rs;
       String sql = "select nombre_completo, nivelUsuario from usuarios "
               + "where usuario='" + usuario + "' and contra='" + contra+
               "'";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new Usuarios(rs.getString("nombre_completo"), 
                                       rs.getInt("nivelUsuario")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
       return datos;
    }
    
    
    
}
