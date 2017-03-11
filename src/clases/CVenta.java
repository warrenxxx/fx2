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
public class CVenta extends C_Principal{
    public CVenta(){        
        c_v=new HashMap<String, String>();
        c_v. put("_id", "");
        c_v. put("fecha_hora", "");
        c_v. put("tipo", "");
        c_v. put("id_vendedor", "");
        c_v. put("id_personal_reparto", "");
        c_v. put("id_cliente", "");
        n=c_v.size();
    }   
   
    @Override
    public String toString() {
        return c_v.get("nombre")+" "+c_v.get("costo");
    }

}
