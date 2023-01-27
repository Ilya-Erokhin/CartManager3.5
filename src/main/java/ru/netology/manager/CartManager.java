package ru.netology.manager;
import ru.netology.domain.PurchaseItem;

public class CartManager {
  //Create an empty array called items (reference types PurchaseItem[])
  private PurchaseItem[] items = new PurchaseItem[0];

  public void add(PurchaseItem item) {
    // Create new array one more (++) - 'Cuz we can't change an array!!!
    int length = items.length + 1;
    //Create new temp array and this length will be result of variable above (length)
    PurchaseItem[] tmp = new PurchaseItem[length];

    // for (int i = 0; i < items.length; i++) {
    //   //The first element (i) of temp[] array equals the first element of items[] of array.
    //   tmp[i] = items[i];
    // }
    // items - from which to copy, scrPos - Element form which starts to copy, destPos - From what element we wanna ---
    // starts fill it, From where starts filling
    System.arraycopy(items, 0, tmp, 0, items.length);

    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    items = tmp;
  }
  //getAll needs if we wanna our last added to cart, becomes the First item!!!
  public PurchaseItem[] getAll() {
    //Initialize new array
    PurchaseItem[] result = new PurchaseItem[items.length];
    // перебираем массив в прямом порядке
    // но кладём в результаты в обратном
    for (int i = 0; i < result.length; i++) {

      int index = items.length - 1 - i;
      result[i] = items[index];
    }
    return result;
  }

  public void removeById(int id) {
    int length = items.length - 1;
    PurchaseItem[] tmp = new PurchaseItem[length];
    int index = 0;
    for (PurchaseItem item : items) {
      if (item.getId() != id) {
        tmp[index] = item;
        index++;
      }
    }
    items = tmp;
  }
}