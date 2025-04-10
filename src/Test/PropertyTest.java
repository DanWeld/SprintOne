package Test;

import model.Facilities;
import model.Property;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class PropertyTest {
    
    private Property property;
    
    @Mock
    private Facilities mockFacilities;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        property = new Property("Test Location", 100.0, mockFacilities, true);
    }
    
    @Test
    public void testGetLocation() {
        assertEquals("Test Location", property.getLocation());
    }
    
    @Test
    public void testSetLocation() {
        property.setLocation("New Location");
        assertEquals("New Location", property.getLocation());
    }
    
    @Test
    public void testGetPricePerNight() {
        assertEquals(100.0, property.getPricePerNight(), 0.001);
    }
    
    @Test
    public void testSetPricePerNight() {
        property.setPricePerNight(150.0);
        assertEquals(150.0, property.getPricePerNight(), 0.001);
    }
    
    @Test
    public void testGetAvailability() {
        assertTrue(property.getAvailability());
    }
    
    @Test
    public void testSetAvailability() {
        property.setAvailability(false);
        assertFalse(property.getAvailability());
    }
    
    @Test
    public void testGetFacilities() {
        when(mockFacilities.toString()).thenReturn("Mock Facilities");
        assertEquals(mockFacilities, property.getFacilities());
    }
}