

public class GPSNavigator extends Navigator {

    public GPSNavigator(String brand, String nameModel, String currentDestination) {
        super(brand, nameModel, currentDestination);
    }

    @Override
    public void navigateTo(String destination) {
        String from = getCurrentDestination();
        setCurrentDestination(destination);
        System.out.println("GPS-навигатор: Навигация от " + from + " до " + destination);
    }

    @Override
    public String getCurrentLocation() {
        return "GPS-навигатор: Текущее местоположение для "  + " - " + getCurrentDestination();
    }
    @Override
    public String getType() {
        return "GPS";
    }
}
