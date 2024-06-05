

public class Compas extends Navigator {
    public Compas(String brand, String nameModel, String currentDestination) {
        super(brand, nameModel, currentDestination);
    }

    @Override
    public void navigateTo(String destination) {
        String from = getCurrentDestination();
        setCurrentDestination(destination);
        System.out.println("Компас: Навигация от " + from + " до " + destination);
    }

    @Override
    public String getCurrentLocation() {
        return "Компас: Текущее местоположение для "  + " - " + getCurrentDestination();
    }
    @Override
    public String getType() {
        return "Compas";
    }

}
