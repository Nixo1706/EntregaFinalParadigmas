package co.edu.poli.proyecto.controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Controlador para la ventana de inicio de sesión.
 * Administra la interfaz de usuario y la lógica para la autenticación de usuarios.
 * Implementa {@link Initializable} para inicializar los componentes de la interfaz.
 * 
 */
public class InicioSesionController implements Initializable {

    private ArrayList<String> errores;
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private ImageView img_salir;
    @FXML
    public TextField txf_usuario;
    @FXML
    private TextField txf_contrasena;
    @FXML
    private Button btn_ingresar;

    /**
     * Inicializa el controlador de la vista.
     * Configura los componentes y la lista de errores.
     * 
     * @param arg0 el URL de la vista.
     * @param arg1 el conjunto de recursos utilizado para localizar la vista.
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        errores = new ArrayList<String>();
    }

    /**
     * Maneja el evento de ingresar a la aplicación.
     * Valida los campos de usuario y contraseña, y si son correctos, carga la vista del menú.
     * 
     * @param event el evento de acción.
     */
    @FXML
    public void btn_ingresar_a(ActionEvent event) {
        validarCompra();

        // Si no hay errores, cargar la nueva ventana desde el archivo FXML
        if (errores.isEmpty()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/poli/proyecto/vista/Menu.fxml"));
                Parent root = loader.load();
                MenuController controller = loader.getController();

                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.initStyle(StageStyle.UNDECORATED);
                root.setOnMousePressed(mouseEvent -> {
                    xOffset = mouseEvent.getSceneX();
                    yOffset = mouseEvent.getSceneY();
                });

                root.setOnMouseDragged(mouseEvent -> {
                    stage.setX(mouseEvent.getScreenX() - xOffset);
                    stage.setY(mouseEvent.getScreenY() - yOffset);
                });

                stage.setScene(scene);
                stage.show();

                ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Si hay errores, mostrarlos al usuario
            String mensajeErrores = String.join("\n", errores);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Se encontraron errores:");
            alert.setContentText(mensajeErrores);
            alert.showAndWait();
        }
    }

    /**
     * Maneja el evento de presionar un label.
     * 
     * @param event el evento de mouse.
     */
    @FXML
    public void presionarLabel(MouseEvent event) {
        // TODO Autogenerated
    }

    /**
     * Maneja el evento de presionar el botón de salir.
     * Cierra la aplicación.
     * 
     * @param event el evento de mouse.
     */
    @FXML
    public void presionarSalir(MouseEvent event) {
        Platform.exit();
    }

    /**
     * Valida los campos del formulario de inicio de sesión.
     * Agrega errores a la lista de errores si hay campos inválidos.
     */
    public void validarCompra() {
        errores.clear();
        // Validar usuario
        try {
            String usuText = txf_usuario.getText();
            if (usuText == null || usuText.isEmpty()) {
                throw new NullPointerException("El campo usuario es obligatorio");
            }
        } catch (NullPointerException e) {
            errores.add(e.getMessage());
        }
        // Validar contraseña
        try {
            String usuText = txf_contrasena.getText();
            if (usuText == null || usuText.isEmpty()) {
                throw new NullPointerException("El campo contraseña es obligatorio");
            }
        } catch (NullPointerException e) {
            errores.add(e.getMessage());
        }
    }
}
