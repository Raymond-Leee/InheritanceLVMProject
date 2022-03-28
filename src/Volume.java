import java.util.UUID;

public class Volume {
    private String name;
    private String uuid;

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
}
