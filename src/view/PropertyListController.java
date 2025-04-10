package view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Property;
import viewModel.PropertyListVM;

public class PropertyListController {
    @FXML
    private TableView<Property> table;
    
    @FXML
    private TableColumn<Property, String> locationColumn;
    
    @FXML
    private TableColumn<Property, Double> pricePerNightColumn;
    
    @FXML
    private TableColumn<Property, String> facilitiesColumn;
    
    private PropertyListVM vm;
    
    public PropertyListController(PropertyListVM vm) {
        this.vm = vm;
    }
    
    @FXML
    public void initialize() {

        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        pricePerNightColumn.setCellValueFactory(new PropertyValueFactory<>("pricePerNight"));
        
        // custom cell factory to display the facilities string
        facilitiesColumn.setCellValueFactory(cellData -> {
            Property property = cellData.getValue();
            return new javafx.beans.property.SimpleStringProperty(
                property.getFacilities().toString());
        });
        
        // Bind table items to the ViewModel's property list
        table.setItems(vm.getPropertyList());
        
        // Handle selection changes
        table.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            vm.getSelectedIndexProperty().set(newValue.intValue());
        });
    }
}