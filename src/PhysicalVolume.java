public class PhysicalVolume extends Volume {
    private PhysicalHardDrive hardDrive;
    private VolumeGroups volumeGroup;

    public PhysicalVolume(String name, PhysicalHardDrive hardDrive, VolumeGroups volumeGroup) {
        super(name);
        this.hardDrive = hardDrive;
        this.volumeGroup = volumeGroup;
    }

    public PhysicalHardDrive getHardDrive()
    {
        return hardDrive;
    }

    public void setVolumeGroup(VolumeGroups volumeGroup)
    {
        this.volumeGroup = volumeGroup;
    }

    public VolumeGroups getVolumeGroup()
    {
        return volumeGroup;
    }

    public String getInfo()
    {
        return getName() + ": [" + getHardDrive().getSize() + "] [" + volumeGroup.getName() + "] [" + getUuid() + "]";
    }
}
