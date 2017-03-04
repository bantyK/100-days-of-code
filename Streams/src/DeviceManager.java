import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Banty on 02/03/17.
 */
public class DeviceManager {
    List<Device> devices;

    public DeviceManager(List<Device> devices) {
        this.devices = devices;
    }

    public List<Device> getAllAppleDevices() {
        return devices.stream()
                .filter(device -> device.getManufacturer().equals("APPLE"))
                .collect(Collectors.toList());
    }

    public List<String> getAllAppleDeviceNames() {
        return devices.stream()
                .filter(device -> device.getManufacturer().equals("APPLE"))
                .map(Device::getName)
                .collect(Collectors.toList());

    }

    public List<Device> getAllAppleDevicesWhichCostLessThan1Lakh() {
        return devices.stream()
                .filter(device -> device.getManufacturer().equals("APPLE"))
                .filter(device -> device.getPrice() < 100000)
                .collect(Collectors.toList());
    }

    public List<String> getAllMobileManufacturerNames() {
        return devices.stream()
                .filter(device -> device.getType().equals(TYPE.MOBILE))
                .map(Device::getManufacturer)
                .collect(Collectors.toList());
    }

    public List<String> getAllDistinctMobileManufacturesNames() {
        return devices.stream()
                .filter(device -> device.getType().equals(TYPE.MOBILE))
                .map(Device::getManufacturer)
                .distinct()
                .collect(Collectors.toList());
    }

    public Device getMostExpensiveMobile() {
        return devices.stream()
                .filter(device -> device.getType().equals(TYPE.MOBILE))
                .sorted((d1, d2) -> Float.compare(d2.getPrice(), d1.getPrice()))
                .limit(1)
                .findFirst()
                .get();
    }

    public String getCheapestTabletManufacturer() {
        return devices.stream()
                .filter(device -> device.getType().equals(TYPE.TABLET))
                .sorted((d1, d2) -> Float.compare(d1.getPrice(), d2.getPrice()))
                .limit(1)
                .map(Device::getManufacturer)
                .findFirst()
                .get();
    }

    public String getSecondMostExpensiveLaptopManufacturer() {
        return devices.stream()
                .filter(device -> device.getType().equals(TYPE.LAPTOP))
                .sorted((d1, d2) -> Float.compare(d2.getPrice(), d1.getPrice()))
                .skip(1)
                .map(Device::getManufacturer)
                .findFirst()
                .get();
    }

    public List<Device> getAllSamsungDevices() {
        return devices.stream()
                .filter(device -> device.getManufacturer().equals("SAMSUNG"))
                .collect(Collectors.toList());


    }

    public void getAppleDeviceifPresentElseSamsungDevice() {
        devices.stream()
                .filter(device -> device.getManufacturer().equals("APPLE"))
                .findAny()
                .ifPresent(device -> System.out.print(device.getManufacturer()));
    }
}
