/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.HashMap;

/**
 *
 * @author WARREN
 */
public class CContacto extends C_Principal{
    public CContacto(){        
        c_v=new HashMap<String, String>();
        c_v. put("tipo_contacto", "TIPO DE CONTACTO");
        c_v. put("numero", "NU");
        c_v. put("id_persona", "");
        n=c_v.size();        
    }       
    @Override
    public String toString() {
        return c_v.get("tipo_contacto")+" "+c_v.get("numero")+" "+c_v.get("id_persona");
    }
}
