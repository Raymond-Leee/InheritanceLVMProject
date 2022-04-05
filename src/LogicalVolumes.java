public class LogicalVolumes extends Volume {
    private String size;
    private VolumeGroups volumeGroup;

    public LogicalVolumes (String name, String size, String volumeGroupName) {
        super(name);
        this.size = size;
        this.volumeGroup = volumeGroup;
    }

    public void setVolumeGroup(VolumeGroups volumeGroup)
    {
        this.volumeGroup = volumeGroup;
    }

    public void setSize(String size)
    {
        this.size = size;
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
        return getName() + ": [" + size + "] [" + volumeGroup.getName() + "] [" + getUuid() + "]";
    }
}
