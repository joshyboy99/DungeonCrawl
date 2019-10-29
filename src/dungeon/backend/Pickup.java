package dungeon.backend;


public interface Pickup {

    public void useItem(Player p);
    public ItemType getItemType();
}