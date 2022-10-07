package model;

import java.util.ArrayList;

public class Item {
    protected String category;
    protected String name;
    protected String description;
    protected int dayOfCreation;
    protected int costPerDay;
    protected Boolean isRented = false;
    public Contract currentContract;
    protected ArrayList<Contract> futureContracts = new ArrayList<Contract>();
    protected ArrayList<Contract> oldContracts = new ArrayList<Contract>();
    protected Member owner;

    public Item(String category, String name, String description, int dayOfCreation, int costPerDay) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.dayOfCreation = dayOfCreation;
        this.costPerDay = costPerDay;
    }

    public Item(Item item) {
        this.category = item.category;
        this.name = item.name;
        this.description = item.description;
        this.dayOfCreation = item.dayOfCreation;
        this.costPerDay = item.costPerDay;
    }

    public void setOwner(Member owner) {
        this.owner = owner;
    }

    public Member getOwner() {
        return owner;
    }
    
    public void setAsRented() {
        this.isRented = true;
    }

    public void setAsNotRented() {
        this.isRented = false;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCostPerDay(int costPerDay) {
        this.costPerDay = costPerDay;
    }

    public Boolean getRented() {
        return this.isRented;
    }

    public String getCategory() {
        return this.category;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getDayOfCreation() {
        return this.dayOfCreation;
    }

    public int getCostPerday() {
        return this.costPerDay;
    }

    public void setCurrentContract(Contract currentContract) {
        this.currentContract = currentContract;
    }

    public void removeCurrentContract() {
        this.currentContract = null;
    }

    public void moveExpiredContract(Contract contract) {
        this.futureContracts.remove(contract);
        this.oldContracts.add(contract);
        removeCurrentContract();
        setAsNotRented();
    }

    public Contract getCurrentContract() {
        return currentContract;
    }
    public Iterable<Contract> getFutureContracts() {
        return futureContracts;
    }

    public int getFutureContractAmount() {
        return futureContracts.size();
    }

    public Iterable<Contract> getOldContracts() {
        return oldContracts;
    }

    public void addToFutureContracts(Contract contract) {
        this.futureContracts.add(contract);
    }

    public void removeFromFutureContracts(Contract contract) {
        this.futureContracts.remove(contract);
    }

    public void addToOldContracts(Contract contract) {
        if(!this.oldContracts.contains(contract) || contract != null) {
            this.oldContracts.add(contract);
        }   
    }

    /**
     * An item you can change.
     */
    public static class MutableItem extends Item {

        public MutableItem(String category, String name, String description, int dayOfCreation, int costPerDay) {
            super(category, name, description, dayOfCreation, costPerDay);
        }


        public MutableItem(Item item) {
            super(item);
        }

    }
}

