import java.util.ArrayList;

public class VolumeGroups extends Volume {
    ArrayList<PhysicalVolume> PVs;
    ArrayList<LogicalVolumes> LVs;
    private int size;
    private int freeSpace;

    public VolumeGroups(String name, ArrayList<PhysicalVolume> PVs, ArrayList<LogicalVolumes> LVs) {
        super(name);
        this.PVs = PVs;
        this.LVs = LVs;
    }

    public int getSize()
    {
        size = 0;
        for (int i = 0; i < PVs.size(); i++)
        {
            size += Integer.valueOf(PVs.get(i).getHardDrive().getSize().substring(0, PVs.get(i).getHardDrive().getSize().indexOf("G")));
        }
        return size;
    }

    public int getFreeSpace()
    {
        freeSpace = 0;
        for (int i = 0; i < LVs.size(); i++)
        {
            freeSpace += ;
        }
        return freeSpace;
    }

    public String toString()
    {
        return getName() + ": total: [" + getSize() + "]" + "available: [" + getFreeSpace() + "] [" + getUuid() + "]";
    }
}
