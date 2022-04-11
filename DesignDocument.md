# InheritanceLVMProject
Volume Class

Variables
  - String name > Stores the general name for Physical Volume, Volume Group and Logical Volume
  - String uuid > Stores the general uuid for Physical Volume, Volume Group and Logical Volume
  - ArrayList PhysicalHardDrive > A list containing all physical hard drives
  - ArrayList PhysicalVolume > A list containing all physical volumes
  - ArrayList VolumeGroups > A list containing all volume groups
  - ArrayList LogicalVolumes > A list containing all logical volumes
  
 Constructor
  - Volume > Takes in a String name and generatates a random UUID
  
 Methods
  - String generateUUID > Generates a random UUID
  - String getName > Returns name
  - String getUuid > Returns UUID
  - PhysicalHardDrive getPhysicalHardDrive > Takes in a physical hard drive name and returns the hard drive if the name matches any hard drives within the list; else returns null
  - VolumeGroups getVolumeGroups > Takes in a volume group name and returns the volume group if the name matches any volume groups within the list; else returns null
  - PhysicalVolume getPhysicalVolume > Takes in a volume group name and returns the volume group if the name matches any volume groups within the list; else returns null
  - void addPhysicalHardDrive > Takes in a physical hard drive and adds it to the respective array list
  - void addPhysicalVolume > Takes in a physical volume and adds it to the respective array list
  - void addVolumeGroup > Takes in a volume group and adds it to the respective array list
  - void addLogicalVolume > Takes in a logical volume and adds it to the respective array list
  - void installDrive > Takes in a name and size and creates a physical hard drive
  - void pvcreate > Takes in a name and physical hard drive and creates a physical volume
  - void vgcreate > Takes in a name and physical volume and creates a volume group
  - void vgextend > Takes in a existing volume group and another physical volume and adds the physical volume to the voluem group
  - void lvcreate > Takes in a name, size, and volume group and creates a logical volume if enough space exists in the chosen volume group
  - String listDrives > Returns a list of all existing hard drives
  - String pvlist > Returns a list of all existing physical volumes
  - String vglist > Returns a list of all existing volume groups
  - String lvlist > Returns a list of all existing logical volumes
  - boolean hardDriveExists > Returns true or false depending on whether a physical hard drive exists already
  - boolean hardDriveUsed > Returns true or false depending on whether a physical hard drives is associated with a physical volume already
  - boolean physicalVolumeExists > Returns true or false depending on whether a physical volume exists already
  - boolean physicalVolumeUsed > Returns true or false depending on whether a physical volume is associated with a volume group already
  - boolean volumeGroupExists > Returns true or false depending on whether a volume group exists already
  - boolean logicalVolumeExists > Returns true or false depending on whether a logical volume exists already
  

PhysicalHardDrive Class

Variables
  - String name > Stores the name for each created physical hard drive
  - String size > Stores the size for each created physical hard drive in gigabytes
  - PhysicalVolume physicalVolume > Stores the physicalVolume that the hard drive is associated with (If applicable)

Constructor
  - PhysicalHardDrive > Takes in a String name and String size to declare the name and size variables
  - PhysicalVolume > Takes in a String name and PhysicalHardDrive hardDrive; calls super(name) from the Volume class and declares hardDrive as the input
  
 Methods
  - void setPhysicalVolume > Takes in a physical volume and associates the hard drive with said physical volume
  - String getName > Returns name
  - String getSize > Returns size
  - String toString > Returns the name and size of the hard drive
  
  
PhysicalVolume Class extends Volume Class

Variables
  - PhysicalHardDrive hardDrive > Stores the hardDrive that the physical volume is associated with (If applicable)
  - VolumeGroups volumeGroup > Stores the volumeGroup that the physical volume is associated with (If applicable)

Constructor
  - PhysicalVolume > Takes in a String name and PhysicalHardDrive hardDrive; calls super(name) from the Volume class and declares hardDrive as the input
  
 Methods
  - void setVolumeGroup > Takes in a volume group and associates the physical volume with said volume group
  - VolumeGroup getVolumeGroup > Returns volumeGroup
  - PhysicalHardDrive getHardDrive > Returns hardDrive
  - String toString > Returns the name, size, and UUID of the physical volume


VolumeGroup Class extends Volume Class

Variables
  - ArrayList physicalVolumes > A list containing all physicalVolumes in the volume group
  - ArrayList logicalVolumes > A list containing all logicalVolumes in the volume group
  - int size > Used to display the total size in the volume group
  - int freeSpace > Used to display the amount of space left in the volume group
  
 Constructor
  - VolumeGroup > Takes in a String name for the volume group

 Methods
  - void addPVtoVG > Adds a physical volume to the volume group
  - void addLVtoVG > Adds a logical volume to the volume group
  - int getSize > Returns the total size of the volume group
  - int getFreeSpace > Returns the amount of space left in a the volume group
  - String toString > Returns the name, total size, remaining space, associated physical volume(s), and UUID of the volume group
  
 
 LogicalVolume Class extends Volume Class
 
 Variables
  - String size > Stores the size of the logical volume
  - VolumeGroups volumeGroup > Stores the volumeGroup the logical volume is associated with
  
 Constructor
  - LogicalVolume > Calls super(name) from the Volume class; Takes in a String size and calls getVolumeGroup to declare the size and volumeGroup
  
 Methods
  - String getSize > Returns the size of the logical volume
  - String toString > Returns the name, size, associated volume group, and UUID of the logical volume
  
  
 Runner Class
  1) Welcomes the user to the LVM menu
  2) Asks for a cmd; User can enter install-drive, list-drives, pvcreate, pvlist, vgcreate, vgextend, vglist, lvcreate, lvlist, exit; exit will stop the program
  3) install-drive will create a physical hard drive assuming all conditions are met
  4) pvcreate will create a physical volume assuming all conditions are met
  5) vgcreate will create a volume group assuming all condtions are met
  6) vgextend will add another physical volume to an existing volume group assuming all condtions are met
  7) lvcreate will create a logical volume assuming all conditions are met
  8) List commands will list their respective property (list-drives lists all physical hard drives, pvlist lists all physical volumes, vglist lists all volume groups, lvlist lists all logical volumes)
