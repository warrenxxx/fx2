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
public class CCliente extends C_Principal{
    public CCliente(){        
        c_v=new HashMap<String, String>();
        c_v. put("_id", "");
        c_v. put("estado", "");
        n=c_v.size();        
    }   
   
    @Override
    public String toString() {
        return c_v.get("estado");
    }
}
