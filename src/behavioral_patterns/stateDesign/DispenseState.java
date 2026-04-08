package behavioral_patterns.stateDesign;

import behavioral_patterns.stateDesign.entity.Item;
import behavioral_patterns.stateDesign.entity.VendingMachine;

public class DispenseState extends State {

  public DispenseState(VendingMachine machine, int codeNumber) {
    System.out.println("Currently Vending machine is in DispenseState");
  }

  @Override
  public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
    System.out.println("Product has been dispensed");
    Item item = machine.getInventory().getItem(codeNumber);
    machine.getInventory().updateSoldOutItem(codeNumber);
    machine.getCoinList().clear();
    machine.setVendingMachineState(new IdleState());
    return item;
  }
}
