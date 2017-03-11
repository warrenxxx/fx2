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
public class CArticulo extends C_Principal{
    
    private final SimpleStringProperty barras;
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty descripcion;
    private final SimpleStringProperty costo;
    private final SimpleStringProperty stock;
    private final SimpleStringProperty material;
    private final SimpleStringProperty categoria;

    public CArticulo(String id,String barras, String nombre, String descripcion, String costo, String stock, String material, String categoria) {
        this.id.setValue(id);
        this.barras =new SimpleStringProperty(barras) ;
        this.nombre =new SimpleStringProperty( nombre);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.costo = new SimpleStringProperty(costo);
        this.stock = new SimpleStringProperty(stock);
        this.material = new SimpleStringProperty(material);
        this.categoria = new SimpleStringProperty(categoria);
        c_v=new HashMap<String, String>();
        toMap();
        n=c_v.size();

    }

    public CArticulo(){       
        this.barras =new SimpleStringProperty("") ;
        this.nombre =new SimpleStringProperty( "");
        this.descripcion = new SimpleStringProperty("");
        this.costo = new SimpleStringProperty("");
        this.stock = new SimpleStringProperty("");
        this.material = new SimpleStringProperty("");
        this.categoria = new SimpleStringProperty("");

        c_v=new HashMap<String, String>();
        c_v.put("barras", "Codigo");
        c_v. put("nombre", "NOMBRE");
        c_v. put("descripcion", "DESCRIPCION");
        c_v. put("costo", "COSTO");
        c_v. put("stock", "STOCK");
        c_v. put("material", "MATERIAL");
        c_v. put("categoria", "CATEGORIA");
        n=c_v.size();
    }   

    
    public void toMap(){
        c_v. put("barras",getBarras());
        c_v. put("nombre", getNombre());
        c_v. put("descripcion", getDescripcion());   
        c_v. put("costo",getCosto());
        c_v. put("stock", getStock());
        c_v. put("material", getMaterial());   
        c_v. put("categoria",getCategoria());
    }
    public void toSimple(){
        Iterator<String>it=this.c_v.keySet().iterator();
        while(it.hasNext()){
            
            String clave=it.next();
            if(clave.compareTo("_id")==0)continue;
            String valor=c_v.get(clave);
        if(clave.compareTo("barras")==0)setBarras(valor);
        if(clave.compareTo("nombre")==0)setNombre(valor);
        if(clave.compareTo("descripcion")==0)setDesripcion(valor);
        if(clave.compareTo("costo")==0)setCosto(valor);
        if(clave.compareTo("stock")==0)setStock(valor);
        if(clave.compareTo("material")==0)setMaterial(valor);
        if(clave.compareTo("categoria")==0)setCategoria(valor);
        }
    }
    
    public String getBarras() {
        return barras.get();
    }

    public String getNombre() {
        return nombre.get();
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public String getCosto() {
        System.out.println(costo.get()+"warren");
        double k=Double.parseDouble(costo.get());
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00",simbolos);//creo objeto df
        return df.format(k);
    }

    public String getStock() {
        return stock.get();
    }

    public String getMaterial() {
        return material.get();
    }

    public String getCategoria() {
        return categoria.get();
    }
    public void setBarras(String barras){
        this.barras.setValue(barras);
        c_v.put("barras", barras);
    }
    public void setNombre(String nombre){
        this.nombre.setValue(nombre);
        c_v.put("nombre", nombre);
    }
    public void setDesripcion(String dees){
        this.descripcion.setValue(dees);
        c_v.put("descripcion", dees);
    }
    public void setCosto(String costo){
        this.costo.setValue(costo);
        c_v.put("costo",costo);
    }
    public void setMaterial(String costo){
        this.material.setValue(costo);
        c_v.put("material",costo);
    }
    public void setStock(String costo){
        this.stock.setValue(costo);
        c_v.put("stock",costo);
    }
    public void setCategoria(String costo){
        this.categoria.setValue(costo);
        c_v.put("categoria",costo);
    }

    @Override
    public String toString() {
        return c_v.get("nombre")+" "+c_v.get("costo");
    }
}
