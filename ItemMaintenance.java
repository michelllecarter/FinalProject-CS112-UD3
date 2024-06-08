/**
 * ItemMaintenance.java : Represents the base class which Newitem.java and ItemPromotion.java are derived from 
 * shared data used for both types of maintenance
 * setting upc, itemDescription, distributorNumber, vendorCase, vendorProductNumber, caseCost, retail 
 *
 * @author Michelle Carter
*/
public class ItemMaintenance
{
  //CONSTANT VARIABLES 
    public static final String DEFAULT_ITEM_DESCRIPTION = "Kettle Gochujang Potato Chips";  
    public static final int DEFAULT_UPC = 216357809;
    public static final int DEFAULT_VENDOR_CASE = 12;
    public static final int DEFAULT_VENDOR_PRODUCT_NUMBER = 21569;
    public static final double DEFAULT_CASE_COST = 39.21;
    public static final double DEFAULT_RETAIL = 5.49;
    public static final String DEFAULT_IMAGE_NAME = "kettle_gochujang_potato_chips.jpg";
    public static final int DEFAULT_ITEM_NUM = 0; 

  //INSTANCE VARIABLES
    private String itemDescription;
    private int upc;
    private int vendorCase;
    private int vendorProductNumber;
    private double caseCost;
    private double retail;
    private String imageName;
    private int itemNum;

  //CONSTRUCTORS 
  /**
  * Full constructor with error handling (shuts down on invalid data)
  *
  * @param upc (single item upc not the case upc) 9 digits excluding checkstand digit
  * @param itemDescription (single item description) based on upc
  * @param distributorNumber linked to distributor name and ID 
  * @param vendorCase amount of product that comes in one case
  * @param vendorProductNumber, number assigned to upc by distributor
  * @param caseCost, cost of the case (not individual product)
  * @param retail, in store retail based on caseCost and vendorCase (upcharged)
  */
    public ItemMaintenance(String itemDescription, int upc, int vendorCase, int vendorProductNumber, double caseCost, double retail, String imageName, int itemNum) {
        if(!this.setAll(itemDescription, upc, vendorCase, vendorProductNumber, caseCost, retail, imageName, itemNum)){
          System.out.println("ERROR: Bad data given to full ItemMaintenance constructor");
          System.exit(0);
        }
    }

/**
* Default constructor using constant variable default values 
*/
  public ItemMaintenance(){
    this(DEFAULT_ITEM_DESCRIPTION, DEFAULT_UPC, DEFAULT_VENDOR_CASE, DEFAULT_VENDOR_PRODUCT_NUMBER, DEFAULT_CASE_COST, DEFAULT_RETAIL, DEFAULT_IMAGE_NAME, DEFAULT_ITEM_NUM);
  }

  /**
  * Copy constructor created deep copy of all instance variables
  */
  public ItemMaintenance(ItemMaintenance original){
    if(original != null){
        this.setAll(original.itemDescription, original.upc, original.vendorCase, original.vendorProductNumber, original.caseCost, original.retail, original.imageName, original.itemNum);
    } else{
      System.out.println("ERROR: null data given to copy ItemMaintenance constructor");
      System.exit(0);
    }
  }

//SETTER/MUTATORS

  /**
    * Set item description with error checking
    *
    * @param itemDescription (single item description) based on upc
    *
    * @return boolean true if a valid String (not null and not empty), false otherwise 
    */

    public boolean setItemDescription(String itemDescription) {
        if(itemDescription != null && itemDescription.length() > 0){
          this.itemDescription = itemDescription;
          return true;
        }else{
          return false;
        }
    }

  /**
  * set upc on product to scan through checkstands for sale w error checking
  *
  * @param upc (single item upc not the case upc) 9 digits excluding checkstand digit
  *
  * @return boolean true if valid (>= 0), false otherwise 
  */

  public boolean setUpc(int upc) {
    if(upc >= 0){
      this.upc = upc;
      return true; 
    }  else{
      return false;
    }
  }

  /**
  * Set correct vendor case  with error checking
  *
  * @param vendorCase amount of product that comes in one case
  *
  * @return boolean true if valid (>= 0), false otherwise 
  */

  public boolean setVendorCase(int vendorCase) {
    if(vendorCase >= 0){
      this.vendorCase = vendorCase;
      return true; 
    }  else{
      return false;
    }
  }

  /**
  * Set vendor product number, assigned by vendor with error checking
  *
  * @param vendorProductNumber, number assigned to upc by distributor
  *
  * @return boolean true if valid (>= 0), false otherwise 
  */

  public boolean setVendorProductNumber(int vendorProductNumber) {
    if(vendorProductNumber >= 0){
      this.vendorProductNumber = vendorProductNumber;
      return true; 
    }  else{
      return false;
    }
  }

/** 
  * Set case cost based on distributor info w error checking
  *
  * @param caseCost, cost of the case (not individual product)
  *
  * @return boolean true if valid (>= 0), false otherwise
*/

  public boolean setCaseCost(double caseCost) {
    if(caseCost >= 0){
      this.caseCost = caseCost;
      return true;
    }  else{
      return false;
    }
  }

  /** 
    * Set retail based on info with error checking
    *
    * @param retail, in store retail based on caseCost and vendorCase (upcharged)
    *
    * @return boolean true if valid (>= 0), false otherwise
  */

    public boolean setRetail(double retail) {
      if(retail >= 0){
        this.retail = retail;
        return true;
      }  else{
        return false;
      }
    }
  /** 
    * Set retail based on info with error checking
    *
    * @param retail, in store retail based on caseCost and vendorCase (upcharged)
    *
    * @return boolean true if valid (>= 0), false otherwise
  */

    public boolean setImageName(String imageName) {
      if(imageName != null && imageName.length() > 0){
        this.imageName = imageName;
        return true;
      }else{
        return false;
        
  /** 
    * Set retail based on info with error checking
    *
    * @param retail, in store retail based on caseCost and vendorCase (upcharged)
    *
    * @return boolean true if valid (>= 0), false otherwise
  */

    public boolean setItemNum(int itemNum) {
      if(itemNum >= 0){
        this.itemNum = itemNum;
        return true;
      }  else{
        return false;
      }
    }
  /**
   * Sets all valid instance variables
   *
  * @param upc (single item upc not the case upc) 12 digits excluding checkstand digit
  * @param itemDescription (single item description) based on upc
  * @param distributorNumber linked to distributor name and ID 
  * @param vendorCase amount of product that comes in one case
  * @param vendorProductNumber, number assigned to upc by distributor
  * @param caseCost, cost of the case (not individual product)
  * @param retail, in store retail based on caseCost and vendorCase (upcharged)
   *
   * @return boolean if all three parameters are valid 
  */
    public boolean setAll(String itemDescription, int upc, int vendorCase, int vendorProductNumber, double casecost, double retail, String imageName, int itemNum){
      return this.setItemDescription(itemDescription) && this.setUpc(upc) && this.setVendorCase(vendorCase) && this.setVendorProductNumber(vendorProductNumber) && this.setCaseCost(caseCost) && this.setRetail(retail);
    }

//GETTERS//ACCESORS
  /** 
  * Gets item description
  *
  * @return itemDescription (single item description) based on upc
  */
    public String getItemDescription() {
        return this.itemDescription;
    }
  /** 
  * Gets upc number
  *
  * @return upc (single item upc not the case upc) 12 digits excluding checkstand digit
  */
    public int getUpc() {
        return this.upc;
    }
  /** 
  * Gets provided case quantity
  *
  * @return vendorCase amount of product that comes in one case
  */
    public int getVendorCase() {
        return this.vendorCase;
    }
  /** 
  * Gets product number assigned to upc by distributor
  *
  * @return vendorProductNumber, number assigned to upc by distributor
  */
    public int getVendorProductNumber() {
        return this.vendorProductNumber;
    }
  /** 
  * Gets case cost of vendor case (not unit)
  *
  * @return caseCost, cost of the case (not individual product)
  */
    public double getCaseCost() {
        return this.caseCost;
    }
  /** 
  * Gets retail 
  *
  * @return retail, in store retail based on caseCost and vendorCase (upcharged)
  */
    public double getRetail() {
        return this.retail;
    }
  /** 
  * Gets retail 
  *
  * @return retail, in store retail based on caseCost and vendorCase (upcharged)
  */
    public String getImageName() {
        return this.imageName;
    }
  /** 
  * Gets retail 
  *
  * @return retail, in store retail based on caseCost and vendorCase (upcharged)
  */
    public int getItemNum() {
        return this.itemNum;
    }
}
