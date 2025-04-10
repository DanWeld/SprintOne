package view;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import viewModel.BookingVM;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class BookingController {
    @FXML
    private TextArea location;
    
    @FXML
    private TextArea pricePerNight;
    
    @FXML
    private TextArea propertyFacilities;
    
    @FXML
    private DatePicker changeEndDate;
    
    @FXML
    private TextArea availability;
    
    private BookingVM vm;
    
    public BookingController(BookingVM vm) {
        this.vm = vm;
    }
    
    @FXML
    public void initialize() {
        // Bind UI elements to ViewModel properties
        location.textProperty().bind(vm.location());
        pricePerNight.textProperty().bind(vm.pricePerNight().asString());
        propertyFacilities.textProperty().bind(vm.propertyFacilities());
        
        // Bind availability as text
        vm.availability().addListener((observable, oldValue, newValue) -> {
            availability.setText(newValue ? "Available" : "Not Available");
        });
        
        // Handle date changes
        changeEndDate.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Date date = Date.from(newValue.atStartOfDay(ZoneId.systemDefault()).toInstant());
                vm.changeEndDate().set(date);
            }
        });
    }
}