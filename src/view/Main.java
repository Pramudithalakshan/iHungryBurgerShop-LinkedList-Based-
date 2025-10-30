package view;

import model.Burger;
import controller.BurgerController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
            BurgerController burgerController = new BurgerController();
            new ShopMainForm(burgerController).setVisible(true);

    }

}
