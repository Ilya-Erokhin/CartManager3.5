package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;
import ru.netology.manager.CartManager;

import static org.junit.jupiter.api.Assertions.*;

public class CartManagerTestNonEmpty {

  @Test
  public void shouldRemoveIfExists() {
    //Create instance of manager
    CartManager manager = new CartManager();
    //Define an ID
    // Creates an Items with args and add them
    PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
    PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
    PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);
    manager.add(first);
    manager.add(second);
    manager.add(third);

    int idToRemove = 1;
    manager.removeById(idToRemove);

    PurchaseItem[] actual = manager.getAll();
    PurchaseItem[] expected = new PurchaseItem[]{third, second};

    //assertEquals(expected, actual); - Compares by link
    assertArrayEquals(expected, actual); // Compares like an object!!! we need this
  }
//True!!!!`

//  @Test
//  public void shouldNotRemoveIfNotExists() {
//    CartManager manager = new CartManager();
//    int idToRemove = 4;
//    PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
//    PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
//    PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);
//    manager.add(first);
//    manager.add(second);
//    manager.add(third);
//
//    manager.removeById(idToRemove);
//
//    PurchaseItem[] actual = manager.getAll();
//    PurchaseItem[] expected = new PurchaseItem[]{third, second, first};
//
//    assertArrayEquals(expected, actual);
//  }
}