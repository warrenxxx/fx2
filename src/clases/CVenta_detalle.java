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
 * @author WARREN
 */
public class CVenta_detalle extends C_Principal{
    public CVenta_detalle(){        
        c_v=new HashMap<String, String>();
        c_v. put("_id", "");
        c_v. put("cantidad", "");
        c_v. put("costo", "");
        c_v. put("id_ventas", "");
        c_v. put("id_articulos", "");
        n=c_v.size();
    }   
   
    @Override
    public String toString() {
        return c_v.get("nombre")+" "+c_v.get("costo");
    }
}
