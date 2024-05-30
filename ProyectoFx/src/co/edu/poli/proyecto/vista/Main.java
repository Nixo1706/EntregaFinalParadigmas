package co.edu.poli.proyecto.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Clase principal que inicia la aplicación y carga la interfaz de inicio de sesión.
 */
public class Main extends Application {
    
    private double xOffset = 0;
    private double yOffset = 0;

    /**
     * Método principal que inicia la aplicación.
     *
     * @param primaryStage el escenario principal de la aplicación.
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargar la interfaz de inicio de sesión desde el archivo FXML
            StackPane root = (StackPane)FXMLLoader.load(getClass().getResource("/co/edu/poli/proyecto/vista/InicioSesion.fxml"));
            Scene scene = new Scene(root);

            // Configurar la ventana principal
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.UNDECORATED);

            // Manejar eventos de mouse para permitir arrastrar la ventana
            root.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            root.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });

            // Establecer la escena y mostrar la ventana
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
