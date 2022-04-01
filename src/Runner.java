import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Volume runner = new Volume("Volume");
        Scanner user = new Scanner(System.in);
        boolean exit = false;
        System.out.println("Welcome to the LVM system! Enter your commands:");
        while (!exit)
        {
            System.out.print("cmd# ");
            String cmd = user.next();
            if (cmd.equalsIgnoreCase("install-drive"))
            {
                System.out.print("Enter a name: ");
                String name = user.next();
                System.out.print("Enter size: ");
                String size = user.next();
                if (!runner.hardDriveExists(name))
                {
                    runner.installDrive(name, size);
                    System.out.println();
                }
                else
                {
                    System.out.println("Drive " + name + " already exists");
                    System.out.println();
                }
            }
            if (cmd.equalsIgnoreCase("list-drives"))
            {
                System.out.println(runner.listDrives());
            }
            if (cmd.equalsIgnoreCase("pvcreate"))
            {
                System.out.print("Enter a name: ");
                String pvname = user.next();
                System.out.print("Enter an existing drive: ");
                String drive = user.next();
            }
            if (cmd.equalsIgnoreCase("pvlist"))
            {

            }
            if (cmd.equalsIgnoreCase("vgcreate"))
            {
                System.out.print("Enter a name: ");
                String vgname = user.next();
                System.out.print("Enter an existing physical volume: ");
                String pv = user.next();
            }
            if (cmd.equalsIgnoreCase("vgextend"))
            {
                System.out.print("Enter a name: ");
                String vgname = user.next();
                System.out.print("Enter an existing physical volume: ");
                String pv = user.next();
            }
            if (cmd.equalsIgnoreCase("vglist"))
            {

            }
            if (cmd.equalsIgnoreCase("lvcreate"))
            {
                System.out.print("Enter a name: ");
                String lvname = user.next();
                System.out.print("Enter size: ");
                String lvsize = user.next();
                System.out.print("Enter an existing volume group: ");
                String vg = user.next();
            }
            if (cmd.equalsIgnoreCase("lvlist"))
            {

            }
            if (cmd.equalsIgnoreCase("exit"))
            {
                System.out.println("Saving data. Goodbye!");
                exit = true;
            }
        }
    }
}
