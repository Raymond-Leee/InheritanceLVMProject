import java.util.UUID;

public class Volume {
    private String name;
    private String uuid;

    public Volume(String name) {
        this.name = name;
        UUID u = UUID.randomUUID();
        uuid = u.toString();
    }
}
