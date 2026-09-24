public class ThermostatAdapter implements SmartDevice{
    private final  LegacyThermostat thermostat ;

    public ThermostatAdapter(LegacyThermostat thermostat){

        if(thermostat==null){
            throw new IllegalArgumentException("Thermostat cant be null!");
        }

        this.thermostat = thermostat;
    }

    @Override
    public void turnOn(){

        if("IDLE".equals(thermostat.checkDial())){
            thermostat.rotateDial("LOW");
        }
    }

    @Override
    public void turnOff(){
        thermostat.rotateDial("IDLE");
    }

    @Override
    public boolean isOn() {
        if ("LOW".equals(thermostat.checkDial()) ||
                "MEDIUM".equals(thermostat.checkDial()) ||
                "MAX".equals(thermostat.checkDial())) {
            return true;
        }

        return false;
    }

    @Override
    public int getPowerPercent(){
        if("IDLE".equals(thermostat.checkDial())){
            return 0;
        }
        if("LOW".equals(thermostat.checkDial())){
            return 33;
        }

        if("MEDIUM".equals(thermostat.checkDial())){
            return 66;
        }

        if("MAX".equals(thermostat.checkDial())){
            return 100;
        }
        return -1;
    }

}
