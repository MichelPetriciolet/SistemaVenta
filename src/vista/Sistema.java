/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Cliente;
import modelo.ClientesDao;
import modelo.Detalle;
import modelo.Productos;

import modelo.ProductosDao;
import modelo.Venta;
import modelo.VentaDao;
import modelo.conexion;

/**
 *
 * @author JOSUE MICHEL
 */
public class Sistema extends javax.swing.JFrame {

   modelo.conexion con=new conexion();
Connection cn=con.conector();
Productos pro = new Productos();
ProductosDao prodao = new ProductosDao();

Cliente cl = new Cliente();
ClientesDao client = new ClientesDao();

Venta v = new Venta();
VentaDao vdao = new VentaDao();
Detalle Dv= new Detalle();





int  item;
double Totalpagar=0.00;


    public Sistema() {
        initComponents();
  prodao.cargarboton(cbxProveedorPro);
    this.setLocationRelativeTo(null);

    }
//////////////////////////////////////////////////////LIMPIAR VALORES DE LAS TABLAS
public void Limpiar(){

 txtIdCliente.setText("");        
txtDniCliente.setText("");
txtNombreCliente.setText("");
txtApellidoPCliente.setText("");
txtApellidoMCliente.setText("");
txtColoniaCliente.setText("");
txtCalleCliente.setText("");
txtCPCliente.setText("");
txtTelefonoCliente.setText("");
}


public void Limpiarpro(){

txtIdProveedor.setText("");        
txtRucProveedor.setText("");
txtNombreProveedor.setText("");
txtCorreoPr.setText("");
txtColoniaProveedor.setText("");
txtCalleProveedor.setText("");
txtCPProveedor.setText("");
txtTelefonoProveedor.setText("");
}

public void Limpiarprodu(){

txtIdProducto.setText("");        
txtCodigoProducto.setText("");
txtDescripcionProducto.setText("");

cbxProveedorPro.setSelectedItem("");
txtCantidadProducto.setText("");
txtPrecioProducto.setText("");

}

public void Limpiarventa(){
DefaultTableModel modeloTabla = (DefaultTableModel) tableVenta.getModel();
txtRucVenta.setText("");        
txtNombreClienteVenta.setText("");
labelTotal.setText("");
int cantidades =tableVenta.getRowCount();
for( int i =cantidades-1 ; i>=0;i--){
            modeloTabla.removeRow(i);}




}


//////////////////////////////////////////////////////////////////////TABLAS
 public void cargarTabla() {

        DefaultTableModel modeloTabla = (DefaultTableModel) tableCliente.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        int[] anchos = {10,50,100,100,100,100,100,50,100,50};
        for(int i =0 ; i<tableCliente.getColumnCount();i++){
           tableCliente.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
       
        try { 
            Connection c=con.conector();
            ps = c.prepareStatement("SELECT id, dni,nombre,apellido_p,apellido_m,colonia,calle,CP,telefono,estatus FROM clientes");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[columnas];

                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1);
                }
                modeloTabla.addRow(fila);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

public void cargarTablaPro() {

       DefaultTableModel modeloTabla = (DefaultTableModel) tableProveedor.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        int[] anchos = {5,50,100,100,100,50,100,50,50};
        for(int i =0 ; i<tableProveedor.getColumnCount();i++){
           tableProveedor.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
       
        try { 
            Connection c=con.conector();
            ps = c.prepareStatement("SELECT id, ruc,nombre,correo,colonia,calle,CP,telefono,estatus FROM proveedor");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[columnas];

                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1);
                }
                modeloTabla.addRow(fila);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }




public void cargarTablaVenta() {

       DefaultTableModel modeloTabla = (DefaultTableModel) tableVentas.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        int[] anchos = {5,50,50,50}; 
        for(int i =0 ; i<tableVentas.getColumnCount();i++){
           tableVentas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
       
        try { 
            Connection c=con.conector();
            ps = c.prepareStatement("SELECT id,cliente,vendedor,total FROM ventas");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[columnas];

                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1);
                }
                modeloTabla.addRow(fila);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }


public void cargarTablaProduc() {

       DefaultTableModel modeloTabla = (DefaultTableModel) tableProducto.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        int[] anchos = {5,50,100,50,50,100};
        for(int i =0 ; i<tableProducto.getColumnCount();i++){
           tableProducto.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
       
        try { 
            Connection c=con.conector();
            ps = c.prepareStatement("SELECT id,codigo,nombre,proveedor,stock,precio FROM productos");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[columnas];

                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1);
                }
                modeloTabla.addRow(fila);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }




   PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;




public void buscarProducto(String cod){
 
String sql = "SELECT * FROM productos WHERE codigo =?";

try{
cn=con.conector();
ps=cn.prepareStatement(sql);
ps.setString(1, cod);
rs=ps.executeQuery();
if(rs.next()){
rs.getString("nombre");
rs.getFloat("precio");
rs.getInt("stock");

}

}catch(Exception e){
JOptionPane.showMessageDialog(null, e);
}


}
////////////////////////////////INGRESO DE METODOS DE LAS TABLAS Y LIMPIAR LOS VALORES

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnEliminarVenta = new javax.swing.JButton();
        txtCodigoventa = new javax.swing.JTextField();
        txtdescripcionVenta = new javax.swing.JTextField();
        txtCantidadVenta = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        txtStockDisponible = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVenta = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtRucVenta = new javax.swing.JTextField();
        txtNombreClienteVenta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JTextField();
        btnPagar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtDniCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtApellidoPCliente = new javax.swing.JTextField();
        txtApellidoMCliente = new javax.swing.JTextField();
        txtColoniaCliente = new javax.swing.JTextField();
        txtCalleCliente = new javax.swing.JTextField();
        txtCPCliente = new javax.swing.JTextField();
        txtTelefonoCliente = new javax.swing.JTextField();
        txtIdCliente = new javax.swing.JTextField();
        btnGuardarCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        btnNuevoCliente = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCliente = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        cbxEstatus = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtRucProveedor = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        txtColoniaProveedor = new javax.swing.JTextField();
        txtCalleProveedor = new javax.swing.JTextField();
        txtCPProveedor = new javax.swing.JTextField();
        txtTelefonoProveedor = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableProveedor = new javax.swing.JTable();
        btnGuardarProveedor = new javax.swing.JButton();
        btnEditarProveedor = new javax.swing.JButton();
        btnEliminarProveedor = new javax.swing.JButton();
        btnNuevoProveedor = new javax.swing.JButton();
        txtIdProveedor = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtCorreoPr = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        cbxEstatusPro = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        txtDescripcionProducto = new javax.swing.JTextField();
        txtCantidadProducto = new javax.swing.JTextField();
        txtPrecioProducto = new javax.swing.JTextField();
        cbxProveedorPro = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableProducto = new javax.swing.JTable();
        btnGuardarProducto = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        btnNuevoProducto = new javax.swing.JButton();
        txtIdProducto = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableVentas = new javax.swing.JTable();
        txtIdVenta = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jTextField14 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreUsu = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Codigo de Producto:");

        jLabel3.setText("Descripcion:");

        jLabel4.setText("Cantidad:");

        jLabel5.setText("Precio:");

        jLabel6.setText("Stock Disponible:");

        btnEliminarVenta.setText("Eliminar");
        btnEliminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVentaActionPerformed(evt);
            }
        });

        txtCodigoventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoventaActionPerformed(evt);
            }
        });
        txtCodigoventa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoventaKeyPressed(evt);
            }
        });

        txtdescripcionVenta.setEditable(false);

        txtCantidadVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadVentaActionPerformed(evt);
            }
        });
        txtCantidadVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadVentaKeyPressed(evt);
            }
        });

        txtPrecioVenta.setEditable(false);

        txtStockDisponible.setEditable(false);

        tableVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(tableVenta);
        if (tableVenta.getColumnModel().getColumnCount() > 0) {
            tableVenta.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableVenta.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableVenta.getColumnModel().getColumn(2).setPreferredWidth(30);
            tableVenta.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableVenta.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        jLabel7.setText("DNI/RUC:");

        jLabel8.setText("NOMBRE:");

        txtRucVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucVentaKeyPressed(evt);
            }
        });

        txtNombreClienteVenta.setEditable(false);

        jLabel9.setText("TOTAL A PAGAR:");

        labelTotal.setEditable(false);

        btnPagar.setText("PAGAR");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoventa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtdescripcionVenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(189, 189, 189)
                        .addComponent(btnEliminarVenta))
                    .addComponent(txtStockDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtRucVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(txtNombreClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(btnEliminarVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStockDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRucVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nueva Venta", jPanel3);

        jLabel15.setText("DNI:");

        jLabel17.setText("NOMBRE:");

        jLabel18.setText("APELLIDO P:");

        jLabel19.setText("APELLIDO M:");

        jLabel20.setText("TELEFONO:");

        jLabel21.setText("COLONIA:");

        jLabel22.setText("CALLE:");

        jLabel23.setText("C.P:");

        txtCalleCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCalleClienteActionPerformed(evt);
            }
        });

        txtTelefonoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoClienteActionPerformed(evt);
            }
        });

        txtIdCliente.setEditable(false);

        btnGuardarCliente.setText("GUARDAR");
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
            }
        });

        btnEditarCliente.setText("EDITAR");
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setText("ELIMINAR");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        btnNuevoCliente.setText("Nuevo Cliente");
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        tableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "NOMBRE", "APELLIDO P", "APELLIDO M", "COLONIA", "CALLE", "C.P", "TEL", "EST"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableCliente);
        if (tableCliente.getColumnModel().getColumnCount() > 0) {
            tableCliente.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableCliente.getColumnModel().getColumn(1).setPreferredWidth(20);
            tableCliente.getColumnModel().getColumn(2).setPreferredWidth(80);
            tableCliente.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableCliente.getColumnModel().getColumn(4).setPreferredWidth(80);
            tableCliente.getColumnModel().getColumn(5).setPreferredWidth(80);
            tableCliente.getColumnModel().getColumn(6).setPreferredWidth(80);
            tableCliente.getColumnModel().getColumn(7).setPreferredWidth(10);
            tableCliente.getColumnModel().getColumn(8).setPreferredWidth(15);
        }

        jLabel35.setText("ID:");

        jLabel38.setText("ESTATUS:");

        cbxEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(btnGuardarCliente)
                .addGap(45, 45, 45)
                .addComponent(btnEditarCliente)
                .addGap(41, 41, 41)
                .addComponent(btnEliminarCliente)
                .addGap(40, 40, 40)
                .addComponent(btnNuevoCliente)
                .addGap(202, 202, 202))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel21)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(2, 2, 2))))
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtColoniaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCalleCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCPCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoPCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidoMCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35))
                                .addGap(47, 47, 47)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(txtApellidoMCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(txtColoniaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(txtApellidoPCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtCalleCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtCPCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminarCliente)
                        .addComponent(btnNuevoCliente)
                        .addComponent(btnEditarCliente)
                        .addComponent(btnGuardarCliente))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel38)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cliente", jPanel4);

        jLabel24.setText("RUC:");

        jLabel25.setText("NOMBRE:");

        jLabel26.setText("COLONIA:");

        jLabel27.setText("CALLE:");

        jLabel28.setText("C.P:");

        jLabel29.setText("ESTATUS:");

        tableProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "RUC", "NOMBRE", "CORREO", "COLONIA", "CALLE", "C.P", "TELEFONO", "EST"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProveedorMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableProveedor);
        if (tableProveedor.getColumnModel().getColumnCount() > 0) {
            tableProveedor.getColumnModel().getColumn(1).setPreferredWidth(20);
            tableProveedor.getColumnModel().getColumn(2).setPreferredWidth(80);
            tableProveedor.getColumnModel().getColumn(4).setPreferredWidth(80);
            tableProveedor.getColumnModel().getColumn(5).setPreferredWidth(80);
            tableProveedor.getColumnModel().getColumn(6).setPreferredWidth(10);
        }

        btnGuardarProveedor.setText("GUARDAR");
        btnGuardarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProveedorActionPerformed(evt);
            }
        });

        btnEditarProveedor.setText("EDITAR");
        btnEditarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProveedorActionPerformed(evt);
            }
        });

        btnEliminarProveedor.setText("ELIMINAR");
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
            }
        });

        btnNuevoProveedor.setText("NUEVO PROVEEDOR");
        btnNuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProveedorActionPerformed(evt);
            }
        });

        txtIdProveedor.setEditable(false);

        jLabel36.setText("ID:");

        jLabel39.setText("CORREO:");

        jLabel40.setText("TELEFONO:");

        cbxEstatusPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel39))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtColoniaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreoPr)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRucProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCalleProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCPProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarProveedor)
                        .addGap(72, 72, 72)
                        .addComponent(btnEditarProveedor)
                        .addGap(89, 89, 89)
                        .addComponent(btnEliminarProveedor)
                        .addGap(47, 47, 47)
                        .addComponent(btnNuevoProveedor)
                        .addGap(48, 48, 48))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxEstatusPro, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtRucProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(txtCorreoPr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtColoniaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtCalleProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtCPProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarProveedor)
                            .addComponent(btnEditarProveedor)
                            .addComponent(btnEliminarProveedor)
                            .addComponent(btnNuevoProveedor))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(cbxEstatusPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))))
        );

        jTabbedPane1.addTab("Proveedor", jPanel5);

        jLabel30.setText("CODIGO:");

        jLabel31.setText("DESCRIPCION:");

        jLabel32.setText("CANTIDAD:");

        jLabel33.setText("PRECIO:");

        jLabel34.setText("PROVEEDOR:");

        txtCodigoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProductoActionPerformed(evt);
            }
        });

        txtCantidadProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadProductoActionPerformed(evt);
            }
        });

        cbxProveedorPro.setToolTipText("");
        cbxProveedorPro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProveedorProItemStateChanged(evt);
            }
        });
        cbxProveedorPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProveedorProActionPerformed(evt);
            }
        });

        tableProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO", "DESCRIPCION", "PROVEEDOR", "STOCK", "PRECIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableProducto);
        if (tableProducto.getColumnModel().getColumnCount() > 0) {
            tableProducto.getColumnModel().getColumn(1).setPreferredWidth(20);
            tableProducto.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableProducto.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableProducto.getColumnModel().getColumn(4).setPreferredWidth(50);
            tableProducto.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        btnGuardarProducto.setText("GUARDAR");
        btnGuardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProductoActionPerformed(evt);
            }
        });

        btnEditarProducto.setText("EDITAR");
        btnEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setText("ELIMINAR");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        btnNuevoProducto.setText("NUEVO PRODUCTO");
        btnNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProductoActionPerformed(evt);
            }
        });

        txtIdProducto.setEditable(false);

        jLabel37.setText("ID:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigoProducto)
                            .addComponent(txtDescripcionProducto)
                            .addComponent(txtCantidadProducto)
                            .addComponent(txtPrecioProducto)
                            .addComponent(cbxProveedorPro, 0, 100, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5)
                .addGap(35, 35, 35))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(btnGuardarProducto)
                .addGap(40, 40, 40)
                .addComponent(btnEditarProducto)
                .addGap(47, 47, 47)
                .addComponent(btnEliminarProducto)
                .addGap(27, 27, 27)
                .addComponent(btnNuevoProducto)
                .addContainerGap(453, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(cbxProveedorPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))))
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarProducto)
                    .addComponent(btnEditarProducto)
                    .addComponent(btnEliminarProducto)
                    .addComponent(btnNuevoProducto))
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Producto", jPanel6);

        tableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLIENTE", "VENDEDOR", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableVentas);
        if (tableVentas.getColumnModel().getColumnCount() > 0) {
            tableVentas.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableVentas.getColumnModel().getColumn(1).setPreferredWidth(60);
            tableVentas.getColumnModel().getColumn(2).setPreferredWidth(60);
            tableVentas.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(322, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ventas", jPanel7);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setText("RUC");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 21, -1, -1));

        jLabel11.setText("NOMBRE");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 24, -1, -1));

        jLabel12.setText("TELEFONO");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(982, 24, -1, -1));

        jLabel13.setText("COLONIA");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 193, -1, -1));

        jLabel14.setText("CALLE");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 193, -1, -1));
        jPanel8.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 49, 143, -1));
        jPanel8.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 46, 185, -1));
        jPanel8.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(982, 46, 157, -1));
        jPanel8.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 227, 208, -1));
        jPanel8.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 227, 208, -1));

        jButton8.setText("ACTUALIZAR");
        jPanel8.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(878, 303, -1, -1));
        jPanel8.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1041, 227, 98, -1));

        jLabel16.setText("C.P");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 193, -1, -1));

        jTabbedPane1.addTab("tab6", jPanel8);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 1170, 430));

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Nueva Venta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 136, -1, -1));

        jButton2.setText("Cliente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 186, 101, -1));

        jButton3.setText("Proveedor");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 236, 101, -1));

        jButton4.setText("Producto");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 286, 101, -1));

        jButton5.setText("Ventas");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 330, 101, -1));

        jButton6.setText("Confi");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 380, 101, -1));

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 453, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 520));

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("PUNTO DE VENTA");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 20, 574, 47));

        txtNombreUsu.setEditable(false);
        txtNombreUsu.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreUsu.setText("Josue Michel");
        txtNombreUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuActionPerformed(evt);
            }
        });
        jPanel2.add(txtNombreUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 19, 129, 48));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 1170, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
      System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

jTabbedPane1.setSelectedIndex(1);
cargarTabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbxProveedorProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProveedorProActionPerformed
       
    }//GEN-LAST:event_cbxProveedorProActionPerformed

    private void txtCantidadProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadProductoActionPerformed

    private void tableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClienteMouseClicked
        int fila = tableCliente.rowAtPoint(evt.getPoint());
        txtIdCliente.setText(tableCliente.getValueAt(fila, 0).toString());
        txtDniCliente.setText(tableCliente.getValueAt(fila, 1).toString());
        txtNombreCliente.setText(tableCliente.getValueAt(fila, 2).toString());
        txtApellidoPCliente.setText(tableCliente.getValueAt(fila, 3).toString());
        txtApellidoMCliente.setText(tableCliente.getValueAt(fila, 4).toString());
        txtColoniaCliente.setText(tableCliente.getValueAt(fila, 5).toString());
        txtCalleCliente.setText(tableCliente.getValueAt(fila, 6).toString());
        txtCPCliente.setText(tableCliente.getValueAt(fila, 7).toString());
        txtTelefonoCliente.setText(tableCliente.getValueAt(fila, 8).toString());
        cbxEstatus.setSelectedItem(tableCliente.getValueAt(fila, 9).toString());
    }//GEN-LAST:event_tableClienteMouseClicked

       private void tableProveedorMouseClicked(java.awt.event.MouseEvent evt){
        int fila = tableProveedor.rowAtPoint(evt.getPoint());
          txtIdProveedor.setText(tableProveedor.getValueAt(fila, 0).toString());
        txtRucProveedor.setText(tableProveedor.getValueAt(fila, 1).toString());
        txtNombreProveedor.setText(tableProveedor.getValueAt(fila, 2).toString());
        txtCorreoPr.setText(tableProveedor.getValueAt(fila, 3).toString());
        txtColoniaProveedor.setText(tableProveedor.getValueAt(fila, 4).toString());
        txtCalleProveedor.setText(tableProveedor.getValueAt(fila, 5).toString());
        txtCPProveedor.setText(tableProveedor.getValueAt(fila, 6).toString());
        txtTelefonoProveedor.setText(tableProveedor.getValueAt(fila, 7).toString());
        cbxEstatusPro.setSelectedItem(tableProveedor.getValueAt(fila, 8).toString());

        }



    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed
    if(!"".equals(txtDniCliente.getText()) && !"".equals(txtNombreCliente.getText()) && !"".equals(txtApellidoPCliente.getText())
&& !"".equals(txtApellidoMCliente.getText()) && !"".equals(txtColoniaCliente.getText()) && !"".equals(txtCalleCliente.getText())  
&& !"".equals(txtCPCliente.getText())  && !"".equals(txtTelefonoCliente.getText())   && !"".equals(cbxEstatus.getSelectedItem())){

cl.setDni(Integer.parseInt(txtDniCliente.getText()));
cl.setNombre(txtNombreCliente.getText());
cl.setApellido_p(txtApellidoPCliente.getText());
cl.setApellido_m(txtApellidoMCliente.getText());
cl.setColonia(txtColoniaCliente.getText());
cl.setCalle(txtCalleCliente.getText());
cl.setCP(txtCPCliente.getText());
cl.setTelefono(txtTelefonoCliente.getText());
cl.setEstatus(cbxEstatus.getSelectedItem().toString());
client.Registrarclientes(cl);
JOptionPane.showMessageDialog(null, "CLIENTE REGISTRADO CORRECTAMENTE");
cargarTabla();
Limpiar();
}else{
JOptionPane.showMessageDialog(null, "TODOS LOS CAMPOS TIENEN QUE ESTAR LLENOS");
}     
      
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void txtCantidadVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadVentaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//tableProveedorMouseClicked();        
jTabbedPane1.setSelectedIndex(2);
        cargarTablaPro();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTabbedPane1.setSelectedIndex(0);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    Limpiarprodu();
 jTabbedPane1.setSelectedIndex(3);
cargarTablaProduc();





    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTabbedPane1.setSelectedIndex(4);
        cargarTablaVenta();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed

        int id=  Integer.parseInt (txtIdProducto.getText());
        String codigo=txtCodigoProducto.getText();
        String nombreprod=txtDescripcionProducto.getText();
     
        String proveedorProd=cbxProveedorPro.getSelectedItem().toString();
       

         int stock=Integer.parseInt(txtCantidadProducto.getText());
         float precio=Float.parseFloat(txtPrecioProducto.getText());


       if(codigo.isEmpty() ||nombreprod.isEmpty() || proveedorProd.isEmpty()){
            JOptionPane.showMessageDialog(null, "ES OBLIGATORIO EL CAMPO");
        }else{
            try{
               Connection cn =con.conector();
                PreparedStatement ps = cn.prepareStatement("UPDATE productos SET codigo=?,nombre=?,proveedor=?,stock=?,precio=? WHERE id=? ");
                ps.setString(1,codigo);
                ps.setString(2,nombreprod);
                ps.setString(3,proveedorProd);
                ps.setInt(4,stock);
                ps.setFloat(5,precio);
               
                ps.setInt(6,id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO");
                 Limpiarprodu();
            cargarTablaProduc();

            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR PRODUCTO"+e);
            }

        }
    }//GEN-LAST:event_btnEditarProductoActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        int id=  Integer.parseInt (txtIdCliente.getText());

        try{
            Connection cn =con.conector();
            PreparedStatement ps = cn.prepareStatement("DELETE FROM clientes  WHERE id=? ");

            ps.setInt(1,id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO");
            Limpiar();
            cargarTabla();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR EL USUARIO"+e);
        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed

        int id=  Integer.parseInt (txtIdCliente.getText());
        String dni=txtDniCliente.getText();
        String nombre=txtNombreCliente.getText();
        String apellidoP=txtApellidoPCliente.getText();
        String apellidoM=txtApellidoMCliente.getText();
        String colonia=txtColoniaCliente.getText();
        String calle=txtCalleCliente.getText();
        String CP=txtCPCliente.getText();
        String telefono=txtTelefonoCliente.getText();
        String estatus=cbxEstatus.getSelectedItem().toString();
        if(dni.isEmpty() ||nombre.isEmpty()|| apellidoP.isEmpty() || apellidoM.isEmpty() || colonia.isEmpty() || calle.isEmpty() || CP.isEmpty() || telefono.isEmpty() || estatus.isEmpty()){
            JOptionPane.showMessageDialog(null, "ES OBLIGATORIO EL CAMPO");
        }else{
            try{
                Connection cn =con.conector();
                PreparedStatement ps = cn.prepareStatement("UPDATE clientes SET dni=?,nombre=?,apellido_p=?,apellido_m=?,colonia=?,calle=?,CP=?,telefono=?,estatus=? WHERE id=? ");
                ps.setString(1,dni);
                ps.setString(2,nombre);
                ps.setString(3,apellidoP);
                ps.setString(4,apellidoM);
                ps.setString(5,colonia);
                ps.setString(6,calle);
                ps.setString(7,CP);
                ps.setString(8,telefono);
                ps.setString(9,estatus);
                ps.setInt(10,id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO");
                Limpiar();
                cargarTabla();

            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR EL USUARIO"+e);
            }

        }
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void btnGuardarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProveedorActionPerformed
        String dnipro=txtRucProveedor.getText();
        String nombrepro=txtNombreProveedor.getText();
     String correo=txtCorreoPr.getText();
        String coloniapro=txtColoniaProveedor.getText();
        String callepro=txtCalleProveedor.getText();
        String CPpro=txtCPProveedor.getText();
        String telefonopro=txtTelefonoProveedor.getText();
        String estatus=cbxEstatusPro.getSelectedItem().toString();

        if(dnipro.isEmpty() ||nombrepro.isEmpty() || coloniapro.isEmpty() || correo.isEmpty() || callepro.isEmpty() || CPpro.isEmpty() || telefonopro.isEmpty() || estatus.isEmpty()){
            JOptionPane.showMessageDialog(null, "ES OBLIGATORIO EL CAMPO");
        }else{
            try{
                String consulta="INSERT INTO proveedor (ruc,nombre,correo,colonia,calle,CP,telefono,estatus)VALUES('"+dnipro+"','"+nombrepro+"','"+correo+"','"+coloniapro+"','"+callepro+"','"+CPpro+"','"+telefonopro+"','"+estatus+"') ";
                PreparedStatement ps= cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
                Limpiarpro();
                cargarTablaPro();

            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR PROVEEDOR"+e);
            }}
    }//GEN-LAST:event_btnGuardarProveedorActionPerformed
/*
    private void tableProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProveedorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableProveedorMouseClicked
*/
    private void btnEditarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProveedorActionPerformed
       
        int id=  Integer.parseInt (txtIdProveedor.getText());
        String dni=txtRucProveedor.getText();
        String nombre=txtNombreProveedor.getText();
        String correo=txtCorreoPr.getText();
        String colonia=txtColoniaProveedor.getText();
        String calle=txtCalleProveedor.getText();
        String CP=txtCPProveedor.getText();
        String telefono=txtTelefonoProveedor.getText();
        String estatus=cbxEstatusPro.getSelectedItem().toString();
        if(dni.isEmpty() ||nombre.isEmpty() || correo.isEmpty() || colonia.isEmpty() || calle.isEmpty() || CP.isEmpty() || telefono.isEmpty() ||estatus.isEmpty()){
            JOptionPane.showMessageDialog(null, "ES OBLIGATORIO EL CAMPO");
        }else{
            try{
                Connection cn =con.conector();
                PreparedStatement ps = cn.prepareStatement("UPDATE proveedor SET ruc=?,nombre=?,correo=?,colonia=?,calle=?,CP=?,telefono=?,estatus=? WHERE id=? ");
                ps.setString(1,dni);
                ps.setString(2,nombre);
                ps.setString(3,correo);
                ps.setString(4,colonia);
                ps.setString(5,calle);
                ps.setString(6,CP);
                ps.setString(7,telefono);
                ps.setString(8,estatus);
                ps.setInt(9,id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO");
               Limpiarpro();
                cargarTablaPro();

            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR EL USUARIO"+e);
            }

        }
    }//GEN-LAST:event_btnEditarProveedorActionPerformed

    private void btnNuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProveedorActionPerformed
        Limpiarpro();
    }//GEN-LAST:event_btnNuevoProveedorActionPerformed

    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed
         int id=  Integer.parseInt (txtIdProveedor.getText());

        try{
            Connection cn =con.conector();
            PreparedStatement ps = cn.prepareStatement("DELETE FROM proveedor  WHERE id=? ");

            ps.setInt(1,id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO");
            Limpiarpro();
            cargarTablaPro();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR EL PROVEEDOR"+e);
        }
    }//GEN-LAST:event_btnEliminarProveedorActionPerformed

    private void btnGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProductoActionPerformed
         if(!"".equals(txtCodigoProducto.getText()) && !"".equals(txtDescripcionProducto.getText()) && !"".equals(cbxProveedorPro.getSelectedItem())
 && !"".equals(txtCantidadProducto.getText()) && !"".equals(txtPrecioProducto.getText())){

pro.setCodigo(txtCodigoProducto.getText());
pro.setNombre(txtDescripcionProducto.getText());
pro.setProveedor(cbxProveedorPro.getSelectedItem().toString());
pro.setStock(Integer.parseInt(txtCantidadProducto.getText()));
pro.setPrecio(Double.parseDouble(txtPrecioProducto.getText()));
prodao.Registrarproductos(pro);
JOptionPane.showMessageDialog(null, "PRODUCTO REGISTRADO CORRECTAMENTE");
cargarTablaProduc();
Limpiarprodu();
}else{
JOptionPane.showMessageDialog(null, "TODOS LOS CAMPOS TIENEN QUE ESTAR LLENOS");
}
       

         

           
    }//GEN-LAST:event_btnGuardarProductoActionPerformed

    private void txtCodigoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProductoActionPerformed

    private void cbxProveedorProItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProveedorProItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProveedorProItemStateChanged

    private void tableProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductoMouseClicked
       int fila = tableProducto.rowAtPoint(evt.getPoint());
          txtIdProducto.setText(tableProducto.getValueAt(fila, 0).toString());
        txtCodigoProducto.setText(tableProducto.getValueAt(fila, 1).toString());
         txtDescripcionProducto.setText(tableProducto.getValueAt(fila, 2).toString());
        cbxProveedorPro.setSelectedItem(tableProducto.getValueAt(fila, 3).toString());
     
        txtCantidadProducto.setText(tableProducto.getValueAt(fila, 4).toString());
        txtPrecioProducto.setText(tableProducto.getValueAt(fila, 5).toString());
       
    }//GEN-LAST:event_tableProductoMouseClicked

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        int id=  Integer.parseInt (txtIdProducto.getText());

        try{
            Connection cn =con.conector();
            PreparedStatement ps = cn.prepareStatement("DELETE FROM productos  WHERE id=? ");

            ps.setInt(1,id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO");
            Limpiarprodu();
            cargarTablaProduc();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR EL PROVEEDOR"+e);
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProductoActionPerformed
        Limpiarprodu();
    }//GEN-LAST:event_btnNuevoProductoActionPerformed

    private void txtCodigoventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoventaActionPerformed
        
    }//GEN-LAST:event_txtCodigoventaActionPerformed

    private void txtCodigoventaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoventaKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
       if(!"".equals(txtCodigoventa.getText())){ 
String cod =txtCodigoventa.getText();
          pro=prodao.BuscarPro(cod);
       if(pro.getNombre() != null){
           txtdescripcionVenta.setText(""+pro.getNombre());
           txtPrecioVenta.setText(""+pro.getPrecio());
           txtStockDisponible.setText(""+pro.getStock());
              txtCantidadVenta.requestFocus();
}else{

 txtdescripcionVenta.setText("");
           txtPrecioVenta.setText("");
           txtStockDisponible.setText("");
txtCodigoventa.requestFocus();
}

}else{

JOptionPane.showMessageDialog(null,"INGRESA EL CODIGO DEL PRODUCTO");
txtCodigoventa.requestFocus();
}


}
    }//GEN-LAST:event_txtCodigoventaKeyPressed

    private void txtCantidadVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVentaKeyPressed
      if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        if(!"".equals(txtCantidadVenta.getText())){
           String cod = txtCodigoventa.getText();
           String descripcion = txtdescripcionVenta.getText();
           int cant = Integer.parseInt(txtCantidadVenta.getText());
           double precio = Double.parseDouble(txtPrecioVenta.getText());
           double total = cant * precio;
           int stock = Integer.parseInt(txtStockDisponible.getText());
           if(stock>= cant){
              item=item +1;
              DefaultTableModel modelo = (DefaultTableModel) tableVenta.getModel();
              for(int i=0; i<tableVenta.getRowCount();i++){
                  if(tableVenta.getValueAt(i,1).equals(txtdescripcionVenta.getText())){
                   JOptionPane.showMessageDialog(null,"EL PRODUCTO YA ESTA REGISTRADO");
                   return;

             }

             }
             ArrayList lista = new  ArrayList();
             lista.add(item);
             lista.add(cod);
             lista.add(descripcion);
             lista.add(cant);
             lista.add(precio);
             lista.add(total);
             Object[] o = new Object[5];
             o[0] = lista.get(1);
             o[1] = lista.get(2);
             o[2] = lista.get(3);
             o[3] = lista.get(4);
             o[4] = lista.get(5);
             modelo.addRow(o);
             tableVenta.setModel(modelo);
             TotalPagar();
            txtCodigoventa.setText("");
            txtCantidadVenta.setText("");
            txtdescripcionVenta.setText("");
            txtPrecioVenta.setText("");
            txtStockDisponible.setText("");

              
             
}else{
JOptionPane.showMessageDialog(null,"ESTOCK NO DISPONIBLE");
txtCantidadVenta.setText("");
}

}else{ 
JOptionPane.showMessageDialog(null,"INGRESA CANTIDAD");
}


}
    }//GEN-LAST:event_txtCantidadVentaKeyPressed

    private void btnEliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVentaActionPerformed
       DefaultTableModel modeloTabla = (DefaultTableModel)tableVenta.getModel();
modeloTabla.removeRow(tableVenta.getSelectedRow());
TotalPagar();
txtCodigoventa.requestFocus();
    }//GEN-LAST:event_btnEliminarVentaActionPerformed

    private void txtRucVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucVentaKeyPressed
     if(evt.getKeyCode()== KeyEvent.VK_ENTER){
        if(!"".equals(txtRucVenta.getText())){

        int dni= Integer.parseInt(txtRucVenta.getText());
        cl = client.Buscarcliente(dni);

          if(cl.getNombre() !=null){
txtNombreClienteVenta.setText(""+cl.getNombre());

}else{
txtRucVenta.setText("");
JOptionPane.showMessageDialog(null,"EL CLIENTE NO EXISTE");
}
        }

}
    }//GEN-LAST:event_txtRucVentaKeyPressed



private void RegistrarVenta(){
if(!"".equals(txtRucVenta.getText()) && !"".equals(txtNombreClienteVenta.getText())){
String cliente=txtNombreClienteVenta.getText();
String vendedor=txtNombreUsu.getText();
double monto = Totalpagar;
v.setCliente(cliente);
v.setVendedor(vendedor);
v.setTotal(monto);
vdao.RegistrarVenta(v);
JOptionPane.showMessageDialog(null, "LA TRANSACCION FUE EXITOSA");
RegistrarDetalle();
ActualizarStock();
Limpiarventa();


}else{
JOptionPane.showMessageDialog(null,"TODOS LOS CAMPOS TIENEN QUE ESTAR COMPLETOS");
}
}

private void RegistrarDetalle(){
int id = vdao.IdVenta();
for(int i =0; i< tableVenta.getRowCount();i++){
String cod = tableVenta.getValueAt(i,0).toString();
int cant= Integer.parseInt(tableVenta.getValueAt(i,2).toString());
double precio = Double.parseDouble(tableVenta.getValueAt(i,3).toString());
Dv.setCod_pro(cod);
Dv.setCantidad(cant);
Dv.setPrecio(precio);
Dv.setId(id);
vdao.RegistrarDetalle(Dv);
}
}


private void ActualizarStock(){
    for (int i = 0; i < tableVenta.getRowCount(); i++) {
        String  cod= tableVenta .getValueAt(i,0).toString();
        int cant = Integer.parseInt(tableVenta.getValueAt(i,2).toString());
        pro = prodao.BuscarPro(cod);
        int StockActual= pro.getStock()-cant;
        vdao.ActualizarStock(StockActual, cod);
        
    }
}




    private void txtTelefonoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoClienteActionPerformed

    private void txtCalleClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCalleClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCalleClienteActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
 
RegistrarVenta();



  
    }//GEN-LAST:event_btnPagarActionPerformed

    private void txtNombreUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuActionPerformed

    }//GEN-LAST:event_txtNombreUsuActionPerformed




    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEditarProveedor;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnEliminarVenta;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnGuardarProducto;
    private javax.swing.JButton btnGuardarProveedor;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnNuevoProducto;
    private javax.swing.JButton btnNuevoProveedor;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxEstatus;
    private javax.swing.JComboBox<String> cbxEstatusPro;
    private javax.swing.JComboBox<String> cbxProveedorPro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField labelTotal;
    private javax.swing.JTable tableCliente;
    private javax.swing.JTable tableProducto;
    private javax.swing.JTable tableProveedor;
    private javax.swing.JTable tableVenta;
    private javax.swing.JTable tableVentas;
    private javax.swing.JTextField txtApellidoMCliente;
    private javax.swing.JTextField txtApellidoPCliente;
    private javax.swing.JTextField txtCPCliente;
    private javax.swing.JTextField txtCPProveedor;
    private javax.swing.JTextField txtCalleCliente;
    private javax.swing.JTextField txtCalleProveedor;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtCantidadVenta;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtCodigoventa;
    private javax.swing.JTextField txtColoniaCliente;
    private javax.swing.JTextField txtColoniaProveedor;
    private javax.swing.JTextField txtCorreoPr;
    private javax.swing.JTextField txtDescripcionProducto;
    private javax.swing.JTextField txtDniCliente;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreClienteVenta;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtNombreUsu;
    private javax.swing.JTextField txtPrecioProducto;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtRucProveedor;
    private javax.swing.JTextField txtRucVenta;
    private javax.swing.JTextField txtStockDisponible;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtTelefonoProveedor;
    private javax.swing.JTextField txtdescripcionVenta;
    // End of variables declaration//GEN-END:variables

    private void tableProveedorMouseClicked() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

private void TotalPagar(){
Totalpagar= 0.00;
int numfila=tableVenta.getRowCount();
for(int i=0;i<numfila;i++){
double cal= Double.parseDouble(String.valueOf(tableVenta.getModel().getValueAt(i, 4)));
Totalpagar = Totalpagar+cal;

}
labelTotal.setText(String.format("%.2f",Totalpagar));
}


}
