package items;

import java.util.List;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.Objects;

/**
 * An Inventory is composed of n slots. Each slot may store only
 * one type of item--specified by *slots*.
 * <p>
 * Once all slots are filled, no additional Item types may be
 * stored. Individual slots may contain any number of the same
 * Item--if the Item is stackable.
 */
public class Inventory implements Iterable<ItemStack>, Cloneable
{
    /**
     * This is the Default Inventory size.
     */
    public static final int DEFAULT_SIZE = 10;

    /**
     * This is utility function that takes two ItemStacks and adds the
     * number of items in the right-hand side stack to the left-hand side stack.
     *
     * @param lhs stack whose size will be increased
     * @param rhs stack whose size we need to examine
     */
    public static void mergeStacks(ItemStack lhs, ItemStack rhs)
    {
        // Refer to the notes from Assignment 1
    }

    /**
     * Individual item slots--each ItemStack occupies one slot.
     */
    private List<ItemStack> slots;

    /**
     * Total number of distinct Item types that can be stored.
     */
    private int capacity;

    /**
     * Default to an inventory with 10 slots.
     */
    public Inventory()
    {
        this(DEFAULT_SIZE);
    }

    /**
     * Create an inventory with n slots.
     *
     * @param desiredCapacity size of the new Inventory
     */
    public Inventory(int desiredCapacity)
    {
        this.slots    = new ArrayList<>();
        this.capacity = desiredCapacity;
    }

    /**
     * Determine the number of slots currently in use.
     */
    public int utilizedSlots()
    {
        return this.slots.size();
    }

    /**
     * Determine the number of empty (unused) slots.
     */
    public int emptySlots()
    {
        return this.totalSlots() - this.utilizedSlots();
    }

    /**
     * Retrieve the capacity (number of distinct types of items) that this
     * inventory can store.
     */
    public int totalSlots()
    {
        return this.capacity;
    }

    /**
     * Determine if the inventory is considered full.
     *
     * @return true if the current size is equal to capacity
     */
    public boolean isFull()
    {
        // Replace the next line
        return false;
    }

    /**
     * Determine if the inventory is empty.
     *
     * @return true if current size is zero
     */
    public boolean isEmpty()
    {
        return this.slots.size() == 0;
    }

    /**
     * Search through all slots (Nodes in the LinkedList) and look for a
     * matching ItemStack.
     *
     * @param key stack for which the search is being conducted
     *
     * @return matching stack if one was found and `null` otherwise
     */
    public ItemStack findMatchingItemStack(ItemStack key)
    {
        // Adapt the logic from Assignment 1

        return null;
    }

    /**
     * This is the standard Linked List append operation from Review 01
     *
     * @param toAdd data that we want to store in a Node and add to the list
     */
    public void addItemStackNoCheck(ItemStack toAdd)
    {
        // Add the missing (one) line by using `this.slots.add(????)`
    }

    /**
     * Add one or more items to the inventory list.
     *
     * @param stack new stack of items to add
     *
     * @return true if *stack* was added and false otherwise
     */
    public boolean addItems(ItemStack stack)
    {
        ItemStack match = this.findMatchingItemStack(stack);

        // if a match was found
        if (match != null) {
            // If the Item is stackable, add it to the ItemStack
            if (match.permitsStacking()) {
                mergeStacks(match, stack);

                return true;
            }
        }

        if (this.slots.size() < capacity) {
            this.addItemStackNoCheck(stack);
            return true;
        }

        return false;
    }

    @Override
    public Inventory clone()
    {
        Inventory copy = new Inventory(this.totalSlots());

        // Add the missing copy logic (loop)

        return copy;
    }

    /**
     * Two Invetories are considered equal if they:
     *
     *   1. Have the same capacity
     *   2. Have the same ItemStacks in the same order
     */
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Inventory)) {
            return false;
        }

        Inventory lhs = this;
        Inventory rhs = (Inventory) obj;

        if (lhs.totalSlots() != rhs.totalSlots()) {
            return false;
        }

        return lhs.slots.equals(rhs.slots);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.capacity, this.slots);
    }

    /**
     * *Print* a Summary of the Inventory and all Items contained within.
     */
    @Override
    public String toString()
    {
        String summaryLine = String.format(
            " -Used %d of %d slots%n", this.utilizedSlots(), this.totalSlots()
        );

        StringBuilder strBld = new StringBuilder();
        strBld.append(summaryLine);

        // Add the missing loop

        return strBld.toString();
    }

    @Override
    public Iterator<ItemStack> iterator()
    {
        return this.slots.iterator();
    }
}
