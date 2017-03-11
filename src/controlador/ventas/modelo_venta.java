package controlador.ventas;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author WARREN
 */

public class modelo_venta {
    private final SimpleStringProperty numero;
    private final SimpleStringProperty cantidad;    
    private final SimpleStringProperty codigo;
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty precio;
    private final SimpleStringProperty total;

    public modelo_venta(String numero, String codigo, String nombre, String precio) {
        this.numero =new SimpleStringProperty( numero);
        this.cantidad =new SimpleStringProperty( "1");
        this.codigo =new SimpleStringProperty( codigo);
        this.nombre =new SimpleStringProperty( nombre);
        this.precio =new SimpleStringProperty( precio);
        this.total = new SimpleStringProperty(precio);
    }

    @Override
    public String toString() {
        return this.numero.get()+" "+this.nombre.get()+" "+this.precio.get()+" "+this.total.get();
    }

    public String getNumero() {
        return numero.get();
    }
    public String getCantidad() {
        return cantidad.get();
    }
    
    public String getCodigo() {
        return codigo.get();
    }

    public String getNombre() {
        return nombre.get();
    }

    public String getPrecio() {
        return precio.get();
    }

    public String getTotal() {
        return total.get();
    }
    
    public void setCantidad(String cantidad){
        this.cantidad.setValue(cantidad);
        double k1=Double.parseDouble(cantidad);
        double k2=Double.parseDouble(precio.get());
        double k3=k1*k2;
        total.setValue(k3+"");
    }
    public void setPrecio(String precio){
        this.precio.setValue(precio);
        double k1=Double.parseDouble(precio);
        double k2=Double.parseDouble(this.cantidad.get());
        double k3=k1*k2;
        total.setValue(k3+"");
    }
    public void setNumero(String numero){
        this.numero.setValue(numero);
    }
    
}
