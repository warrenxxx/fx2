/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.CUsuario;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

/**
 *
 * @author WARREN
 */
public class Fx2 extends Application {

    public static   Stage ventana;    
    public static   CUsuario USER;    
    public static final int height_head=30;
    public static final int width_head=700;
    public static final int height_side=560;
    public static final int width_side=140;
    public static final int height_body=560;
    public static final int width_body=550;
    public static final int height_body_all=600;
    public static final int width_body_all=700;
    
    public Parent createContent() throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("/vista/Login.fxml"));
        Parent root2 = FXMLLoader.load(getClass().getResource("/vista/FXMLDocument.fxml"));
        Parent root3 = FXMLLoader.load(getClass().getResource("/vista/Principla.fxml"));
       
        TitledPane t1 = new TitledPane("Node 1", root1);
        TitledPane t2 = new TitledPane("Node 2", root2);
        TitledPane t3 = new TitledPane("Node 3", root3);
        Accordion accordion = new Accordion();
        accordion.getPanes().add(t1);
        accordion.getPanes().add(t2);
        accordion.getPanes().add(t3);
        accordion.setMinSize(100, 100);
        accordion.setPrefSize(200, 400);
        return accordion;
    }    
    public Parent login() throws IOException {
        //Parent root1 = FXMLLoader.load(getClass().getResource("/vista/Login.fxml"));       
        Parent root1 = FXMLLoader.load(getClass().getResource("/vista/Principla.fxml"));       
        TitledPane t1 = new TitledPane("Node 1", root1);        
        return root1;
    }
    @Override
    public void start(Stage stage) throws Exception {
        ventana=stage;
        ventana.setTitle("warrencitopa");
        ventana.setScene(new Scene(login()));
        ventana.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
