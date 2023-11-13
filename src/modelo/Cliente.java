
package modelo;

public class Cliente {
     private int id;
     private  int dni;
     private String nombre;
     private String apellido_p;
     private String apellido_m;
     private String colonia;
     private String calle;
     private String CP;
     private String telefono;
     private String estatus;

    public Cliente() {
    }

    public Cliente(int id, int dni, String nombre, String apellido_p, String apellido_m, String colonia, String calle, String CP, String telefono, String estatus) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.colonia = colonia;
        this.calle = calle;
        this.CP = CP;
        this.telefono = telefono;
        this.estatus = estatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }




}
