package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.helpers.TableViewObject;
import sample.model.Model;
import sample.model.ObjectToAdd;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class DatabaseTableWindowController implements Initializable {
    @FXML
    TableView<TableViewObject> tableviewId;
    @FXML
    private TableColumn<TableViewObject, String> dateId;
    @FXML
    private TableColumn<TableViewObject, Integer> incomeId;
    @FXML
    private TableColumn<TableViewObject, Integer> expenseId;
    @FXML
    private TableColumn<TableViewObject, String> dateAddedId;

    ObservableList<TableViewObject> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Map<String, ObjectToAdd> usermap = new TreeMap<String, ObjectToAdd>();
        usermap = Model.getInstance().getCurrentUserList();
        for(Map.Entry<String, ObjectToAdd> element : usermap.entrySet()){
            TableViewObject tableViewObject = new TableViewObject(
                    element.getKey(),
                    element.getValue().getIncome(),
                    element.getValue().getExpense(),
                    element.getValue().getDateAdded()
            );
            list.add(tableViewObject);
        }
        tableviewId.setItems(list);
        dateId.setCellValueFactory(new PropertyValueFactory<TableViewObject, String>("date"));
        incomeId.setCellValueFactory(new PropertyValueFactory<TableViewObject, Integer>("income"));
        expenseId.setCellValueFactory(new PropertyValueFactory<TableViewObject, Integer>("expense"));
        dateAddedId.setCellValueFactory(new PropertyValueFactory<TableViewObject, String>("dateAdded"));
    }
}
