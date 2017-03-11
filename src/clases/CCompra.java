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
public class CCompra extends C_Principal{
    public CCompra(){        
        c_v=new HashMap<String, String>();
        c_v. put("_id", "");
        c_v. put("fecha_compra", "");
        c_v. put("fecha_entrega", "");
        c_v. put("id_proveedor", "");
        c_v. put("id_administrador", "");
        n=c_v.size();
    }   
   
    @Override
    public String toString() {
        return c_v.get("nombre")+" "+c_v.get("costo");
    }
}
