public class BulbAdapter implements SmartDevice {
    private final LegacyBulb bulb;

    public BulbAdapter(LegacyBulb bulb) {
        if (bulb == null) {
            throw new IllegalArgumentException("Bulb can't be null!");
        }

        this.bulb = bulb;
    }

    @Override
    public void turnOn(){
        bulb.setBrightness(255);
    }

    @Override
    public void turnOff(){
        bulb.setBrightness(0);
    }

    @Override
    public boolean isOn(){
        if(bulb.hasPower()==true && bulb.readBrightness()>0){
            return true;
        }
        return false;
    }

    @Override
    public int getPowerPercent(){

        if(bulb.readBrightness()==0 ){
            return 0;
        }

        if (bulb.hasPower()==false){
            return 0;
        }

        int power = 0 ;

        power = ((bulb.readBrightness()*100)/255);
        power+=9;

        if(power>100){
            power=100;
        }
        return power;
    }
}
