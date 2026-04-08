package behavioral_patterns.stateDesign;

import behavioral_patterns.stateDesign.entity.VendingMachine;
import behavioral_patterns.stateDesign.enums.Coin;

public class HasMoneyState extends State {
  public HasMoneyState() {
    System.out.println("Currently Vending machine is in HasMoneyState");
  }

  @Override
  public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
    System.out.println("Accepted the coin");
    machine.getCoinList().add(coin);
  }

  public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
    machine.setVendingMachineState(new SelectionState());
  }

  public void refundFullMoney(VendingMachine machine) throws Exception {
    machine.getCoinList().clear();
    System.out.println("Returned the full amount back in the Coin Dispense Tray");
    machine.setVendingMachineState(new IdleState());
  }
}
