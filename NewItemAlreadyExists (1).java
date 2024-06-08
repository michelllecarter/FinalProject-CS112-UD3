public class NewItemAlreadyExistsException extends Exception {
  NewItem duplicate; 

  public NewItemAlreadyExistsException() {
    super("ERROR! New Item already exists in Item Maitenance queue."); 
  }

  public NewItemAlreadyExistsException(String message, NewItem duplicate){
    super(message + "Duplicate New Item = " + duplicate);
    this.duplicate = duplicate;
  }

  public NewItem getDuplicate(){
    return this.duplicate;
  }
}