import java.util.ArrayList;

public class VolumeGroups extends Volume {
    ArrayList<String> PVs;
    ArrayList<String> LVs;
    private int size;
    private int freeSpace;

    public VolumeGroups(String name, ArrayList<String> PVs, ArrayList<String> LVs) {
        super(name);
        this.PVs = PVs;
        this.LVs = LVs;
    }


}
