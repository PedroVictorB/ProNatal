package br.com.pronatal.model;

public class Marker {
    private double latitude;
    private double longitude;

    public Marker() {

    }

    public Marker(double a, double b) {
            latitude = a;
            longitude = b;
    }

    public double getLatitude() {
            return latitude;
    }

    public void setLatitude(double latitude) {
            this.latitude = latitude;
    }

    public double getLongitude() {
            return longitude;
    }

    public void setLongitude(double longitude) {
            this.longitude = longitude;
    }
}
