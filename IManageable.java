import java.util.List;

public interface IManageable
{
    public void addItem(Item akItem);
    public void removeItem(Item akItem);
    public List<Item> listAvailable();
    public List<Item> listBorrowed();
}
