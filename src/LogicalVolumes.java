public class LogicalVolumes extends Volume {
    private String size;
    private VolumeGroups volumeGroup;

    public LogicalVolumes (String name, String size, VolumeGroups volumeGroup) {
        super(name);
        this.volumeGroup = volumeGroup;
    }

    public void setVolumeGroup(VolumeGroups volumeGroup)
    {
        this.volumeGroup = volumeGroup;
    }

    public VolumeGroups getVolumeGroup()
    {
        return volumeGroup;
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public String toString()
    {
        return getName() + ": [" + size + "] [" + volumeGroup.getName() + "] [" + getUuid() + "]";
    }
}
