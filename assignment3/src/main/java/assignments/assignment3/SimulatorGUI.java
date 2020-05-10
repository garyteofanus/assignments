package assignments.assignment3;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SimulatorGUI extends Application {

    private World world;

    @Override
    public void start(Stage stage) {
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(10);
        gp.setHgap(10);

        this.world = new World();

        // Greetings and get input, output method
        HBox title = new HBox();
        Text greetings = new Text("Selamat datang di program simulasi COVID-19!");
        greetings.setFont(new Font("Arial", 20));
        title.getChildren().add(greetings);
        gp.add(title, 0, 0, 2, 1);

        // Query
        gp.add(new Label("Select your query: "), 0, 1, 1, 1);
        String[] queryList = { "Add", "Interaksi", "Positifkan", "Sembuhkan", "Bersihkan", "Rantai",
                "Total Kasus dari Objek", "Aktif Kasus dari Objek", "Total Sembuh Manusia",
                "Total Sembuh Petugas Medis", "Total Bersih Cleaning Service" };
        ChoiceBox query = new ChoiceBox(FXCollections.observableArrayList(queryList));
        gp.add(query, 1, 1, 1, 1);

        Label selection = new Label("");
        gp.add(selection, 0, 2, 1, 1);

        // Listener for query
        query.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                // TODO Auto-generated method stub
                selection.setText(queryList[newValue.intValue()] + " selected");
            }
        });

        stage.setTitle("COVID-19 Simulator");
        Scene scene = new Scene(gp, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        System.exit(0);
    }

}
