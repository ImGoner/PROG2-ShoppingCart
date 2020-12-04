package uhk.fim.IO;

import uhk.fim.model.ShoppingCart;

public interface IOFile {
     void save(ShoppingCart shoppingCart ,String path);
     ShoppingCart load(String path);
}
