package mk.ukim.finki.dians.model;

import jdk.jfr.Timestamp;
import lombok.Data;

import java.sql.Time;

@Data
public class Wine {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String urlWeb;
    private String openingHours;
    private Double lat;
    private  Double lon;

    public Wine(Long id, String name, String address, String phone, String urlWeb, String openingHours, Double lat, Double lon) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.urlWeb = urlWeb;
        this.openingHours = openingHours;
        this.lat = lat;
        this.lon = lon;
    }

}
