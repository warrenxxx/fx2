/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.articulo;

import bd.DArticulo;
import clases.CArticulo;
import controlador.PrinciplaController;
import static controlador.admi.SideController.borderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import static modelo.Fx2.USER;
import static modelo.Fx2.ventana;

/**
 * FXML Controller class
 *
 * @author WARREN
 */
public class Edit_delete_articuloController implements Initializable {

    /**
     * Initializes the controller class.
     */
    CArticulo x;
    @FXML TextField id;
    @FXML TextField nombre;
    @FXML TextField descripcion;
    @FXML TextField codigo;
    @FXML TextField material;
    @FXML TextField costo;
    @FXML TextField stock   ;
    @FXML TextField categoria;
    @FXML TextField barras;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                costo.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    costo.setText(newValue.replaceAll("^(\\d*\\.)|\\D", "$1"));
                }

            }

        });
        stock.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    stock.setText(newValue.replaceAll("[^\\d]", ""));
                }

            }

        });

    }    
    public void setArticulo(CArticulo x){
        this.x=x;
        id.setText(x.getId());
        nombre.setText(x.getNombre());
        descripcion.setText(x.getDescripcion());
        material.setText(x.getMaterial());
        costo.setText(x.getCosto());
        stock.setText(x.getStock());
        categoria.setText(x.getCategoria());
        barras.setText(x.getBarras());
    }
    public void eliminar(ActionEvent e) throws IOException{
        new DArticulo().eliminar(x);
                regresar();
    }
    public void editar(ActionEvent e) throws IOException{
        
        new DArticulo().modificar(new CArticulo(id.getText(),barras.getText(), nombre.getText(), descripcion.getText(), costo.getText(), stock.getText(), material.getText(), categoria.getText()));
        System.out.println(nombre.getText());
                regresar();
    }
    public void cancelar(ActionEvent e) throws IOException{
        regresar();
    }
    public void regresar() throws IOException{
             FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/articulo/m_articulo_ini.fxml"));
           VBox root =(VBox)loader.load();
           root.autosize();
           borderPane.setCenter(root);
    }
}
