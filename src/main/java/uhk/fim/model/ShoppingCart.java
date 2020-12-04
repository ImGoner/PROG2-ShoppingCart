package uhk.fim.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<ShoppingCartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<ShoppingCartItem>();
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public void addItem(ShoppingCartItem newItem) {
        boolean isInList = false;
        for (ShoppingCartItem item : items) {
            if(item.getName().equals(newItem.getName()) && item.getPricePerPiece() == newItem.getPricePerPiece() && item.isBought() == newItem.isBought()) {
                isInList = true;
                item.setPieces(item.getPieces() + newItem.getPieces());
                break;
            }
        }

        if(!isInList)
            this.items.add(newItem);
    }

    public double getTotalPrice() {
        double sum = 0;
        for (ShoppingCartItem item : items) {
            sum += item.getTotalPrice();
        }
        return sum;
    }

    public double getTotalBoughtPrice(){
        double sum = 0;
        for (ShoppingCartItem item : items) {
            sum += item.isBought()? item.getTotalPrice():0;
        }
        return sum;
    }

    public double getRozdil(){

        return getTotalPrice()-getTotalBoughtPrice();
    }

    public void repoveItem(int i){
        items.remove(i);
    }
}
