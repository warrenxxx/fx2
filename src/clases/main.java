/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import bd.DContacto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author WARREN
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String h="";
        while(true){
            h=sc.nextLine();
            if(h.compareTo("fin")==0)break;
            String k[]=h.split(" ");
            int n=k.length;
            System.out.println(k[n-2]);
        }
    }
    
}
