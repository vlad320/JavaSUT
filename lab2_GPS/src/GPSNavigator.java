
    public class GPSNavigator {
        // Вычисляемое свойство
        private int devicesCount;

        // Другие свойства
        private String manufacturer;
        private String model;
        private float price;
        private float totalSum;
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
        public void setPrice(float price) {
            this.price = price;
        }
        public float getPrice() {
            return price;
        }
        public void setTotalSum(float totalSum) {
            this.totalSum = totalSum;
        }
        public float getTotalSum() {
            return totalSum;
        }

        public GPSNavigator(String manufacturer, String model, float price) {
            this.manufacturer = manufacturer;
            this.model = model;
            this.price = price;
        }
    }
