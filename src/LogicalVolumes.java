public class LogicalVolumes extends Volume {
    private int size;
    VolumeGroups volumeGroup;

    public LogicalVolumes (String name, int size, VolumeGroups volumeGroup) {
        super(name);
        this.size = size;
        this.volumeGroup = volumeGroup;
    }
}
