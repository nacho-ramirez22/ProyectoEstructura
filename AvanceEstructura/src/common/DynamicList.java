package common;

public class DynamicList<T> {
  // Inner class to represent a node in the list
  protected class Node<E> {
    E data;         // Data of the node
    Node<E> next;   // Reference to the next node

    // Node constructor
    public Node(E data) {
      this.data = data;
      this.next = null;
    }
  }

  // Pointer to the first node in the list
  protected Node<T> head;

  // Counter for the number of items in the list
  protected int itemCount;

  // Constructor of the list
  public DynamicList() {
    this.head = null;
    this.itemCount = 0;
  }

  // Add an item to the list
  public void addItem(T item) {
    Node<T> newNode = new Node<>(item);
    if (head == null) {
      head = newNode;
    } else {
      Node<T> current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
    itemCount++;
  }

  // Get the number of items in the list
  public int getItemCount() {
    return itemCount;
  }

  // Check if the list is empty
  public boolean isEmpty() {
    return itemCount == 0;
  }

  // Get an item from the list by index
  public T getItem(int index) {
    if (index < 0 || index >= itemCount) {
      throw new IndexOutOfBoundsException("Index out of range");
    }

    Node<T> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current.data;
  }

  // Remove an item from the list by index
  public void removeItem(int index) {
    if (index < 0 || index >= itemCount) {
      throw new IndexOutOfBoundsException("Index out of range");
    }

    if (index == 0) {
      head = head.next;
    } else {
      Node<T> previous = head;
      for (int i = 0; i < index - 1; i++) {
        previous = previous.next;
      }
      previous.next = previous.next.next;
    }
    itemCount--;
  }

  // Print the items in the list
  public void printItemList() {
    Node<T> current = head;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }

  // Check if the list contains a specific item
  public boolean containsItem(T item) {
    Node<T> current = head;
    while (current != null) {
      if (current.data.equals(item)) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  // Clear the list, removing all items
  public void clearItemList() {
    head = null;
    itemCount = 0;
  }

  // Get the index of an item in the list
  public int indexOfItem(T item) {
    Node<T> current = head;
    int index = 0;
    while (current != null) {
      if (current.data.equals(item)) {
        return index;
      }
      current = current.next;
      index++;
    }
    return -1;
  }

  // Get an item from the list by index
  public T getItemByIndex(int index) {
    if (index < 0 || index >= itemCount) {
      throw new IndexOutOfBoundsException("Index out of range");
    }

    Node<T> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current.data;
  }
}
