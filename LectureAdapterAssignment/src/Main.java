import java.util.List;

public class Main {
    public static void main(String[] args) {
        LegacyBulb rawBulb = new LegacyBulb();
        LegacyThermostat rawThermostat = new LegacyThermostat();

        BulbAdapter bulbAdapter = new BulbAdapter(rawBulb);

        ThermostatAdapter thermostatAdapter = new ThermostatAdapter(rawThermostat);

        List<SmartDevice> deviceList = List.of(bulbAdapter,thermostatAdapter);

        ModernHub hub = new ModernHub(deviceList);
        hub.activateAll();

        System.out.println(bulbAdapter.isOn());
        System.out.println(hub.calculateAveragePowerUsage());


        /*
         * LegacyBulb does not implement the SmartDevice interface,
         * so ModernHub cannot accept it directly.
         * BulbAdapter implements SmartDevice and wraps LegacyBulb
         * using composition without modifying the original class.
         */

        rawBulb.breakFilament();

        System.out.println(rawBulb.readBrightness());
        System.out.println(bulbAdapter.isOn());
        System.out.println(bulbAdapter.getPowerPercent());


        rawThermostat.rotateDial("STUCK");

        System.out.println(thermostatAdapter.isOn());
        System.out.println(thermostatAdapter.getPowerPercent());

        rawThermostat.rotateDial(null);
        System.out.println(thermostatAdapter.isOn());
        System.out.println(thermostatAdapter.getPowerPercent());

        hub.emergencyShutdown();
        System.out.println(hub.calculateAveragePowerUsage());

        System.out.println("is bulb on? : " + bulbAdapter.isOn());
        System.out.println("is thermostat on? : " + thermostatAdapter.isOn());





    }

}
