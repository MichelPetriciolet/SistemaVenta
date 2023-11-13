
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class ProductosDao {
    
Connection con;
conexion cn = new conexion();
PreparedStatement ps;
 ResultSet rs;

public boolean Registrarproductos(Productos pro){
String sql="INSERT INTO productos (codigo,nombre,proveedor,stock,precio) VALUES (?,?,?,?,?)";

try{
con =cn.conector();
ps = con.prepareStatement(sql);

ps.setString(1, pro.getCodigo());
ps.setString(2, pro.getNombre());
ps.setString(3, pro.getProveedor());
ps.setInt(4, pro.getStock());
ps.setDouble(5, pro.getPrecio());
ps.execute();
return true;

}catch(Exception e){

JOptionPane.showMessageDialog(null,""+e);

}


return false;
}


public Productos BuscarPro(String cod){

Productos producto = new Productos();

String sql= "SELECT * FROM productos WHERE codigo=?";
try{
con=cn.conector();
ps = con.prepareStatement(sql);
ps.setString(1, cod);
rs = ps.executeQuery();
if(rs.next()){
producto.setNombre(rs.getString("nombre"));
producto.setPrecio(rs.getDouble("precio"));
producto.setStock(rs.getInt("stock"));
}



}catch(Exception e){
JOptionPane.showMessageDialog(null, e);
}


return producto;
}

public void cargarboton(JComboBox proveedor) {

     
          String sql =("SELECT nombre FROM proveedor");
     
        try { 
         
          con=cn.conector();
         ps=con.prepareStatement(sql);
         rs = ps.executeQuery();
         while(rs.next()){
      proveedor.addItem(rs.getString("nombre"));
           
         }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}
