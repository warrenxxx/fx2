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
 * @author Dennys
 */
public class CUsuario extends C_Principal{
    private final SimpleStringProperty usuario;
    private final SimpleStringProperty contraseña;
    private final SimpleStringProperty permisos;
    
    public CUsuario(){        
         this.usuario=new SimpleStringProperty("") ;
        this.contraseña=new SimpleStringProperty("") ;
        this.permisos=new SimpleStringProperty("") ;
        c_v=new HashMap<String, String>();
        c_v. put("_id", "");
        c_v. put("usuario", "");
        c_v. put("contraseña", "");
        c_v. put("permisos", "");
        n=c_v.size();
    }   

    public CUsuario(String usuario, String contraseña, String permisos) {
        this.usuario=new SimpleStringProperty(usuario) ;
        this.contraseña=new SimpleStringProperty(contraseña) ;
        this.permisos=new SimpleStringProperty(permisos) ;
    }

    public String getUsuario() {
        return usuario.get();
    }

    public String getContraseña() {
        return contraseña.get();
    }

    public String getPermisos() {
        return permisos.get();
    }
    
    public void setUsuario(String usuario){
        this.usuario.setValue(usuario);
        this.c_v.put("usuario", usuario);
    }
    public void setContraseña(String contra){
        this.contraseña.setValue(contra);
        this.c_v.put("contraseña",contra);
    }
    public void setPermisos(String permisos){
        this.permisos.setValue(permisos);
        this.c_v.put("permisos", permisos);
    }
    @Override
    public String toString() {
        return c_v.get("usuario")+" "+c_v.get("permisos");
    }
    
}
