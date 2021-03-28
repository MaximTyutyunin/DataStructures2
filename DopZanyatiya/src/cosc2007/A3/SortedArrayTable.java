package cosc2007.A3;

/**
 * <p></p>
 * NOTES FOR FUTURE ME:
 * "new" operator calls constructor of our class
 * dynamically allocates memory for a new object and
 * also returns reference for that memory location into our variable
 */
public class SortedArrayTable implements SortedTable {
    final int MAX_TABLE_CAPACITY; // maximum space Taken of table
    private int[] items; //table item
    private int spaceTaken; //tablespaceTaken


    SortedArrayTable(int s) {
        MAX_TABLE_CAPACITY = s;
        items = new int[MAX_TABLE_CAPACITY];
    }

    private int position(int item) {
        int position = 0;
        while ((position < spaceTaken) && (items[position] < item))
            ++position;
        return position;
    }

    @Override
    public void insert(int item) throws DictionaryException {
        if (spaceTaken == MAX_TABLE_CAPACITY) {
            throw new DictionaryException("Dictionary_Full");
        }
        int searchedSpot = position(item);
        if ((searchedSpot < spaceTaken) && (items[searchedSpot] == item)) {
            throw new DictionaryException("Duplicate_Element_Found");
        } else {

            for (int index = spaceTaken - 1; index >= searchedSpot; index -= 1) {
                items[index + 1] = items[index];
            }
            items[searchedSpot] = item;
            ++spaceTaken;
        }
    }

    @Override
    public boolean delete(int item) throws DictionaryException {
        if (spaceTaken == 0) {
            throw new DictionaryException("Dictionary is empty");// new operator dynamically allocated memory for a new object + returns reference for that memory location
        }

        int searchedSpot = position(item);
        boolean success = (searchedSpot <= spaceTaken) && (items[searchedSpot] == item);

        if (success) {
            --spaceTaken;
            int tempIndex = searchedSpot;//here
            for (int index = searchedSpot; index < spaceTaken; ++index) {
                items[index] = items[index + 1];
                tempIndex++;//можно ли сделать эффективней?
            }
            items[tempIndex] = 0;//delete the last duplicated element, line 50 declaration of tempIndex
        } else {
            throw new DictionaryException("Element_not_Found");
        }
        return true;
    }

    @Override
    /**this method doesnt work if array is not fully filled with items*/
    public boolean find(int item) {
        return find(item, items, 0, spaceTaken - 1);/** note for later, attention to here coz in arrays index */
    }

    /**
     * always moves out of bound when last index is set as elngth
     */

    private boolean find(int item, int[] arr, int start, int end) {
        int mid = (start + end) / 2;

        if (arr[mid] == item) return true;
        if (start > end) return false;

        if (arr[mid] < item) {//go right
            return find(item, arr, mid + 1, end);
        } else {
            return find(item, arr, start, mid - 1);
        }

    }

    @Override
    public void display() {
        System.out.print("[");
        for (int i = 0; i < spaceTaken - 1; i++) {
            System.out.print(items[i] + ", ");
        }
        System.out.println(items[spaceTaken-1] + "]");
    }

}