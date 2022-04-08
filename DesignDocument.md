# InheritanceLVMProject
Volume Class
Variables
  String name > Stores the general name for Physical Volume, Volume Group and Logical Volume
  String uuid > Stores the general uuid for Physical Volume, Volume Group and Logical Volume

PhysicalHardDrive Class
Variables
  String name > Stores the name for each created physical hard drive
  String size > Stores the size for each created physical hard drive in gigabytes
  PhysicalVolume physicalVolume > Stores the physicalVolume that the hard drive is associated with (If applicable)

Constructor
  PhysicalHardDrive > Takes in a String name and String size to declare the name and size variables
  PhysicalVolume > Takes in a String name and PhysicalHardDrive hardDrive; calls super(name) from the Volume class and declares hardDrive as the input
  
 Methods
  void setPhysicalVolume > Takes in a physical volume and associates the hard drive with said physical volume
  String getName > Returns name
  String getSize > Returns size
  String toString > Returns name + "[" + size + "]"
  
PhysicalVolume Class
Variables
  PhysicalHardDrive hardDrive > Stores the hardDrive that the physical volume is associated with (If applicable)
  VolumeGroups volumeGroup > Stores the volumeGroup that the physical volume is associated with (If applicable)

Constructor
  PhysicalVolume > Takes in a String name and PhysicalHardDrive hardDrive; calls super(name) from the Volume class and declares hardDrive as the input
  
 Methods
  void setVolumeGroup > Takes in a volume group and associates the physical volume with said volume group
  VolumeGroup getVolumeGroup > Returns volumeGroup
  PhysicalHardDrive getHardDrive > Returns hardDrive
  String toString > Returns getName() + ": [" + getHardDrive().getSize() + "] " + "[" + getUuid() + "]"
