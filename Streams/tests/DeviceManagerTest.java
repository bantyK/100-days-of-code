import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Banty on 02/03/17.
 */
public class DeviceManagerTest {

    DeviceManager manager;
    List<Device> devices;
    private List<Device> resultDeviceList;

    @Before
    public void setUp() throws Exception {
        devices = Arrays.asList(
                new Device("IPHONE", "APPLE", 75000, TYPE.MOBILE, "ARM", 2),
                new Device("MOTOG2", "MOTOROLA", 9000, TYPE.MOBILE, "SNAPDRAGON", 1),
                new Device("XBOX-360", "MICROSOFT", 30000, TYPE.GAME_CONSOLES, "TBA", 8),
                new Device("PS4", "SONY", 25000, TYPE.GAME_CONSOLES, "AMD", 8),
                new Device("MACBOOK PRO", "APPLE", 200000, TYPE.LAPTOP, "INTEL", 16),
                new Device("IMAC", "APPLE", 150000, TYPE.DESKTOP, "INTEL", 16),
                new Device("XPERIA", "SONY", 7500, TYPE.MOBILE, "ARM", 1),
                new Device("PAVILION", "HP", 20000, TYPE.DESKTOP, "INTEL", 8),
                new Device("INSPIRON", "DELL", 50000, TYPE.LAPTOP, "INTEL", 6),
                new Device("IPAD", "APPLE", 20000, TYPE.TABLET, "ARM", 1),
                new Device("MI-PAD", "XIOMI", 12000, TYPE.TABLET, "SNAPDRAGON", 2),
                new Device("PIXEL", "GOOGLE", 70000, TYPE.MOBILE, "SNAPDRAGON", 4),
                new Device("GALAXY-TAB", "SAMSUNG", 15000, TYPE.TABLET, "SNAPDRAGON", 2),
                new Device("S7-EDGE", "SAMSUNG", 65000, TYPE.MOBILE, "SNAPDRAGON", 4),
                new Device("S3", "SAMSUNG", 12000, TYPE.MOBILE, "SNAPDRAGON", 2)

        );

        manager = new DeviceManager(devices);

    }

    @Test
    public void testGetAllAppleDevices() throws Exception {
        List<Device> appleDevices = manager.getAllAppleDevices();
        assertEquals(4, appleDevices.size());
        assertEquals(appleDevices.get(0).getManufacturer(), "APPLE");
        assertEquals(appleDevices.get(1).getManufacturer(), "APPLE");
        assertEquals(appleDevices.get(2).getManufacturer(), "APPLE");
        assertEquals(appleDevices.get(3).getManufacturer(), "APPLE");
    }

    @Test
    public void getAllAppleDeviceNames() throws Exception {
        List<String> resultDeviceList = manager.getAllAppleDeviceNames();

        assertEquals(4,resultDeviceList.size());
        assertEquals("IPHONE",resultDeviceList.get(0));
        assertEquals("MACBOOK PRO",resultDeviceList.get(1));
        assertEquals("IMAC",resultDeviceList.get(2));
        assertEquals("IPAD",resultDeviceList.get(3));
    }

    @Test
    public void testGetAllAppleDevicesWhichCostLessThan1Lakh() throws Exception {
        resultDeviceList = manager.getAllAppleDevicesWhichCostLessThan1Lakh();

        assertEquals(2,resultDeviceList.size());
        assertEquals("IPHONE",resultDeviceList.get(0).getName());
        assertEquals(TYPE.TABLET,resultDeviceList.get(1).getType());
    }

    @Test
    public void testGetAllMobileManufacturerNames() throws Exception {
        List<String> manufacturesNames = manager.getAllMobileManufacturerNames();

        assertEquals(6,manufacturesNames.size());
        assertEquals("APPLE",manufacturesNames.get(0));
        assertEquals("MOTOROLA",manufacturesNames.get(1));
        assertEquals("SONY",manufacturesNames.get(2));
        assertEquals("GOOGLE",manufacturesNames.get(3));
        assertEquals("SAMSUNG",manufacturesNames.get(4));
        assertEquals("SAMSUNG",manufacturesNames.get(5));

    }

    @Test
    public void testGetAllDistinctMobileManufacturesNames() throws Exception {
        List<String> distinctManufacturesNames = manager.getAllDistinctMobileManufacturesNames();
        assertEquals(5,distinctManufacturesNames.size());
        assertEquals("APPLE",distinctManufacturesNames.get(0));
        assertEquals("MOTOROLA",distinctManufacturesNames.get(1));
        assertEquals("SONY",distinctManufacturesNames.get(2));
        assertEquals("GOOGLE",distinctManufacturesNames.get(3));
        assertEquals("SAMSUNG",distinctManufacturesNames.get(4));
    }

    @Test
    public void testGetMostExpensiveMobile() throws Exception {
        Device mostExpensiveMobile = manager.getMostExpensiveMobile();
        assertEquals("IPHONE",mostExpensiveMobile.getName());
    }

    @Test
    public void testGetCheapestTabletManufacturer() throws Exception {
        String cheapestTabletManufacturer = manager.getCheapestTabletManufacturer();
        assertEquals("XIOMI",cheapestTabletManufacturer);
    }
}