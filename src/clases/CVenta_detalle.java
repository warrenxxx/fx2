/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author WARREN
 */
public class CVenta_detalle extends C_Principal{
    
    /*
         c_v. put("_id", "");
        c_v. put("cantidad", "");
        c_v. put("id_articulo", "");
        c_v. put("id_ventas", "");
        c_v. put("id_articulos", "");

    */
    private final SimpleStringProperty cantidad;
    private final SimpleStringProperty precio;
    private final SimpleStringProperty id_venta;
    private final SimpleStringProperty id_articulo;

    public CVenta_detalle(String id,String cantidad, String precio, String id_venta, String id_articulo) {
        this.id.setValue(id);
        this.cantidad =new SimpleStringProperty(cantidad) ;
        this.precio =new SimpleStringProperty( precio);
        this.id_venta = new SimpleStringProperty(id_venta);
        this.id_articulo = new SimpleStringProperty(id_articulo);
        c_v=new HashMap<String, String>();
        toMap();
        n=c_v.size();

    }

    public CVenta_detalle(){       
        this.cantidad =new SimpleStringProperty("") ;
        this.precio =new SimpleStringProperty( "");
        this.id_venta = new SimpleStringProperty("");
        this.id_articulo = new SimpleStringProperty("");

        c_v=new HashMap<String, String>();
        c_v.put("cantidad", "Codigo");
        c_v. put("precio", "NOMBRE");
        c_v. put("id_venta", "DESCRIPCION");
        c_v. put("id_articulo", "COSTO");
        n=c_v.size();
    }   

    
    public void toMap(){
        c_v. put("cantidad",getCantidad());
        c_v. put("precio", getPrecio());
        c_v. put("id_venta", getId_venta());   
        c_v. put("id_articulo",getId_articulo());
    }
    public void toSimple(){
        Iterator<String>it=this.c_v.keySet().iterator();
        while(it.hasNext()){
            
            String clave=it.next();
            if(clave.compareTo("_id")==0)continue;
            String valor=c_v.get(clave);
        if(clave.compareTo("cantidad")==0)setCantidad(valor);
        if(clave.compareTo("precio")==0)setPrecio(valor);
        if(clave.compareTo("id_venta")==0)setVenta(valor);
        if(clave.compareTo("id_articulo")==0)setArticulo(valor);
        }
    }
    
    public String getCantidad() {
        return cantidad.get();
    }

    public String getPrecio() {
        return precio.get();
    }

    public String getId_venta() {
        return id_venta.get();
    }

    public String getId_articulo() {
        return id_articulo.get();
    }

    public void setCantidad(String cantidad){
        this.cantidad.setValue(cantidad);
        c_v.put("cantidad", cantidad);
    }
    public void setPrecio(String precio){
        this.precio.setValue(precio);
        c_v.put("precio", precio);
    }
    public void setVenta(String dees){
        this.id_venta.setValue(dees);
        c_v.put("id_venta", dees);
    }
    public void setArticulo(String id_articulo){
        this.id_articulo.setValue(id_articulo);
        c_v.put("id_articulo",id_articulo);
    }
    @Override
    public String toString() {
        return c_v.get("id_venta")+" "+c_v.get("id_articulo");
    }
}
