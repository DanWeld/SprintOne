package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PropertyListModelManager implements PropertyListModel {
    private List<Property> properties;

    public PropertyListModelManager() {
        this.properties = new ArrayList<>();
        initializeProperties();
    }

    private void initializeProperties() {
        // Initialize with some sample properties
        properties.add(new Property("Vejle", 150.0,
            new Facilities(true, true, true, false, false), true));
        properties.add(new Property("Horsens", 200.0,
            new Facilities(true, true, true, true, true), true));
        properties.add(new Property("Aarhus", 120.0,
            new Facilities(true, true, false, false, false), true));
        properties.add(new Property("Aalborg", 180.0,
            new Facilities(true, true, false, true, true), false));
        properties.add(new Property("Copenhagen", 250.0,
            new Facilities(true, true, true, true, false), true));
    }

    @Override
    public Property getByID(int id) {
        if (id >= 0 && id < properties.size()) {
            return properties.get(id);
        }
        return null;
    }

    @Override
    public boolean isAvailable(Date startDate, Date endDate, int id) {
        Property property = getByID(id);
        if (property != null) {

            return property.getAvailability();
        }
        return false;
    }

    public List<Property> getAllProperties() {
        return new ArrayList<>(properties);
    }
}