package uhk.fim.IO;

import uhk.fim.model.ShoppingCart;
import uhk.fim.model.ShoppingCartItem;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class IOcsvFile implements IOFile{
    @Override
    public void save(ShoppingCart shoppingCart ,String path) {

            try (BufferedWriter bfw = new BufferedWriter(new FileWriter(path))) {

                //new PrintWriter(path).close();

                for (ShoppingCartItem item : shoppingCart.getItems()) {
                    bfw.write(item.getName() + ";" + item.getPricePerPiece() + ";" + item.getPieces()+ ";" + item.isBought());
                    bfw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    @Override
    public ShoppingCart load(String path) {
        ShoppingCart shpcrt = new ShoppingCart();
        try (BufferedReader bfw = new BufferedReader(new FileReader(path))) {
            Stream<String> lines = bfw.lines();
            lines.forEach(line -> {
                String[] items = line.split(";");
                shpcrt.addItem(new ShoppingCartItem(items[0],Double.parseDouble(items[1]),Integer.parseInt( items[2]),Boolean.parseBoolean( items[3])));
                    }
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return shpcrt;
    }
}
