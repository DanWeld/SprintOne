package model;

import java.util.Date;

public interface PropertyListModel {
    Property getByID(int id);
    boolean isAvailable(Date startDate, Date endDate, int id);
}