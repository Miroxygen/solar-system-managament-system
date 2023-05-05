package model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;


/**
 * A list of contracts.
 */
public class ContractList {
  private ArrayList<Contract.MutableContract> contracts;

  public ContractList(ContractList contractList) {
    this.contracts = contractList.contracts;
  }

  public ContractList() {
    contracts = new ArrayList<Contract.MutableContract>(); 
  }

  /**
   * Adds a contract.
   *
   * @param c A contract.
   */
  public void addContract(Contract c) {
    contracts.add(new Contract.MutableContract(c));
  }

  /**
   * Removes a contract. 
   *
   * @param c A contract.
   */
  public void deleteContract(Contract.MutableContract c) {
    contracts.remove(c);
  }

  /**
  * Returns iterable of contracts.
  *
  * @return Iterable.
  */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "Returning an abstraction.")
  public Iterable<Contract.MutableContract> getContracts() {
    return contracts;
  }
}
