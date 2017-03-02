/**
 * Created by Banty on 02/03/17.
 */
public class Device {
    private final String name;
    private final String manufacturer;
    private final float price;
    private final TYPE type;
    private final String processor;
    private final int memory;

    public Device(String name, String manufacturer, float price, TYPE type, String processor, int memory) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.type = type;
        this.processor = processor;
        this.memory = memory;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public float getPrice() {
        return price;
    }

    public TYPE getType() {
        return type;
    }

    public String getProcessor() {
        return processor;
    }

    public int getMemory() {
        return memory;
    }
}
