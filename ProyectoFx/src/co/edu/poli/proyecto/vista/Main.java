package co.edu.poli.proyecto.vista;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class Main extends Application {
	
	private double xOffset = 0;
    private double yOffset = 0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			StackPane root = (StackPane)FXMLLoader.load(getClass().getResource("/co/edu/poli/proyecto/vista/InicioSesion.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			
			// Manejar eventos de mouse para mover la ventana
	        root.setOnMousePressed(event -> {
	            xOffset = event.getSceneX();
	            yOffset = event.getSceneY();
	        });

	        root.setOnMouseDragged(event -> {
	            primaryStage.setX(event.getScreenX() - xOffset);
	            primaryStage.setY(event.getScreenY() - yOffset);
	        });
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
