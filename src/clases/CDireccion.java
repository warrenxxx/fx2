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
public class CDireccion extends C_Principal{
    public CDireccion(){        
        c_v=new HashMap<String, String>();
        c_v. put("_id", "");
        c_v. put("ubigeo", "");
        c_v. put("direccion", "");
        c_v. put("referencia", "");
        c_v. put("codigo_postal", "");
        c_v. put("id_persona", "");
        n=c_v.size();
    }   
   
    @Override
    public String toString() {
        return c_v.get("nombre")+" "+c_v.get("costo");
    }
}
