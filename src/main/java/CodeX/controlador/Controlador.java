package CodeX.controlador;

import CodeX.modelo.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controlador {
    private Datos datos;
    public Controlador() {
        datos = new Datos ();
    }


    @FXML
    private void abrirMenuArticulos(ActionEvent event) throws Exception {
        cambiarVista(event, "/vista/MenuArticulos.fxml");
    }

    @FXML
    private void abrirMenuClientes(ActionEvent event) throws Exception {
        cambiarVista(event, "/vista/MenuClientes.fxml");
    }

    @FXML
    private void abrirMenuPedidos(ActionEvent event) throws Exception {
        cambiarVista(event, "/vista/MenuPedidos.fxml");
    }

    @FXML
    private void salir(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void cambiarVista(ActionEvent event, String fxmlFile) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
