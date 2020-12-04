package uhk.fim.gui;

import uhk.fim.model.ShoppingCart;
import uhk.fim.model.ShoppingCartItem;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ShoppingCartTableModel extends AbstractTableModel {
    // V modelu potřebujeme referenci na data
    private ShoppingCart shoppingCart;

    @Override
    public int getRowCount() {
        return shoppingCart.getItems().size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==4){return Boolean.class;}
        return super.getColumnClass(columnIndex);
    }

    @Override
    public int getColumnCount() {

        return 5;
    }

    // Tato metoda se volá, když se tabulka dotazuje hodnotu v buňce. Tedy pro kažkou buňku.
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Řádek tabulky (rowIndex) odpovídá pozici položky v seznamu položek
        ShoppingCartItem item = shoppingCart.getItems().get(rowIndex);
        // Podle indexu sloupce vracíme atribut položky
        switch (columnIndex) {
            case 0:
                return item.getName();
            case 1:
                return item.getPricePerPiece();
            case 2:
                return item.getPieces();
            case 3:
                return item.getTotalPrice();
            case 4:
                return item.isBought();
            default:
                return null;
        }
    }

    // Tato metoda se volá, když se tabulka dotazuje na nýzvy sloupců
    @Override
    public String getColumnName(int columnIndex) {
        // Podle indexu sloupce vracíme název
        switch (columnIndex) {
            case 0:
                return "Název";
            case 1:
                return "Cena/kus";
            case 2:
                return "Počet kusů";
            case 3:
                return "Cena celkem";
            case 4:
                return "Koupeno";
            default:
                return null;
        }
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }


}
