package assignments.assignment3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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

        GridPane gp2 = new GridPane();
        gp2.setAlignment(Pos.CENTER);
        gp2.setVgap(10);
        gp2.setHgap(10);

        this.world = new World();

        // Greetings and get input, output method
        HBox title = new HBox();
        Text greetings = new Text("Selamat datang di program simulasi COVID-19!");
        greetings.setFont(new Font("Arial", 20));
        title.getChildren().add(greetings);
        gp.add(title, 0, 0, 2, 1);

        // Query
        gp.add(new Label("Select your query: "), 0, 1, 1, 1);
        String[] queryList = { "Add", "Interaksi", "Positifkan", "Sembuhkan", 
            "Bersihkan", "Rantai", "Total Kasus dari Objek", "Aktif Kasus dari Objek",
            "Total Sembuh Manusia", "Total Sembuh Petugas Medis",
            "Total Bersih Cleaning Service", "Exit" };
        ChoiceBox query = new ChoiceBox(FXCollections.observableArrayList(queryList));
        gp.add(query, 1, 1, 1, 1);

        gp.add(new Label("Object 1: "), 0, 2, 1, 1);
        TextField object1 = new TextField();
        gp.add(object1, 1, 2, 1, 1);

        gp.add(new Label("Object 2: "), 0, 3, 1, 1);
        TextField object2 = new TextField();
        gp.add(object2, 1, 3, 1, 1);

        Button simulate = new Button("Simulate!");
        gp.add(simulate, 0, 4, 1, 1);

        Button undo = new Button("Undo");
        gp.add(undo, 1, 4, 1, 1);

        Button next = new Button("Next");
        gp.add(next, 2, 4, 1, 1);

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                String option = (String) query.getSelectionModel().getSelectedItem();
                String input1 = object1.getText();
                String input2 = object2.getText();

                Carrier obj1 = world.getCarrier(input1);
                Carrier obj2 = world.getCarrier(input2);

                switch (option.toUpperCase()) {
                    case "ADD":
                        world.listCarrier.add(world.createObject(input1, input2));
                        break;
                    case "INTERAKSI":
                        if (obj1.getStatusCovid().equalsIgnoreCase("Positif")) {
                            obj1.interaksi(obj2);
                        } else if (obj2.getStatusCovid().equalsIgnoreCase("Positif")) {
                            obj2.interaksi(obj1);
                        }
                        break;
                    case "POSITIFKAN":
                        obj1.ubahStatus("Positif");
                        break;
                    case "SEMBUHKAN":
                        ((PetugasMedis) obj1).obati((Manusia) obj2);
                        break;
                    case "BERSIHKAN":
                        ((CleaningService) obj1).bersihkan((Benda) obj2);
                        break;
                    case "RANTAI":
                        try {
                            if (obj1.getStatusCovid().equalsIgnoreCase("Negatif")) {
                                throw new BelumTertularException(
                                        String.format("%s berstatus negatif", obj1.toString()));
                            } else if (obj1.getStatusCovid().equalsIgnoreCase("Positif")) {
                                String ret = "Rantai penyebaran " + obj1.toString() + ": ";
                                if (obj1.getRantaiPenular().size() != 0) {
                                    for (Carrier carrier : obj1.getRantaiPenular()) {
                                        ret += carrier.toString() + " -> ";
                                    }
                                }
                                ret += obj1.toString();
                                System.out.println(ret);
                            }
                        } catch (BelumTertularException err) {
                            System.out.println(err);
                        }
                        break;
                    case "TOTAL KASUS DARI OBJEK":
                        System.out.println(String.format(
                            "%s telah menyebarkan virus COVID ke %d objek",
                                obj1.toString(), obj1.getTotalKasusDisebabkan()));
                        break;
                    case "AKTIF KASUS DARI OBJEK":
                        System.out.println(String.format(
                                "%s telah menyebarkan virus COVID "
                                        + "dan masih teridentifikasi positif sebanyak %d objek",
                                obj1.toString(), obj1.getAktifKasusDisebabkan()));
                        break;
                    case "TOTAL SEMBUH MANUSIA":
                        System.out.println(String.format(
                            "Total sembuh dari kasus COVID "
                                + "yang menimpa manusia ada sebanyak: %d kasus",
                                Manusia.getJumlahSembuh()));
                        break;
                    case "TOTAL SEMBUH PETUGAS MEDIS":
                        System.out.println(String.format(
                            "%s menyembuhkan %d manusia", obj1.toString(),
                                ((PetugasMedis) obj1).getJumlahDisembuhkan()));
                        break;
                    case "TOTAL BERSIH CLEANING SERVICE":
                        System.out.println(String.format(
                            "%s membersihkan %d benda", obj1.toString(),
                                ((CleaningService) obj1).getJumlahDibersihkan()));
                        break;
                    default:
                        System.exit(0);
                }
                object1.clear();
                object2.clear();
            }
        };
        next.setOnAction(event);

        Stage listOfQueries = new Stage();
        listOfQueries.setTitle("List Of Queries");
        listOfQueries.show();

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
