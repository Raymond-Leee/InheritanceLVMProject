public class PhysicalVolume extends Volume {
    PhysicalHardDrive hardDrive;

    public PhysicalVolume(String name, PhysicalHardDrive hardDrive) {
        super(name);
        this.hardDrive = hardDrive;
    }


}
