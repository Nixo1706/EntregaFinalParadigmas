package co.edu.poli.proyecto.controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.poli.proyecto.modelo.*;
import co.edu.poli.proyecto.servicios.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController implements Initializable {

	private ObservableList<Reserva> reservas;
	OperacionArchivo operacionArchivo = new ImpleOperacionArchivo();

	private ArrayList<String> errores;

	private double xOffset = 0;
	private double yOffset = 0;

	@FXML
	private TextField txf_idreserva;
	@FXML
	private ComboBox<String> cmb_laboratorio;
	@FXML
	private TextField txf_hora;
	@FXML
	private TextField txf_minuto;
	@FXML
	private DatePicker dtp_fecha;
	@FXML
	private Button btn_nueva_reserva;
	@FXML
	private Button btn_limpiar;
	@FXML
	private Button btn_eliminar_reserva;
	@FXML
	private Button btn_cambiar_reserva;
	@FXML
	private Pane pnl_historial;
	@FXML
	private TableView<Reserva> tabla_obj;
	@FXML
	private TableColumn<Reserva, Integer> col_id_reser_h;
	@FXML
	private TableColumn<Reserva, String> col_lab_h;
	@FXML
	private TableColumn<Reserva, String> col_fecha_h;
	@FXML
	private TableColumn<Reserva, LocalTime> col_horaini_h;
	@FXML
	private TableColumn<Reserva, LocalTime> col_horafin_h;
	@FXML
	private TableColumn<Reserva, String> col_estado_h;
	@FXML
	private TextField txf_buscar;
	@FXML
	private Button btn_historial;
	@FXML
	private Button btn_reservas_disp;
	@FXML
	private Label lb_usuario;
	@FXML
	private Button btn_salir;

	private ObservableList<Reserva> reservasList;
	private ObservableList<Reserva> reservasDisList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		errores = new ArrayList<String>();

		reservas = FXCollections.observableArrayList();

		// Configurar las columnas de tabla_obj
		col_id_reser_h.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()).asObject());
		col_lab_h.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLaboratorio().getSalon()));
		col_fecha_h
				.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getHorarioReserva().getFecha()));
		col_horaini_h.setCellValueFactory(
				data -> new SimpleObjectProperty<>(data.getValue().getHorarioReserva().getHoraInicio()));
		col_horafin_h.setCellValueFactory(data -> {
			TiempoReserva tiempoReserva = data.getValue().getHorarioReserva();
			return new SimpleObjectProperty<>(tiempoReserva.calcularHoraFin(tiempoReserva.getHoraInicio()));
		});
		col_estado_h.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEstado()));

		reservasList = FXCollections.observableArrayList();
		tabla_obj.setItems(reservasList);

		btn_nueva_reserva.setDisable(false);
		btn_cambiar_reserva.setDisable(true);
		btn_eliminar_reserva.setDisable(true);

		tabla_obj.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Reserva>() {
			@Override
			public void changed(ObservableValue<? extends Reserva> observable, Reserva elementoAnterior,
					Reserva busSeleccionado) {
				if (busSeleccionado != null) {
					txf_idreserva.setText(String.valueOf(busSeleccionado.getId()));

					btn_nueva_reserva.setDisable(true);
					btn_cambiar_reserva.setDisable(false);
					btn_eliminar_reserva.setDisable(false);
				}
			}
		});


		// Combobox laboratorio y hora
		ObservableList<String> labs = FXCollections.observableArrayList();
		labs.add("C202");
		labs.add("J103");
		labs.add("C101");
		labs.add("F102");
		labs.add("L201");
		cmb_laboratorio.setItems(labs);

		deserializarReservas("./", "reservas.txt");
	}

	private void serializarReservas(String path, String fileName) {
		Reserva[] reservasArray = reservasList.toArray(new Reserva[reservasList.size()]);
		operacionArchivo.serealizar(reservasArray, path, fileName);
	}

	private void deserializarReservas(String path, String fileName) {
		Reserva[] reservasArray = operacionArchivo.deserealizar(path, fileName);
		if (reservasArray != null) {
			reservasList.setAll(reservasArray);
		} else {
			reservasList.clear();
		}
	}

	// Event Listener on Button[#btn_nueva_reserva].onAction
	@FXML
	public void btn_nueva_reserva_a(ActionEvent event) {

		reservasList.add(new Reserva(Integer.parseInt(txf_idreserva.getText()),
				new Laboratorio(cmb_laboratorio.getSelectionModel().getSelectedItem(), 10, 20),
				new Usuario("admin", 12345, "admin@universidad.edu"),
				new TiempoReserva(dtp_fecha.getValue().toString(),
						LocalTime.of(Integer.parseInt(txf_hora.getText()), Integer.parseInt(txf_minuto.getText()))),
				"ACTIVO"));
		serializarReservas("./", "reservas.txt");

		btn_limpiar_a();
		Alert info = new Alert(AlertType.INFORMATION);
		info.setContentText("Reserva creada exitosamente");
		info.show();

	}

	// Event Listener on Button[#btn_limpiar].onAction
	@FXML
	public void btn_limpiar_a() {
		txf_idreserva.setText(null);
		dtp_fecha.setValue(null);
		cmb_laboratorio.getSelectionModel().select(null);
		txf_hora.setText(null);
		txf_minuto.setText(null);

		btn_nueva_reserva.setDisable(false);
		btn_cambiar_reserva.setDisable(true);
		btn_eliminar_reserva.setDisable(true);

		tabla_obj.getSelectionModel().clearSelection();
	}

	// Event Listener on Button[#btn_eliminar_reserva].onAction
	@FXML
	public void btn_eliminar_reserva_a(ActionEvent event) {
		Alert mensaje = new Alert(AlertType.CONFIRMATION);
		mensaje.setTitle("Eliminar");
		mensaje.setHeaderText("Se eliminará una reserva");
		mensaje.setContentText("¿Desea eliminar la reserva");

		Reserva selectedReserva = tabla_obj.getSelectionModel().getSelectedItem();
		Optional<ButtonType> resultado = mensaje.showAndWait();
		if (resultado.get() == ButtonType.OK) {
			btn_limpiar_a();
			Alert info = new Alert(AlertType.INFORMATION);
			info.setContentText("Reserva eliminada exitosamente");
			info.show();
			if (selectedReserva != null) {
				// Cambiar el estado a "INACTIVO"
				selectedReserva.setEstado("INACTIVO");

				// Actualizar la tabla para reflejar el cambio
				tabla_obj.refresh();

				// Serializar las reservas para guardar los cambios
				serializarReservas("./", "reservas.txt");
			}
		}
	}

	// Event Listener on Button[#btn_cambiar_reserva].onAction
	@FXML
	public void btn_cambiar_reserva_a(ActionEvent event) {

		validarReservas();
		if (errores.size() > 0) {
			String cadenaErrores = "";
			for (int i = 0; i < errores.size(); i++) {
				cadenaErrores += errores.get(i) + "\n";
			}
			Alert mensaje = new Alert(AlertType.ERROR);
			mensaje.setTitle("Error");
			mensaje.setHeaderText("Se encontraron los siguientes errores:");
			mensaje.setContentText(cadenaErrores);
			mensaje.show();
			return;
		}
		reservasList.set(tabla_obj.getSelectionModel().getSelectedIndex(),
				new Reserva(Integer.parseInt(txf_idreserva.getText()),
						new Laboratorio(cmb_laboratorio.getSelectionModel().getSelectedItem(), 10, 20),
						new Usuario("admin", 12345, "admin@universidad.edu"),
						new TiempoReserva(dtp_fecha.getValue().toString(), LocalTime
								.of(Integer.parseInt(txf_hora.getText()), Integer.parseInt(txf_minuto.getText()))),
						"ACTIVO"));
		serializarReservas("./", "reservas.txt");

		btn_limpiar_a();
		Alert info = new Alert(AlertType.INFORMATION);
		info.setContentText("Reserva creada exitosamente");
		info.show();

	}

	// Event Listener on Button[#btn_salir].onAction
	@FXML
	public void btn_salir_a(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/poli/proyecto/vista/InicioSesion.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.initStyle(StageStyle.UNDECORATED);

			root.setOnMousePressed(eventPressed -> {
				xOffset = eventPressed.getSceneX();
				yOffset = eventPressed.getSceneY();
			});

			root.setOnMouseDragged(eventDragged -> {
				stage.setX(eventDragged.getScreenX() - xOffset);
				stage.setY(eventDragged.getScreenY() - yOffset);
			});
			stage.setScene(scene);
			stage.show();

			((Node) (event.getSource())).getScene().getWindow().hide();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deserializarReservasDisponibles(String filePath) {
	    reservasDisList.clear(); // Clear the existing list before adding new data

	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] parts = line.split(","); // Assuming the file is comma-separated

	            if (parts.length == 6) { // Adjust the number according to your file format
	                int id = Integer.parseInt(parts[0]);
	                Laboratorio laboratorio = new Laboratorio(parts[1], 10, 20); // Assuming fixed capacity values
	                Usuario usuario = new Usuario("admin", 12345, "admin@universidad.edu");
	                String fecha = parts[2];
	                LocalTime horaInicio = LocalTime.parse(parts[3]); // Assuming the time is in HH:mm format
	                TiempoReserva tiempoReserva = new TiempoReserva(fecha, horaInicio);
	                String estado = parts[4];

	                if ("ACTIVO".equalsIgnoreCase(estado)) { // Only add if the state is "ACTIVO"
	                    Reserva reserva = new Reserva(id, laboratorio, usuario, tiempoReserva, estado);
	                    reservasDisList.add(reserva);
	                }
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        Alert errorAlert = new Alert(AlertType.ERROR);
	        errorAlert.setTitle("Error");
	        errorAlert.setHeaderText("Error al leer el archivo");
	        errorAlert.setContentText("No se pudo leer el archivo de reservas disponibles.");
	        errorAlert.show();
	    }
	}

	public void validarReservas() {
		errores.clear();

		/*
		 * String patronHora = "[0-23]"; String patronMinuto = "[0-59]";
		 */

		// id reserva
		try {
			String idReserva = txf_idreserva.getText();
			if (idReserva == null || idReserva.isEmpty()) {
				throw new NullPointerException("El campo id reserva es obligatorio");
			}
			Integer.parseInt(idReserva);
		} catch (NumberFormatException e) {
			errores.add("El campo id reserva debe ser numérico");
		} catch (NullPointerException e) {
			errores.add(e.getMessage());
		}

		// laboratorio
		if (cmb_laboratorio.getSelectionModel().getSelectedItem() == null) {
			errores.add("Debe seleccionar un laborartorio");
		}
		// fecha
		try {
			LocalDate fechaSeleccionada = dtp_fecha.getValue();
			if (fechaSeleccionada == null) {
				throw new NullPointerException("El campo fecha de funcionamiento es obligatorio");
			}
		} catch (NullPointerException e) {
			errores.add(e.getMessage());
		} catch (Exception e) {
			errores.add("Error al ingresar la fecha");
		}
		// hora
		try {
			String horaText = txf_hora.getText();

			if (horaText == null || horaText.isEmpty()) {
				throw new NullPointerException("El campo hora es obligatorio");
			}

			int hora = Integer.parseInt(horaText); // This will throw NumberFormatException if not a number

			// Check if hora is within the range 0 to 23
			if (hora < 0 || hora > 23) {
				throw new IllegalArgumentException("El campo hora debe estar entre 0 y 23");
			}
		} catch (NumberFormatException e) {
			errores.add("El campo hora debe ser numérico");
		} catch (NullPointerException e) {
			errores.add(e.getMessage());
		} catch (IllegalArgumentException e) {
			errores.add(e.getMessage());
		}
		// minuto
		try {
			String minuto = txf_minuto.getText();

			if (minuto == null || minuto.isEmpty()) {
				throw new NullPointerException("El campo minuto es obligatorio");
			}

			int minutoInt = Integer.parseInt(minuto);

			if (minutoInt < 0 || minutoInt > 59) {
				throw new IllegalArgumentException("El campo minuto debe estar entre 0 y 59");
			}
		} catch (NumberFormatException e) {
			errores.add("El campo hora debe ser numérico");
		} catch (NullPointerException e) {
			errores.add(e.getMessage());
		} catch (IllegalArgumentException e) {
			errores.add(e.getMessage());
		}
	}

}