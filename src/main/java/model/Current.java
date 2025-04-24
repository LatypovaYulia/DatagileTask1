package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Current {
    private String last_updated;
    private double temp_c;
    private double temp_f;
    private Condition condition;
    private double wind_kph;
    private double pressure_mb;
    private int humidity;
    private double feelslike_c;
    private double feelslike_f;
    private double vis_km;
}
