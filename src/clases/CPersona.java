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
public class CPersona extends C_Principal{
    public CPersona(){        
        c_v=new HashMap<String, String>();
        c_v. put("_id", "");
        c_v. put("tipo_documento", "");
        c_v. put("nro_documento", "");
        c_v. put("nombres", "");
        c_v. put("apellidos", "");
        c_v. put("fecha_nacimiento", "");
        c_v. put("sexo", "");
        c_v. put("email", "");
        c_v. put("id_usuario", "");
        c_v. put("id_entidad", "");
        n=c_v.size();
    }   
    @Override
    public String toString() {
        return c_v.get("nombre")+" "+c_v.get("costo");
    }
}
