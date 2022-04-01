import java.util.UUID;
import java.util.ArrayList;

public class Volume {
    private String name;
    private String uuid;
    private static ArrayList<PhysicalHardDrive> PHDs = new ArrayList<PhysicalHardDrive>();
    private static ArrayList<PhysicalVolume> PVs = new ArrayList<PhysicalVolume>();
    private static ArrayList<VolumeGroups> VGs = new ArrayList<VolumeGroups>();
    private static ArrayList<LogicalVolumes> LVs = new ArrayList<LogicalVolumes>();

    public Volume(String name) {
        this.name = name;
        uuid = generateUUID();
    }

    public String generateUUID() {
        UUID u = UUID.randomUUID();
        return u.toString();
    }

    public String getName()
    {
        return name;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public void addPhysicalHardDrive(PhysicalHardDrive phd)
    {
        PHDs.add(phd);
    }

    public void addPhysicalVolume(PhysicalVolume pv)
    {
        PVs.add(pv);
    }

    public void addVolumeGroup(VolumeGroups vg)
    {
        VGs.add(vg);
    }

    public void addLogicalVolume(LogicalVolumes lv)
    {
        LVs.add(lv);
    }

    public void installDrive(String name, String size)
    {
        PhysicalHardDrive phd = new PhysicalHardDrive(name, size);
        addPhysicalHardDrive(phd);
        System.out.println("Drive " + name + " installed");
    }

    public String listDrives()
    {
        String list = "";
        for (PhysicalHardDrive phd : PHDs) {
            list += phd.toString() + "\n";
        }
        return list;
    }

    public boolean hardDriveExists(String fileName)
    {
        for (PhysicalHardDrive p : PHDs)
        {
            if (p.getName().equals(fileName))
            {
                return true;
            }
        }
        return false;
    }
}
