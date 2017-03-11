/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.articulo;

import bd.DArticulo;
import clases.CArticulo;
import static controlador.admi.SideController.borderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author WARREN
 */
public class Insert_articuloController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField nombre;
    @FXML
    TextField descripcion;
    @FXML
    TextField codigo;
    @FXML
    TextField material;
    @FXML
    TextField costo;
    @FXML
    TextField stock;
    @FXML
    TextField categoria;
    @FXML
    TextField barras;

    public void insertar(ActionEvent e) throws IOException {

        new DArticulo().insertar(new CArticulo("", barras.getText(), nombre.getText(), descripcion.getText(), costo.getText(), stock.getText(), material.getText(), categoria.getText()));
        regresar();
    }

    public void cancelar(ActionEvent e) throws IOException {
        regresar();
    }

    public void regresar() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/articulo/m_articulo_ini.fxml"));
        VBox root = (VBox) loader.load();
        root.autosize();
        borderPane.setCenter(root);
    }

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

}
