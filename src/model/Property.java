package model;

public class Property {
    private String location;
    private double pricePerNight;
    private boolean availability;
    private Facilities facilities;

    public Property(String location, double pricePerNight, Facilities facilities, boolean availability) {
        this.location = location;
        this.pricePerNight = pricePerNight;
        this.facilities = facilities;
        this.availability = availability;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Facilities getFacilities() {
        return facilities;
    }
}