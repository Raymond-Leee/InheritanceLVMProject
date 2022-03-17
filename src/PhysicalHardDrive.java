public class PhysicalHardDrive {
    private String name;
    private String size;

    public PhysicalHardDrive(String name, String size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public void findInfo() {
        System.out.println(name + " [" + size + "]");
    }
}