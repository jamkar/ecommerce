package dao;

import model.Product;
import model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataProvider {

    private static List<Product> products = new ArrayList<Product>();
    private static List<User> users = new ArrayList<User>();

//    static {
//        products.add(new Product(
//                1, "Asus Zenfone Laser 3", "dfhkdhfh",
//                100, "new", null));
//        products.add(new Product(
//                2, "Samsung Galaxy", "fdfdsfdf",
//                600, "used", null));
//        products.add(new Product(
//                3, "Iphone X", "jkjkhjk",
//                999, "new", null));
//        products.add(new Product(
//                4, "HTC Desire", "vcbcbvcbcv",
//                100, "uesd", null));
//        products.add(new Product(
//                5, "Nokia Lumix", "dfhwqqweqweqwekdhfh",
//                250, "new", null));
//        products.add(new Product(
//                6, "Meizu M8", "zcxczxczxcx",
//                150, "new", null));
//
//    }

    public static List<Product> getProducts() {
        return products;
    }

    public static List<User> getUsers() {
        return users;
    }
}
