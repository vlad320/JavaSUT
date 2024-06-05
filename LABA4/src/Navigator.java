

import java.util.ArrayList;
import java.util.List;

public abstract class Navigator {
    private String brand;
    private String nameModel;
    private String currentDestination;
    private List<String> routeHistory = new ArrayList<>();

    public Navigator(String brand, String nameModel, String currentDestination) {
        this.brand = brand;
        this.nameModel = nameModel;
        this.currentDestination = currentDestination;
    }


    public abstract void navigateTo(String destination);
    public abstract String getCurrentLocation();
    public abstract String getType();

    public String getBrand() {
        return brand;
    }

    public String getNameModel() {
        return nameModel;
    }

    public String getCurrentDestination() {
        return currentDestination;
    }

    public void setCurrentDestination(String currentDestination) {
        this.currentDestination = currentDestination;
        routeHistory.add(currentDestination); // Добавление в историю маршрутов
    }
    public String toDataString() {
        return getType() + "," + brand + "," + nameModel + "," + currentDestination;
    }

    public static Navigator fromDataString(String data) {
        String[] parts = data.split(",");
        String type = parts[0];
        String brand = parts[1];
        String nameModel = parts[2];
        String currentDestination = parts[3];

        switch (type) {
            case "GPS":
                return new GPSNavigator(brand, nameModel, currentDestination);
            case "Car":
                return new CarNavigator(brand, nameModel, currentDestination);
            case "Compas":
                return new Compas(brand, nameModel, currentDestination);
            default:
                throw new IllegalArgumentException("Unknown navigator type: " + type);
        }
    }

    public List<String> getRouteHistory() {
        return routeHistory;
    }
}