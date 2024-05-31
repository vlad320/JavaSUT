

import java.util.ArrayList;
import java.util.List;

public abstract class Navigator {
    private String brand; // Исправлено с brend на brand
    private String nameModel;
    private String currentDestination;
    private List<String> routeHistory = new ArrayList<>();

    public Navigator(String brand, String nameModel, String currentDestination) {
        this.brand = brand;
        this.nameModel = nameModel;
        this.currentDestination = currentDestination;
    }

    // Абстрактные методы
    public abstract void navigateTo(String destination);
    public abstract String getCurrentLocation();

    // Геттеры и сеттеры
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public String getCurrentDestination() {
        return currentDestination;
    }

    public void setCurrentDestination(String currentDestination) {
        this.currentDestination = currentDestination;
        routeHistory.add(currentDestination); // Добавление в историю маршрутов
    }

    public List<String> getRouteHistory() {
        return routeHistory;
    }
}