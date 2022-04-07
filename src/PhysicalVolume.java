public class PhysicalVolume extends Volume {
    private PhysicalHardDrive hardDrive;
    private VolumeGroups volumeGroup;

    public PhysicalVolume(String name, String physicalHardDriveName)
    {
        super(name);
        hardDrive = getPhysicalHardDrive(physicalHardDriveName);
    }

    public void setVolumeGroup(VolumeGroups volumeGroup)
    {
        this.volumeGroup = volumeGroup;
    }

    public VolumeGroups getVolumeGroup() {
        return volumeGroup;
    }

    public PhysicalHardDrive getHardDrive()
    {
        return hardDrive;
    }

    public String toString()
    {
        String str = getName() + ": [" + getHardDrive().getSize() + "] " + "[" + getUuid() + "]";
        return str;
    }
}
