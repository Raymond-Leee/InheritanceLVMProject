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
                    System.out.println("Hard drive " + name + " already exists");
                    System.out.println();
                }
            }
            else if (cmd.equalsIgnoreCase("list-drives"))
            {
                System.out.println(runner.listDrives());
            }
            else if (cmd.equalsIgnoreCase("pvcreate"))
            {
                System.out.print("Enter a name: ");
                String pvname = user.next();
                System.out.print("Enter an existing drive: ");
                String drive = user.next();
                if (!runner.physicalVolumeExists(pvname) && runner.hardDriveExists(drive))
                {
                    if (!runner.hardDriveUsed(drive))
                    {
                        runner.pvcreate(pvname, drive);
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Hard drive " + drive + " is associated with another physical volume");
                        System.out.println();
                    }
                }
                else
                {
                    if (runner.physicalVolumeExists(pvname))
                    {
                        System.out.println("Physical volume " + pvname + " already exists");
                        System.out.println();
                    }
                    else if (!runner.hardDriveExists(drive))
                    {
                        System.out.println("Hard drive does not exist");
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Please enter a valid name and drive");
                        System.out.println();
                    }
                }
            }
            else if (cmd.equalsIgnoreCase("pvlist"))
            {
                System.out.println(runner.pvlist());
            }
            else if (cmd.equalsIgnoreCase("vgcreate"))
            {
                System.out.print("Enter a name: ");
                String vgname = user.next();
                System.out.print("Enter a existing physical volume: ");
                String physicalVol = user.next();
                if (!runner.volumeGroupExists(vgname) && runner.physicalVolumeExists(physicalVol))
                {
                    if (!runner.physicalVolumeUsed(physicalVol))
                    {
                        runner.vgcreate(vgname, physicalVol);
                        runner.addPhysicalVolume(runner.getPhysicalVolume(physicalVol));
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Physical volume " + physicalVol + " is associated with another volume group");
                        System.out.println();
                    }
                }
                else
                {
                    if (runner.volumeGroupExists(vgname))
                    {
                        System.out.println("Volume group " + vgname + " already exists");
                        System.out.println();
                    }
                    else if (!runner.physicalVolumeExists(physicalVol))
                    {
                        System.out.println("Physical volume does not exist");
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Please enter a valid name and physical volume");
                        System.out.println();
                    }
                }
            }
            else if (cmd.equalsIgnoreCase("vgextend"))
            {
                System.out.print("Enter the volume group you want to extend: ");
                String vgname = user.next();
                System.out.print("Enter another existing physical volume: ");
                String physicalVol = user.next();
                if (runner.volumeGroupExists(vgname) && runner.physicalVolumeExists(physicalVol))
                {
                    if (!runner.physicalVolumeUsed(physicalVol))
                    {
                        runner.vgextend(vgname, physicalVol);
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Physical volume " + physicalVol + " is associated with another volume group");
                        System.out.println();
                    }
                }
                else
                {
                    if (!runner.volumeGroupExists(vgname))
                    {
                        System.out.println("Volume group does not exist");
                        System.out.println();
                    }
                    else if (!runner.physicalVolumeExists(physicalVol))
                    {
                        System.out.println("Physical volume does not exist");
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Please enter a valid name and physical volume");
                        System.out.println();
                    }
                }
            }
            else if (cmd.equalsIgnoreCase("vglist"))
            {
                System.out.println(runner.vglist());
            }
            else if (cmd.equalsIgnoreCase("lvcreate"))
            {
                System.out.print("Enter a name: ");
                String lvname = user.next();
                System.out.print("Enter a size: ");
                String size = user.next();
                System.out.print("Enter a existing volume group: ");
                String volumeGroup = user.next();
                if (!runner.logicalVolumeExists(lvname) && runner.volumeGroupExists(volumeGroup))
                {
                    runner.lvcreate(lvname, size, volumeGroup);
                    runner.addVolumeGroup(runner.getVolumeGroup(volumeGroup));
                    System.out.println();
                }
                else
                {
                    if (runner.logicalVolumeExists(lvname))
                    {
                        System.out.println("Logical volume " + lvname + " already exists");
                        System.out.println();
                    }
                    if (!runner.volumeGroupExists(volumeGroup))
                    {
                        System.out.println("Volume group does not exist");
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Please enter a valid name and physical volume");
                        System.out.println();
                    }
                }
            }
            else if (cmd.equalsIgnoreCase("lvlist"))
            {
                System.out.println(runner.lvlist());
            }
            else if (cmd.equalsIgnoreCase("exit"))
            {
                System.out.println("Saving data. Goodbye!");
                exit = true;
            }
            else
            {
                System.out.println("Please enter a valid command.");
                System.out.println();
            }
        }
    }
}
