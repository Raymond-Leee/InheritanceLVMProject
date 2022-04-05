public class PhysicalVolume extends Volume {
    private PhysicalHardDrive hardDrive;
    private VolumeGroups volumeGroup;

    public PhysicalVolume(String name, String physicalHardDriveName)
    {
        super(name);
        this.hardDrive = hardDrive;
    }

    public PhysicalHardDrive getHardDrive()
    {
        return hardDrive;
    }

    public String toString()
    {
        return getName() + ": [" + getHardDrive().getSize() + "] [" + volumeGroup.getName() + "] [" + getUuid() + "]";
    }
}
