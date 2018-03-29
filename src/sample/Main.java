package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Main extends Application {
    private TableView<Student> tableMain = new TableView<Student>();
    private TableColumn<Student, String> col1 = new TableColumn<>("Full name");
    private TableColumn<Student, String> col2 = new TableColumn<>("Group ID");
    private TableColumn<Student, TableColumn> col3 = new TableColumn<>("Exams");

    @Override
    public void start(Stage primaryStage) throws Exception{
        col1.setCellValueFactory(new PropertyValueFactory<Student, String>("fullName"));
        col2.setCellValueFactory(new PropertyValueFactory<Student, String>("groupNum"));

        ObservableList<TableColumn> listOfColumns = FXCollections.observableArrayList();
        ObservableList<Exam> examObservableList = FXCollections.observableArrayList();
        examObservableList.addAll(new Exam("PIVS", 10), new Exam("MOIS", 10));
        for (int i = 0; i< examObservableList.size(); i++){
            TableColumn<Student,TableColumn> colx = new TableColumn<Student, TableColumn>(String.valueOf(i + 1) + " exam");
            listOfColumns.add(colx);

            TableColumn<Student, String> name = new TableColumn<>("Name");
            TableColumn<Student, String> score = new TableColumn<>("Score");

            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            score.setCellValueFactory(new PropertyValueFactory<>("score"));

            colx.getColumns().addAll(name, score);

            col3.getColumns().add(colx);
        }
        Student stud = new Student("Maks", "621701", examObservableList);
        tableMain.getColumns().addAll(col1, col2, col3);
        ObservableList<Student> students = FXCollections.observableArrayList();
        students.addAll(stud);
        tableMain.getItems().addAll(students);
        Scene scene = new Scene(new Group(), 640, 480);
        Group root = (Group)scene.getRoot();
        root.getChildren().addAll(tableMain);
        primaryStage.setTitle("PIVS - 2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
