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
                runner.pvcreate(pvname, drive);
                System.out.println();
            }
            if (cmd.equalsIgnoreCase("pvlist"))
            {
                System.out.println(runner.pvlist());
            }
            if (cmd.equalsIgnoreCase("vgcreate"))
            {
                System.out.print("Enter a name: ");
                String vgname = user.next();
                runner.vgcreate(vgname);
                System.out.println();
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
                System.out.println(runner.vglist());
            }
            if (cmd.equalsIgnoreCase("lvcreate"))
            {

            }
            if (cmd.equalsIgnoreCase("lvlist"))
            {
                System.out.println(runner.lvlist());
            }
            if (cmd.equalsIgnoreCase("exit"))
            {
                System.out.println("Saving data. Goodbye!");
                exit = true;
            }
        }
    }
}
