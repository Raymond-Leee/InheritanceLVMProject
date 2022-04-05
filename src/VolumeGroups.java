import java.util.ArrayList;

public class VolumeGroups extends Volume {
    ArrayList<PhysicalVolume> PVs;
    ArrayList<LogicalVolumes> LVs;
    private int size;
    private int freeSpace;

    public VolumeGroups(String name)
    {
        super(name);
    }

    public int getSize()
    {
        size = 0;
        for (PhysicalVolume pv : PVs)
        {
            size += Integer.valueOf(pv.getHardDrive().getSize().substring(0, pv.getHardDrive().getSize().indexOf("G")));
        }
        return size;
    }

    public int getFreeSpace()
    {
        freeSpace = 0;
        for (LogicalVolumes lv : LVs)
        {
            freeSpace += Integer.valueOf(lv.getSize().substring(0, lv.getSize().indexOf("G")));
        }
        return getSize() - freeSpace;
    }

    public String toString()
    {
        return getName() + ": total: [" + getSize() + "]" + "available: [" + getFreeSpace() + "] [" + getUuid() + "]";
    }
}
