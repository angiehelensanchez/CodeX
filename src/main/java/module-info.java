module CodeX {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.naming;
    requires jakarta.persistence;



    opens CodeX.vista to javafx.fxml;
    opens CodeX.modelo to org.hibernate.orm.core;
    opens CodeX.controlador to javafx.fxml;
    opens CodeX.DAO to javafx.fxml;

    exports CodeX.controlador;
    exports CodeX.DAO;
    exports CodeX.modelo;
    exports CodeX.vista;
    }