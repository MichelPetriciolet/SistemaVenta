
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vista.Sistema;


public class conexion {

    public static Connection conector;

Connection cn;

public Connection conector(){
try{
Class.forName("com.mysql.jdbc.Driver");
cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/sistemaventa","root","");
System.out.print("CONECTADO");
}catch(Exception e){
System.out.println("ERROR DE CONEXIONBD"+e);
}
return cn;

}




}

    

