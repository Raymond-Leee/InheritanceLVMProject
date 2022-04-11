import java.util.ArrayList;

public class VolumeGroups extends Volume {
    ArrayList<PhysicalVolume> physicalVolumes = new ArrayList<PhysicalVolume>();
    ArrayList<LogicalVolumes> logicalVolumes = new ArrayList<LogicalVolumes>();
    private int size;
    private int freeSpace;

    public VolumeGroups(String name)
    {
        super(name);
    }

    public void addPVtoVG(PhysicalVolume PV)
    {
        physicalVolumes.add(PV);
    }

    public void addLVtoVG(LogicalVolumes LV)
    {
        logicalVolumes.add(LV);
    }

    public int getSize()
    {
        size = 0;
        for (PhysicalVolume pv : physicalVolumes)
        {
            size += Integer.valueOf(pv.getHardDrive().getSize().substring(0, pv.getHardDrive().getSize().indexOf("G")));
        }
        return size;
    }

    public int getFreeSpace()
    {
        freeSpace = 0;
        for (LogicalVolumes lv : logicalVolumes)
        {
            freeSpace += Integer.valueOf(lv.getSize().substring(0, lv.getSize().indexOf("G")));
        }
        return getSize() - freeSpace;
    }

    public String toString()
    {
        String str = getName() + ": total: [" + getSize() + "]" + " available: [" + getFreeSpace() + "] [";
        if (physicalVolumes.size() > 0)
        {
            for (int i = 0; i < physicalVolumes.size() - 1; i++)
            {
                str += physicalVolumes.get(i).getName() + ", ";
            }
            str += physicalVolumes.get(physicalVolumes.size() - 1).getName();
        }
        str += "] [" + getUuid() + "]";
        return str;
    }
}
