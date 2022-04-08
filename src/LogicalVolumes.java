public class LogicalVolumes extends Volume {
    private String size;
    private VolumeGroups volumeGroup;

    public LogicalVolumes (String name, String size, String volumeGroupName) {
        super(name);
        this.size = size;
        this.volumeGroup = getVolumeGroup(volumeGroupName);
    }

    public VolumeGroups getVolumeGroup()
    {
        return volumeGroup;
    }

    public String getSize()
    {
        return size;
    }

    public String toString()
    {
        String str = getName() + ": [" + size + "] [" + volumeGroup.getName() + "] [" + getUuid() + "]";
        return str;
    }
}
