package behavioral_patterns.stateDesign;

import behavioral_patterns.stateDesign.entity.Item;
import behavioral_patterns.stateDesign.entity.ItemShelf;

public class Inventory {

  ItemShelf[] inventory;

  public Inventory(int size) {
    inventory = new ItemShelf[size];
    initialEmptyInventory();
  }

  public ItemShelf[] getInventory() {
    return inventory;
  }

  // Initiate empty inventory
  public void initialEmptyInventory() {
    int state = 101;
    for (int i = 0; i < inventory.length; i++) {
      ItemShelf space = new ItemShelf();
      space.setCode(state);
      space.setSoldOut(true);
      inventory[i] = space;
      state++;
    }
  }

  public void addInventory(Item item, int num) {
    for (ItemShelf itemShelf : inventory) {
      if (itemShelf.getCode() == num) {
        itemShelf.setItem(item);
        itemShelf.setSoldOut(false);
      } else {
        System.out.println("already item is present, you can not add item here");
      }
    }
  }

  public Item getItem(int codeNumber) throws Exception {
    for (ItemShelf itemShelf : inventory) {
      if (itemShelf.getCode() == codeNumber) {
        if (itemShelf.isSoldOut()) {
          throw new Exception("item already sold out");
        } else {
          return itemShelf.getItem();
        }
      }
    }
    return null;
  }

  public void updateSoldOutItem(int codeNumber) {
    for (ItemShelf itemShelf : inventory) {
      if (itemShelf.getCode() == codeNumber) {
        itemShelf.setSoldOut(true);
      }
    }
  }
}
