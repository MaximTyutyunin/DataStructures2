package cosc2007.A3;

public interface SortedTable {
    /**
     * insert element to its correct position
     * throw exception if same element is in the position
     */
    public void insert(int item) throws DictionaryException;

    /**
     * true if required element is found and deleted
     * false if not found
     */
    public boolean delete(int item) throws DictionaryException;

    /**
     * true if required element is found
     * false if not found
     */
    public boolean find(int item) throws DictionaryException;

    public void display();
}
