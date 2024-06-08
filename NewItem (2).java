import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* UML CLASS DIAGRAM:
-----------------------------------------
NewItem
-----------------------------------------
- itemName : String
- brandName : String
- imageName : String
- distributorName : String
- categoryName : String
- subCategoryName : String
- itemNum : int
-----------------------------------------
+ NewItem(itemName : String, imageName : String, itemNum : int)
+ NewItem(original : NewItem)
+ setAll(itemName : String, imageName : String, itemNum : int)
+ getItemName() : String
+ setItemName(itemName : String) : void
+ getBrandName() : String
+ setBrandName(brandName : String) : void
+ getImageName() : String
+ getImage() : Image
+ setImageName(imageName : String) : void
+ getDistributorName() : String
+ setDistributorName(distributorName : String) : void
+ setCategoryName(categoryName : String) : void
+ setSbCategoryName(subCategoryName : String) : void
+ getItemNum() : int
+ setItemNum(itemNum : int) : void
+ toString() : String
-----------------------------------------
*/

public class NewItem
{
        // INSTANCE VARIABLES
        private String itemName = "";
        private String brandName = "";
        private String imageName = "";
        private String distributorName = "";
        private String categoryName = "";
        private String subCategoryName = "";
        private int itemNum = 0;

        //Constructor
        public NewItem(String itemName, String brandName, String imageName, String distributorName, String categoryName, String subCategoryName, int itemNum){
                this.setAll(itemName, brandName, imageName, distributorName, categoryName, subCategoryName, itemNum);
        }

        //Copy constructor with error checking for null values
        public NewItem(NewItem original){
                if (original != null)
                {
                        this.setAll(original.itemName, original.brandName, original.imageName, original.distributorName, original.categoryName, original.subCategoryName, original.itemNum);
                }else{
                        System.out.println("ERROR: trying to copy NULL object. Exiting program...");
                        System.exit(1);
                }
        }

        //default constructor creates false New Item
        public NewItem() {
                this("New Item Logo", "Oat Milk", "Oatly.jpg", "SUPERV", "Alternative Milk", "Oat Milk", 0);
        }

        // GETTERS/SETTERS
        public void setAll(String itemName, String brandName, String imageName, String distributorName, String categoryName, String subCategoryName, int itemNum){
                this.setItemName(itemName);
                this.setBrandName(brandName);
                this.setImageName(imageName);
                this.setDistributorName(distributorName);
                this.setCategoryName(categoryName);
                this.setSubCategoryName(subCategoryName);
                this.setItemNum(itemNum);
        }

        public String getItemName()
        {
                return this.itemName;
        }
        public String getBrandName()
        {
                return this.brandName;
        }
        public String getDistributorName()
        {
                return this.distributorName;
        }
        public void setItemName(String itemName)
        {
                this.itemName = itemName;
        }
        public void setBrandName(String brandName)
        {
                this.brandName = brandName;
        }
        public void setDistributorName(String distributorName)
        {
                this.distributorName = distributorName;
        }
        public void setCategoryName(String categoryName)
        {
                this.categoryName = categoryName;
        }
        public void setSubCategoryName(String subCategoryName)
        {
                this.subCategoryName = subCategoryName;
        }
        public String getImageName()
        {
                return this.imageName;
        }
        public String getCategoryName()
        {
                return this.categoryName;
        }
        public String getSubCategoryName()
        {
                return this.subCategoryName;
        }
        /**
         * Gets Image object for this item by reading it from the appropriate location in a replit project
         *
         * @return returns Image object that can be used to display it in an ImageView in GUI
         **/
        public Image getImage() {
                FileInputStream input = null;
                try {
                        input = new FileInputStream("./resources/" + this.imageName);
                } catch (FileNotFoundException e) {
                        //e.printStackTrace();
                        System.err.println("ERROR: could not open New item image file.");
                        System.exit(0);
                }
                return new Image(input);
        }

        public void setImageName(String imageName)
        {
                this.imageName = imageName;
        }
        public int getItemNum()
        {
                return itemNum;
        }
        public void setItemNum(int itemNum)
        {
                this.itemNum = itemNum;
        }
        //toString method
        @Override
        public String toString()
        {
                return "NewItem #" + this.itemNum + ": " + this.itemName + ": " + this.brandName + this.distributorName + this.categoryName + this.subCategoryName + "(" + this.imageName + ")";
        }

        //Equals method
        @Override
        public boolean equals(Object o)
        {
                if(o == null || !(o instanceof NewItem))
                {
                        return false;
                }
                NewItem other = (NewItem) o;

                return this.itemName.equals(other.itemName) && this.brandName.equals(other.brandName) && this.distributorName == other.distributorName && this.itemNum == other.itemNum && this.categoryName.equals(other.categoryName) && this.subCategoryName.equals(other.subCategoryName) && this.imageName.equals(other.imageName);
        }
}
