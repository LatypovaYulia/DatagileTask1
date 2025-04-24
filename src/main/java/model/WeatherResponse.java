package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse {
    private Location location;
    private Current current;

    @Override
    public String toString() {
        return "Город: " + location.getName() + "\n" +
                "Дата и время: " + current.getLast_updated() + "\n" +
                "Температура воздуха: " + current.getTemp_c() + "°C (" + current.getTemp_f() + "°F)\n" +
                "Ощущается как: " + current.getFeelslike_c() + "°C (" + current.getFeelslike_f() + "°F)\n" +
                "Описание погоды: " + current.getCondition().getText() + "\n" +
                "Ветер: " + current.getWind_kph() + " км/ч (" + convertWindKphToMps(current.getWind_kph()) + " м/с)\n" +
                "Давление: " + current.getPressure_mb() + " мбар\n" +
                "Влажность: " + current.getHumidity() + "%\n" +
                "Видимость: " + current.getVis_km() + " км\n";
    }

    private double convertWindKphToMps(double kph) {
        return kph / 3.6;
    }
}
