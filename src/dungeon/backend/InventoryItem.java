package dungeon.backend;


public interface InventoryItem {

    public void useItem(Player p);
    public ItemType getItemType();
}