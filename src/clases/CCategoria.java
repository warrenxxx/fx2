/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author WARREN
 */
public class CCategoria extends C_Principal{
   
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty descripcion;
    private final SimpleStringProperty id_proveedor;
    
       
    public CCategoria(String id, String nombre,String descripcion, String id_proveedor) {        
        this.id.setValue(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.id_proveedor = new SimpleStringProperty(id_proveedor);
        c_v=new HashMap<String, String>();
        c_v. put("nombre", nombre);
        c_v. put("descripcion", descripcion);
        c_v. put("id_proveedor", id_proveedor);
        n=c_v.size();        
    }

   public CCategoria(){        
        this.nombre = new SimpleStringProperty("");
        this.descripcion = new SimpleStringProperty("");
        this.id_proveedor = new SimpleStringProperty("");
 
        c_v=new HashMap<String, String>();
        c_v. put("nombre", "NOMBRE");
        c_v. put("descripcion", "DESCRIPCION");
        c_v. put("id_proveedor", "PROVEEDOR");
        n=c_v.size();        
    }
    
    public void toMap(){
        c_v. put("nombre",getNombre());
        c_v. put("descripcion", getDescripcion());
        c_v. put("id_proveedor", getId_proveedor());   
    }
    public void toSimple(){
        Iterator<String>it=this.c_v.keySet().iterator();
        while(it.hasNext()){
            String i=it.next();
            if(i.compareTo("nombre")==0)setNombre(c_v.get(i));
            if(i.compareTo("descripcion")==0)setDescripion(c_v.get(i));     
            if(i.compareTo("id_proveedor")==0)setId_proveedor(c_v.get(i));
        }
    }


   public String getId() {
        return id.get();
    }
    public String getNombre() {
        return nombre.get();
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public String getId_proveedor() {
        return id_proveedor.get();
    }
        
    public void setNombre(String nombre) {
        this.nombre.setValue(nombre);
    }
    public void setDescripion(String descripcion) {
        this.descripcion.setValue(descripcion);
    }
    public void setId_proveedor(String id) {
        this.id_proveedor.setValue(id);
    }
    
    @Override
    public String toString() {
        return c_v.get("tipo_contacto")+" "+c_v.get("numero");
    }
}
