package uhk.fim.IO;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import uhk.fim.model.ShoppingCart;
import uhk.fim.model.ShoppingCartItem;

import java.io.*;

public class IOJsonFile implements IOFile{
    @Override
    public void save(ShoppingCart shoppingCart ,String path) {
        Gson gson = new Gson();
        String jsonInString = gson.toJson(shoppingCart);

        try (BufferedWriter bfw = new BufferedWriter(new FileWriter(path, true))) {
            bfw.write(jsonInString);
            bfw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ShoppingCart load(String path) {
        Gson gson = new Gson();
        ShoppingCart shoppingCart = new ShoppingCart();
    try(FileReader fileReader = new FileReader(path))  {
       shoppingCart =  gson.fromJson(fileReader,ShoppingCart.class);
        return shoppingCart;
    }catch (IOException e){

    }
        return null;
    }
}
