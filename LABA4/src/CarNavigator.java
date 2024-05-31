

public class CarNavigator extends Navigator {

    public CarNavigator(String brand, String nameModel, String currentDestination) {
        super(brand, nameModel, currentDestination);
    }

    @Override
    public void navigateTo(String destination) {
        String from = getCurrentDestination();
        setCurrentDestination(destination);
        System.out.println("Автомобильный навигатор: Навигация от " + from + " до " + destination);
    }

    @Override
    public String getCurrentLocation() {
        return "Автомобильный навигатор: Текущее местоположение автомобиля";
    }
}