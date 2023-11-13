
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class VentaDao {

  Connection con;
conexion cn = new conexion();
PreparedStatement ps;
 ResultSet rs;
int r;
    public int RegistrarVenta( Venta v){
      String sql= "INSERT INTO ventas (cliente,vendedor,total)  VALUES (?,?,?)";

try{
con =cn.conector();
ps=con.prepareStatement(sql);
ps.setString(1,v.getCliente());
ps.setString(2,v.getVendedor());
ps.setDouble(3,v.getTotal());
ps.execute();



}catch(SQLException e){
JOptionPane.showMessageDialog(null,"ERROR"+e);
}finally {

try{
con.close();
}
catch(Exception e){
JOptionPane.showMessageDialog(null,"ERROR"+e);
}

}
return r;
}


public int RegistrarDetalle(Detalle Dv){
String sql="INSERT INTO detalle_venta (codigo_pro,cantidad,precio,id_venta) VALUES(?,?,?,?)";
try{
con =cn.conector();
ps=con.prepareStatement(sql);
ps.setString(1,Dv.getCod_pro());
ps.setInt(2,Dv.getCantidad());
ps.setDouble(3,Dv.getPrecio());
ps.setInt(4,Dv.getId());
ps.execute();

}

catch(SQLException e){
JOptionPane.showMessageDialog(null,"ERROR"+e);
}finally {
try{
con.close();
}
catch(Exception e){
JOptionPane.showMessageDialog(null,"ERROR"+e);
}

}
return r;
}


public int IdVenta(){
int id=0;
String sql ="SELECT MAX(id) FROM ventas";
try{
con =cn.conector();
ps=con.prepareStatement(sql);
rs=ps.executeQuery();
if(rs.next()){
id= rs.getInt(1);

}
}
catch(Exception e){
JOptionPane.showMessageDialog(null,"ERROR"+e);
}
return id;
}


public boolean  ActualizarStock(int cant, String cod ){

String sql="UPDATE productos SET stock = ? WHERE codigo=? ";
try{
  con=cn.conector();
ps = con.prepareStatement(sql);
ps.setInt(1, cant);
ps.setString(2, cod);
ps.execute();
return true;

}catch(Exception e){

JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR" +e);
return false;
}

}

}


