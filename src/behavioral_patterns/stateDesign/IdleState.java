package behavioral_patterns.stateDesign;

import behavioral_patterns.stateDesign.entity.Item;
import behavioral_patterns.stateDesign.entity.VendingMachine;

public class IdleState extends State {

  public IdleState() {
    System.out.println("Currently Vending machine is in IdleState");
  }

  public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
    machine.setVendingMachineState(new HasMoneyState());
  }

  public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
    machine.getInventory().addInventory(item, codeNumber);
  }
}
