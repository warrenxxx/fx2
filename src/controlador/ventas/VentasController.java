/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ventas;

import bd.DArticulo;
import bd.DVenta;
import bd.DVenta_detalle;
import clases.CArticulo;
import clases.CCategoria;
import clases.CVenta;
import clases.CVenta_detalle;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.function.Function;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static modelo.Fx2.USER;

/**
 * FXML Controller class
 *
 * @author WARREN
 */
public class VentasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TableColumn tpocicion;
    @FXML
    TableColumn tcantidad;
    @FXML
    TableColumn tcodigo;
    @FXML
    TableColumn tnombre;
    @FXML
    TableColumn tprecio;
    @FXML
    TableColumn ttotal;

    @FXML
    TextField barras;
    @FXML
    TextField nombre;
    @FXML
    TextField costo;
    @FXML
    TextField stock;
    @FXML
    Label total1;
    @FXML
    Label total2;

    @FXML
    TextField filterField;
    ObservableList<CArticulo> data;
    ObservableList<CArticulo> filter;
    @FXML
    TableView tablee;

    @FXML
    TableView venta_detalle;
    ObservableList<modelo_venta> data_venta;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ini();
        ini2();
    }

    public void registrar(ActionEvent ev) {
        CVenta v=new CVenta();
        v.setCliente("xxxxxxxx");
        v.setFecha_hora(new Date().toGMTString());
        v.setVendedor(USER.getId());
        v.toMap();
        String id=new DVenta().insertar(v);
        for(modelo_venta m:data_venta){
              CVenta_detalle m1=new CVenta_detalle();
              m1.setArticulo(m.getCodigo());
              m1.setCantidad(m.getCantidad());
              m1.setPrecio(m.getPrecio());
              m1.setVenta(id);
              new DVenta_detalle().insertar(m1);
        }
        data_venta.clear();
        venta_detalle.refresh();
        limpiar();
    }
    public void limpiar(){
        barras.setText("");
        costo.setText("");
        nombre.setText("");
        stock.setText("");
        total1.setText("");
        total2.setText("");
    }
    public void gg(ActionEvent ev) {
    }
    int hhh=0;
    public void ini2() {
        TableView<modelo_venta> table = venta_detalle;
        data_venta = FXCollections.observableArrayList();
        
        tpocicion.setCellValueFactory(new PropertyValueFactory<>("numero"));
        
        TableColumn<modelo_venta, String> tc_can = tcantidad;
        tc_can.setCellValueFactory(new PropertyValueFactory<modelo_venta, String>("cantidad"));
        tc_can.setCellFactory(TextFieldTableCell.forTableColumn());
        tc_can.setOnEditCommit(data -> {
                        modelo_venta p = data.getRowValue();
            if (!data.getNewValue().matches("[0-9]+(\\.[0-9][0-9])?")) 
                    p.setCantidad(data.getOldValue());             
            else    p.setCantidad(data.getNewValue());
            sumar();
            venta_detalle.refresh();
        });

        tcodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tnombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<modelo_venta, String> tc_pre = tprecio;
        tc_pre.setCellValueFactory(new PropertyValueFactory<modelo_venta, String>("precio"));
        tc_pre.setCellFactory(TextFieldTableCell.forTableColumn());
        
        tc_pre.setOnEditCommit(data -> {
            modelo_venta p = data.getRowValue();
            if (!data.getNewValue().matches("[0-9]+(\\.[0-9][0-9])?")) 
                            p.setPrecio(data.getOldValue());             
            else            p.setPrecio(data.getNewValue());
            sumar();
            venta_detalle.refresh();
        });
        
        ttotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        
        TableColumn<modelo_venta, modelo_venta> editColumn = column("Eliminar", ReadOnlyObjectWrapper<modelo_venta>::new, 60);
        table.getColumns().add(editColumn);
        editColumn.setCellFactory(col -> {
            final Label response = new Label();
            final ImageView imageView = new ImageView(
                    new Image("/recursos/basurero2.png")
            );
            Button editButton = new Button("", imageView);
            editButton.setStyle("-fx-base: coral;");
            editButton.setContentDisplay(ContentDisplay.LEFT);

            TableCell<modelo_venta, modelo_venta> cell = new TableCell<modelo_venta, modelo_venta>() {
                @Override
                public void updateItem(modelo_venta person, boolean empty) {
                    super.updateItem(person, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(editButton);
                    }
                }
            };

            editButton.setOnAction(e -> {
                data_venta.remove(cell.getItem());
                sumar();
            });

            return cell;
        });

        venta_detalle.setItems(data_venta);
        table.setEditable(true);
    }

    private <S, T> TableColumn<S, T> column(String title, Function<S, ObservableValue<T>> property, double width) {
        TableColumn<S, T> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
        col.setPrefWidth(width);
        return col;
    }

    public void ini() {
        TableView<CArticulo> table = tablee;
        data = FXCollections.observableArrayList();
        filter = FXCollections.observableArrayList();

        CArticulo x = new CArticulo();
        HashMap<String, String> y = x.get_datos();
        Iterator<String> it = y.keySet().iterator();

        TableColumn firstNameCol = new TableColumn("wsid");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.getColumns().add(firstNameCol);
        
        TableColumn firstNameCol1 = new TableColumn("Codigo");
        firstNameCol1.setCellValueFactory(new PropertyValueFactory<>("barras"));
        table.getColumns().add(firstNameCol1);

        TableColumn firstNameCol2 = new TableColumn("Nombre");
        firstNameCol2.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        table.getColumns().add(firstNameCol2);

        TableColumn firstNameCol3 = new TableColumn("Costo");
        firstNameCol3.setCellValueFactory(new PropertyValueFactory<>("costo"));
        table.getColumns().add(firstNameCol3);

        TableColumn firstNameCol4 = new TableColumn("Stock");
        firstNameCol4.setCellValueFactory(new PropertyValueFactory<>("stock"));
        table.getColumns().add(firstNameCol4);

        (table.getColumns().get(0)).setVisible(false);
        table.setRowFactory(tv -> {
            TableRow<CArticulo> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if ((!row.isEmpty())) {
                    CArticulo art = row.getItem();
                    barras.setText(art.getBarras());
                    nombre.setText(art.getNombre());
                    costo.setText(art.getCosto());
                    stock.setText(art.getStock());
                }
            });
            return row;
        });
        ArrayList<CArticulo> lista = new DArticulo().listar();
        for (CArticulo cat : lista) {
            cat.toSimple();
            data.add(cat);
        }
        table.setItems(filter);
        filter.addAll(data);
        filterField.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                filter.clear();

                for (CArticulo p : data) {
                    if (buscar(p)) {
                        filter.add(p);
                    }
                }
                reapplyTableSortOrder();
            }

        });
        barras.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                ArrayList d = new DArticulo().listar("barras", newValue);
                if (d.size() > 0) {
                    CArticulo f = (CArticulo) d.get(0);
                    f.toSimple();
                    modelo_venta e = buscar_venta(f.getBarras());
                    if (e != null) {
                        int k = Integer.parseInt(e.getCantidad()) + 1;
                        e.setCantidad(k + "");
                    } else {
                        int k = data_venta.size() + 1;
                        e = new modelo_venta(k + "", f.getBarras(), f.getNombre(), f.getCosto());
                        data_venta.add(e);
                    }
                    venta_detalle.refresh();
                    sumar();
                    barras.setText(oldValue);
                }
            }
        });
    }

    public void sumar() {
        double cont = 0;
        int num = 0;
        for (modelo_venta m : data_venta) {
            num++;
            double k = Double.parseDouble(m.getTotal());
            cont += k;
            m.setNumero(num + "");
        }
        total2.setText("Total es : " + cont + " soles");
        total1.setText("S/." + cont + "");
    }

    private modelo_venta buscar_venta(String barras) {
        for (modelo_venta p : data_venta) {
            if (p.getCodigo().compareTo(barras) == 0) {
                return p;
            }
        }
        return null;
    }

    private boolean buscar(CArticulo person) {
        String filterString = filterField.getText();
        if (filterString == null || filterString.isEmpty()) {
            // No filter --> Add all.
            return true;
        }

        String lowerCaseFilterString = filterString.toLowerCase();

        if (person.getNombre().toLowerCase().indexOf(lowerCaseFilterString) != -1) return true; else 
        if (person.getCategoria().toLowerCase().indexOf(lowerCaseFilterString) != -1) return true; else 
        if (person.getBarras().toLowerCase().indexOf(lowerCaseFilterString) != -1) return true;
        

        return false; // Does not match
    }

    private void reapplyTableSortOrder() {
        ArrayList<TableColumn<CCategoria, ?>> sortOrder = new ArrayList<>(tablee.getSortOrder());
        tablee.getSortOrder().clear();
        tablee.getSortOrder().addAll(sortOrder);
    }

}
