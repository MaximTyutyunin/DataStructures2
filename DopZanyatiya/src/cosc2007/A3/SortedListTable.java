package cosc2007.A3;

/**
 * intelij ctrl + b  -> go to declaration of something
 * <p>
 * I use dummy node in this class
 */
public class SortedListTable implements SortedTable {
    final int MAX_TABLE_CAPACITY;
    int currentSize;

    private class Node {
        int item;
        Node next;

        Node(int item) {
            this.item = item;
            next = null;
        }

    }

    SortedListTable(int s) {
        MAX_TABLE_CAPACITY = s;
    }

    /**
     * i couldn't come up with anything better than this
     * this dummy node is not taking part in placing elements
     * so if you print it with other nodes there will be something like
     * -1 -2 2 3 4
     */
    public Node head = new Node(-1);

    @Override
    public void insert(int item) throws DictionaryException {
        /**
         * 1) check if the list is overloaded
         * 2)int the while loop:
         *         "if" is responsible for adding the last element
         *         "else if" is responsible for adding in the middle of the list
         * */
        if (currentSize >= MAX_TABLE_CAPACITY) {
            throw new DictionaryException("Dictionary_Full");
        }

        Node temp = new Node(item);
        Node current = head;

        while (current != null) {

            if (current.next == null) {
                current.next = temp;//when adding at the end
                currentSize++;
                return;
            } else if (current.next.item == item) {
                throw new DictionaryException("Duplicate_Element_Found");
            } else if (current.next.item > item) {
                temp.next = current.next;
                current.next = temp;
                currentSize++;
                return;
            }
            current = current.next;//to move forward
        }
    }

    @Override//наверное, надо использовать другие методы, чтобы нати позицию
    public boolean delete(int item) throws DictionaryException {
        /**
         * 1)if list is empty return exception
         * 2)since no dummy node here, the "head" is a special case
         *   so i use "if" when deleting its item
         * 3) while is for every other case
         *
         * */
        if (currentSize == 0)
            throw new DictionaryException("Dictionary_Empty");

        Node current = head;
//        if (head.item == item) {//delete the first node
//            head = head.next;
//        }
        while (current != null) {
            if (current.next == null) {
                throw new DictionaryException("Element_Not_Found");
            } else if (current.next.item == item) {//deleting from the middle of the list
                if (current.next.next != null) {
                    current.next = current.next.next;
                    currentSize--;
                    return true;
                } else {
                    current.next = null;//case when deleting the last element
                    currentSize--;
                    return true;
                }
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean find(int item) {
        return find(head, item);
    }

    public boolean find(Node head, int item) {
        /**start at "head",
         * go to next node till find the required one
         * return false if nothing is found(line 43)*/
        Node current = head;
        while (current != null) {
            if (current.item == item)
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public void display() {
        Node current = head.next;
        System.out.print('[');
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
            if (current.next == null) {//print the last element
                System.out.print(current.item);
                break;
            }
        }
        System.out.println(']');
    }
}
