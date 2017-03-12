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
public class CVenta extends C_Principal{
    
    /*
            c_v. put("_id", "");
        c_v. put("fecha_hora", "");
        c_v. put("tipo", "");
        c_v. put("id_vendedor", "");
        c_v. put("id_cliente", "");

    */
    private final SimpleStringProperty fecha_hora;
    private final SimpleStringProperty id_vendedor;
    private final SimpleStringProperty id_cliente;

    public CVenta(String id,String fecha_hora, String id_vendedor, String id_cliente) {
        this.id.setValue(id);
        this.fecha_hora =new SimpleStringProperty(fecha_hora) ;
        this.id_vendedor =new SimpleStringProperty( id_vendedor);
        this.id_cliente = new SimpleStringProperty(id_cliente);
        c_v=new HashMap<String, String>();
        toMap();
        n=c_v.size();

    }

    public CVenta(){       
        this.fecha_hora =new SimpleStringProperty("") ;
        this.id_vendedor =new SimpleStringProperty( "");
        this.id_cliente = new SimpleStringProperty("");

        c_v=new HashMap<String, String>();
        c_v.put("fecha_hora", "Codigo");
        c_v. put("id_vendedor", "NOMBRE");
        c_v. put("id_cliente", "DESCRIPCION");
        n=c_v.size();
    }   

    
    public void toMap(){
        c_v. put("fecha_hora",getFecha_hora());
        c_v. put("id_vendedor", getVendedor());
        c_v. put("id_cliente", getCliente());   
    }
    public void toSimple(){
        Iterator<String>it=this.c_v.keySet().iterator();
        while(it.hasNext()){
            
            String clave=it.next();
            if(clave.compareTo("_id")==0)continue;
            String valor=c_v.get(clave);
        if(clave.compareTo("fecha_hora")==0)setFecha_hora(valor);
        if(clave.compareTo("id_vendedor")==0)setVendedor(valor);
        if(clave.compareTo("id_cliente")==0)setCliente(valor);
        }
    }
    
    public String getFecha_hora() {
        return fecha_hora.get();
    }

    public String getVendedor() {
        return id_vendedor.get();
    }

    public String getCliente() {
        return id_cliente.get();
    }
    public void setFecha_hora(String fecha_hora){
        this.fecha_hora.setValue(fecha_hora);
        c_v.put("fecha_hora", fecha_hora);
    }
    public void setVendedor(String id_vendedor){
        this.id_vendedor.setValue(id_vendedor);
        c_v.put("id_vendedor", id_vendedor);
    }
    public void setCliente(String dees){
        this.id_cliente.setValue(dees);
        c_v.put("id_cliente", dees);
    }
    @Override
    public String toString() {
        return c_v.get("id_vendedor")+" "+c_v.get("fecha_hora");
    }
}
