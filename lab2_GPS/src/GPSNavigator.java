public class GPSNavigator {
    // Вычисляемое свойство
    private int devicesCount;

    // Другие свойства
    private String manufacturer;
    private String model;
    private int price;
    private int totalSum;
    // Конструктор по умолчанию
    public GPSNavigator() {
        this("", "");
    }

    // Конструктор с параметрами
    public GPSNavigator(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    // Геттер и сеттер для вычисляемого свойства
    public int getDevicesCount() {
        return devicesCount;
    }

    public void setDevicesCount(int devicesCount) {
        this.devicesCount = devicesCount;
    }

    // Геттеры и сеттеры для других свойств
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }
    public int getTotalSum() {
        return totalSum;
    }

    public GPSNavigator(String manufacturer, String model, int price) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
    }
}
