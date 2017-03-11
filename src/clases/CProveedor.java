/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 *
 * @author Dennys
 */
public class CProveedor extends C_Principal {
    public String clave[]={
    "_id",
    "ruc",
    "razon_social",
    "descripcion"
            };
    public CProveedor(){        
        c_v=new HashMap<String, String>();
        c_v. put("_id", "");
        c_v. put("ruc", "");
        c_v. put("razon_social", "");
        c_v. put("descripcion", "");
        n=c_v.size();
    }   
   
    @Override
    public String toString() {
        return c_v.get("nombre")+" "+c_v.get("costo");
    }
}
