/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.HashMap;
import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author WARREN
 */
public class C_Principal {
    protected HashMap<String,String> c_v;
    protected int n;
    protected final SimpleStringProperty id;
    
    public C_Principal(){        
        id=new SimpleStringProperty("");
        c_v=new HashMap<String, String>();
    }   
    public HashMap get_datos(){
        return (HashMap) c_v.clone();
    }
    public void set_datos(HashMap set){
        this.c_v=set;
    }
    public void set(String clave,String valor){
        if(c_v.containsKey(clave))
            this.c_v.put(clave, valor);
    }
    public void setId(String valor){
        this.id.setValue(valor);
    }
    public String getId(){
        return id.getValue();
    }
    public String get(String get){
        return c_v.get(get);
    }
    @Override
    public String toString() {
        return c_v.get("estado");
    }
}
