package br.com.pronatal.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "marker")
public class Marker implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "latitude", nullable = false)
    private double latitude;
    
    @Column(name = "longitude", nullable = false)
    private double longitude;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
