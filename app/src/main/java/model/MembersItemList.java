package model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;

/**
 * Objects Members list of object Item.
 */
public class MembersItemList {
  private Member.MutableMember owner = null;
  private ArrayList<Item.MutableItem> items = new ArrayList<Item.MutableItem>();

  /**
   * Object owner.
   *
   * @param owner Object.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "MutableMember is a mutable copy..")
  public void setOwner(Member.MutableMember owner) {
    this.owner = owner;
  }

  /**
   * Get owner-object.
   *
   * @return Object.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "Returning an mutable.")
  public Member.MutableMember getOwner() {
    return owner;
  }

  /**
   * For adding objects to list.
   *
   * @param item Object.
   * @return Object.
   */
  public Item addItem(Item item) {
    items.add(new Item.MutableItem(item));
    return items.get(items.size() - 1);
  }

  /**
   * Returns iterable of items.
   *
   * @return Iterable.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "Returning an abstraction.")
  public Iterable<Item.MutableItem> getItems() {
    return items;
  }

  /**
   * How many items member has.
   *
   * @return Int.
   */
  public int getNumberOfItems() {
    return items.size();
  }

  /**
   * Removes reference to item.
   *
   * @param selectedItem Object.
   */
  public void deleteItem(Item.MutableItem selectedItem) {
    items.remove(selectedItem);
  }
}
