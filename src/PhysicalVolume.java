public class PhysicalVolume extends Volume {
    PhysicalHardDrive hardDrive;

    public PhysicalVolume(String name, String uuid, PhysicalHardDrive hardDrive) {
        super(name);
        this.hardDrive = hardDrive;
    }
}
