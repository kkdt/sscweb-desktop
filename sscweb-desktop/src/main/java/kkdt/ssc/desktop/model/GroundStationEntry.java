package kkdt.ssc.desktop.model;

import kkdt.generictable.OrderedColumn;

/**
 * A table row entry for a single Ground Station.
 */
public class GroundStationEntry {
    @OrderedColumn(index=0, displayName="Id", name="Id", type=String.class)
    private String id;

    @OrderedColumn(index=1, displayName="Name", name="Name", type=String.class)
    private String name;

    @OrderedColumn(index=2, displayName="Lat", name="Lat", type=Float.class)
    private float latitude;

    @OrderedColumn(index=3, displayName="Lon", name="Lon", type=Float.class)
    private float longitude;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
