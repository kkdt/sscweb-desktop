package kkdt.ssc.desktop.model;

import kkdt.generictable.OrderedColumn;

import java.util.Calendar;

/**
 * A table row entry for a single Satellite.
 */
public class SatelliteEntry {
    @OrderedColumn(index=0, displayName="Id", name="Id", type=String.class)
    private String id;

    @OrderedColumn(index=1, displayName="Name", name="Name", type=String.class)
    private String name;

    @OrderedColumn(index=2, displayName="Geometry", name="Geometry", type=String.class)
    private String geometry;

    @OrderedColumn(index=3, displayName="Trajectory Geometry", name="Trajectory Geometry", type=String.class)
    private String trajectoryGeometry;

    @OrderedColumn(index=4, displayName="Start Time", name="Start Time", type=Calendar.class)
    private Calendar startTime;

    @OrderedColumn(index=5, displayName="End Time", name="End Time", type=Calendar.class)
    private Calendar endTime;

    @OrderedColumn(index=6, displayName="Resolution", name="Resolution", type=Integer.class)
    private int resolution;

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

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public String getTrajectoryGeometry() {
        return trajectoryGeometry;
    }

    public void setTrajectoryGeometry(String trajectoryGeometry) {
        this.trajectoryGeometry = trajectoryGeometry;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }
}
