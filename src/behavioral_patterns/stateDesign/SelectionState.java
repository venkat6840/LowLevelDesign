package behavioral_patterns.stateDesign;

import behavioral_patterns.stateDesign.entity.Item;
import behavioral_patterns.stateDesign.entity.VendingMachine;

public class SelectionState extends State {

  public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
    // 1. get item of this codeNumber
    Item item = machine.getInventory().getItem(codeNumber);

    int total = machine.getCoinList().stream().mapToInt(coin -> coin.value).sum();

    if (total < item.getPrice()) {
      System.out.println(
          "Insufficient Amount, Product you selected is for price: "
              + item.getPrice()
              + " and you paid: "
              + total);
      refundFullMoney(machine);
      throw new Exception("insufficient amount");
    } else {
      machine.setVendingMachineState(new DispenseState(machine, codeNumber));
      getChange(total - item.getPrice());
    }
  }

  @Override
  public int getChange(int returnExtraMoney) throws Exception {
    // actual logic should be to return COINs in the dispense tray, but for simplicity i am just
    // returning the amount to be refunded
    System.out.println("Returned the change in the Coin Dispense Tray: " + returnExtraMoney);
    return returnExtraMoney;
  }

  public void refundFullMoney(VendingMachine machine) throws Exception {
    machine.getCoinList().clear();
    System.out.println("Returned the full amount back in the Coin Dispense Tray");
    machine.setVendingMachineState(new IdleState());
  }
}
