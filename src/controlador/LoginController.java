/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bd.DUsuario;
import clases.CUsuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import static modelo.Fx2.USER;
import static modelo.Fx2.height_body_all;
import static modelo.Fx2.ventana;
import static modelo.Fx2.width_body_all;

/**
 * FXML Controller class
 *
 * @author WARREN
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML TextField usuario;
    @FXML TextField password;
    @FXML
    private void entrar(ActionEvent ev) throws IOException{
       
       FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/Principla.fxml"));
       BorderPane root =(BorderPane)loader.load();       
       PrinciplaController pc=(PrinciplaController)loader.getController();        
       pc.init(usuario.getText());
       //IF ES SIERTO ENTRA Y MODIFOCCA
       USER=(CUsuario) new DUsuario().listar("usuario",usuario.getText()).get(0);
       Scene sc=new Scene(root);       
       ventana.setScene(sc);
        ventana.setX(250);
        ventana.setY(100);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(usuario.getText());
    }    
    
}
