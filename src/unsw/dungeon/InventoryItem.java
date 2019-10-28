package unsw.dungeon;


public interface InventoryItem {

    public void useItem(Player p);
    public ItemType getItemType();
}