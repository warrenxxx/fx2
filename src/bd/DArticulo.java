/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import clases.CArticulo;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import java.util.ArrayList;
import java.util.HashMap;
import org.bson.types.ObjectId;

/**
 *
 * @author WARREN
 */
public class DArticulo implements Operaciones{
    private String table="articulo";
    @Override
    public String insertar(Object o) {
        CArticulo x=(CArticulo) o;        
        conecion con=new conecion(table);
        BasicDBObject datos = new BasicDBObject(x.get_datos());        
        con.get_colletion().insert(datos);
        con.end();
        return datos.getString("_id");
    }

    @Override
    public String eliminar(Object o) {
        CArticulo x=(CArticulo) o;
        conecion con=new conecion(table);
        BasicDBObject datos = new BasicDBObject("_id",new ObjectId( x.getId()));        
        con.get_colletion().remove(datos);
                con.end();

        return datos.getString("_id");        
    }

    @Override
    public String modificar(Object o) {
        CArticulo x=(CArticulo) o;
        conecion con=new conecion(table);
        BasicDBObject datos = new BasicDBObject(x.get_datos());        
        System.out.println("warren"+x.getId());
        con.get_colletion().update(new BasicDBObject("_id",new ObjectId(x.getId())),datos);
                con.end();

        return datos.getString("_id");    
    }

    @Override
    public ArrayList listar() {
       ArrayList datos=new ArrayList();
       CArticulo x=new CArticulo();
       conecion con=new conecion(table);        
       DBCursor cursor=con.get_colletion().find();
        try{
            while(cursor.hasNext()){      
                x=new CArticulo();
                BasicDBObject agg=(BasicDBObject)cursor.next();  
                x.set_datos((HashMap) agg.toMap());
                x.setId((String) agg.getString("_id"));
                System.out.println(x.getId());
                datos.add(x);      
                   }
        } finally{
            cursor.close();
        }                          con.end();

        return datos;
    }

    @Override
    public Object buscar_id(String id_find) {
       ArrayList datos=new ArrayList();
       CArticulo x=new CArticulo();
       conecion con=new conecion(table);        
       BasicDBObject id= new BasicDBObject("_id",new ObjectId(id_find));       
       DBCursor cursor=con.get_colletion().find(id);
       
        try{
            while(cursor.hasNext()){      
                x=new CArticulo();
                x.set_datos((HashMap) cursor.next().toMap());
                datos.add(x);                                           
            }
        } finally{
            cursor.close();
        }           
                con.end();

        if(datos.size()==0)return null;
        return datos.get(0);
    }

    @Override
    public ArrayList listar(String clave, String valor) {
       ArrayList datos=new ArrayList();
       CArticulo x=new CArticulo();
       conecion con=new conecion(table);        
       BasicDBObject id= new BasicDBObject(clave,valor);       
       DBCursor cursor=con.get_colletion().find(id);
       
        try{
            while(cursor.hasNext()){      
                x=new CArticulo();
                x.set_datos((HashMap) cursor.next().toMap());
                datos.add(x);                                           
            }
        } finally{
            cursor.close();
        }           
                con.end();

        return datos;
    }

    @Override
    public ArrayList listar(HashMap map) {
       ArrayList datos=new ArrayList();
       CArticulo x=new CArticulo();
       conecion con=new conecion(table);        
       BasicDBObject id= new BasicDBObject(map);       
       DBCursor cursor=con.get_colletion().find(id);
       
        try{
            while(cursor.hasNext()){      
                x=new CArticulo();
                x.set_datos((HashMap) cursor.next().toMap());
                datos.add(x);                                           
            }
        } finally{
            cursor.close();
        }           
                con.end();

        return datos;
    }
    
}
