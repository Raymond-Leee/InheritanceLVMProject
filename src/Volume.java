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

    public PhysicalHardDrive getPhysicalHardDrive(String physicalHardDriveName)
    {
        for (PhysicalHardDrive phd : PHDs)
        {
            if (phd.getName().equals(physicalHardDriveName))
            {
                return phd;
            }
        }
        return null;
    }

    public VolumeGroups getVolumeGroup(String volumeGroupName)
    {
        for (VolumeGroups vg : VGs)
        {
            if (vg.getName().equals(volumeGroupName))
            {
                return vg;
            }
        }
        return null;
    }

    public PhysicalVolume getPhysicalVolume(String physicalVolumeName)
    {
        for (PhysicalVolume pv : PVs)
        {
            if (pv.getName().equals(physicalVolumeName))
            {
                return pv;
            }
        }
        return null;
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

    public void pvcreate(String name, String physicalHardDriveName)
    {
        PhysicalVolume pv = new PhysicalVolume(name, physicalHardDriveName);
        addPhysicalVolume(pv);
        getPhysicalHardDrive(physicalHardDriveName).setPhysicalVolume(pv);
        System.out.println(name + " created");
    }

    public void vgcreate(String name, String physicalVolumeName)
    {
        VolumeGroups vg = new VolumeGroups(name);
        addVolumeGroup(vg);
        getPhysicalVolume(physicalVolumeName).setVolumeGroup(vg);
        System.out.println(name + " created");
    }

    public String listDrives()
    {
        String list = "";
        for (PhysicalHardDrive phd : PHDs)
        {
            list += phd.toString() + "\n";
        }
        return list;
    }

    public String pvlist()
    {
        String list = "";
        for (PhysicalVolume pv : PVs)
        {
            list += pv.toString() + "\n";
        }
        return list;
    }

    public String vglist()
    {
        String list = "";
        for (VolumeGroups vg : VGs)
        {
            list += vg.toString() + "\n";
        }
        return list;
    }

    public String lvlist()
    {
        String list = "";
        for (LogicalVolumes lv : LVs)
        {
            list += lv.toString() + "\n";
        }
        return list;
    }

    public boolean hardDriveExists(String drive)
    {
        for (PhysicalHardDrive phd : PHDs)
        {
            if (phd.getName().equals(drive))
            {
                return true;
            }
        }
        return false;
    }

    public boolean hardDriveNotExists(String drive)
    {
        for (PhysicalHardDrive phd : PHDs)
        {
            if (phd.getName().equals(drive))
            {
                return false;
            }
        }
        return true;
    }

    public boolean hardDriveUsed(String drive)
    {
        for (PhysicalVolume pv : PVs)
        {
            if (pv.getHardDrive().getName().equals(drive))
            {
                return true;
            }
        }
        return false;
    }

    public boolean physicalVolumeExists(String physicalVol)
    {
        for (PhysicalVolume pv : PVs)
        {
            if (pv.getName().equals(physicalVol))
            {
                return true;
            }
        }
        return false;
    }

    public boolean physicalVolumeNotExists(String physicalVol)
    {
        for (PhysicalVolume pv : PVs)
        {
            if (pv.getName().equals(physicalVol))
            {
                return false;
            }
        }
        return true;
    }

    public boolean volumeGroupExists(String volumeGroup)
    {
        for (VolumeGroups vg : VGs)
        {
            if (vg.getName().equals(volumeGroup))
            {
                return true;
            }
        }
        return false;
    }
}
