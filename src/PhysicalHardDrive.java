public class PhysicalHardDrive {
    private String name;
    private String size;
    private PhysicalVolume physicalVolume;

    public PhysicalHardDrive(String name, String size) {
        this.name = name;
        this.size = size;
    }

    public void setPhysicalVolume(PhysicalVolume associatedPV)
    {
        physicalVolume = associatedPV;
    }

    public String getName()
    {
        return name;
    }

    public String getSize()
    {
        return size;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public String toString()
    {
        String str = name + " [" + size + "]";
        return str;
    }
}