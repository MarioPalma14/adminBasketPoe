/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2labo_mpwt;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Alejandro
 */
public class conexion {
    Connection conexion=null;
    static String url = "jdbc:mysql://localhost:3306/mp";
    static String usuario = "root";
    static String contraseña = "";
    
    public conexion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
       try {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
           this.conexion = (Connection)DriverManager.getConnection(url, usuario, contraseña);
       } 
       catch (SQLException e) {   
       }
   }
    public ResultSet query(String consulta) throws SQLException{
       Statement datos = this.conexion.createStatement();
       return datos.executeQuery(consulta);
   }
    
   public int query_ingreso_actu_elim(String consulta) throws SQLException{
       Statement datos = this.conexion.createStatement();
       return datos.executeUpdate(consulta);
   }

}
