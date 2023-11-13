
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClientesDao {  
     Connection con;
conexion cn = new conexion();
PreparedStatement ps;
 ResultSet rs;


public boolean Registrarclientes(Cliente cl) {
String sql="{CALL agregar_clientes (?,?,?,?,?,?,?,?,?)}";

try{
con =cn.conector();
ps = con.prepareCall(sql);



ps.setInt(1, cl.getDni());
ps.setString(2, cl.getNombre());
ps.setString(3, cl.getApellido_p());
ps.setString(4, cl.getApellido_m());
ps.setString(5, cl.getColonia());
ps.setString(6, cl.getCalle());
ps.setString(7, cl.getCP());
ps.setString(8, cl.getTelefono());
ps.setString(9, cl.getEstatus());
ps.execute();
return true;
}catch(SQLException e){

JOptionPane.showMessageDialog(null,""+e);
return false;
} finally{
try{

con.close();
}
catch(SQLException e){
JOptionPane.showMessageDialog(null,""+e);
}

}



}

public Cliente Buscarcliente(int dni){

Cliente cl= new Cliente();

String sql="SELECT * FROM clientes WHERE dni=?";
try{
con=cn.conector();
ps = con.prepareStatement(sql);
ps.setInt(1, dni);
rs=ps.executeQuery();
if(rs.next()){
cl.setNombre(rs.getString("nombre"));
cl.setApellido_p(rs.getString("apellido_p"));
cl.setApellido_m(rs.getString("apellido_m"));
cl.setColonia(rs.getString("colonia"));
cl.setCalle(rs.getString("calle"));
cl.setCP(rs.getString("CP"));
cl.setTelefono(rs.getString("telefono"));
cl.setEstatus(rs.getString("estatus"));

}
}catch(Exception e){

JOptionPane.showMessageDialog(null,"ERROR"+e);

}


return cl;
}

}
