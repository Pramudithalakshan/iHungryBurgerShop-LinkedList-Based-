/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import model.Burger;

/**
 *
 * @author pramuditha-lakshan
 */
public class BurgerController {

    public String generateOrderID() throws IOException {
        File file = new File("burger.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        String lastLine = null;
        while ((line = br.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                lastLine = line;
            }
        }
        if (lastLine == null || lastLine.trim().isEmpty()) {
            return "B0001";
        }
        String[] parts = lastLine.split(",");
        String lastId = parts[0];

        int nextNumber = Integer.parseInt(lastId.substring(1)) + 1;
        return String.format("B%04d", nextNumber);

    }

    public Burger searchOrder(String orderId) throws IOException {

        FileReader fr = new FileReader("burger.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {
            if (line.substring(0, 5).equalsIgnoreCase(orderId)) {
                break;
            }
            line = br.readLine();
        }
        if (line == null) {
            return null;
        }
        String[] rowData = line.split(",");
        Burger burger = new Burger(rowData[0], rowData[1], rowData[2], Integer.parseInt(rowData[3]), Integer.parseInt(rowData[4]));
        return burger;
    }

    public Burger searchCustomer(String customerId) throws IOException {

        FileReader fr = new FileReader("burger.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        String[] rowData = line.split(",");
        while (line != null) {
            if (rowData[1].equalsIgnoreCase(customerId)) {
                break;
            }
            line = br.readLine();
            rowData = line.split(",");
        }
        if (line == null) {
            return null;
        }

        Burger burger = new Burger(rowData[0], rowData[1], rowData[2], Integer.parseInt(rowData[3]), Integer.parseInt(rowData[4]));
        return burger;
    }

//    public DefaultTableModel loadCustomerTable(Burger customer) {
//        for (int i = 0; i < customer.length; i++) {
//            String[] columns = {"Order ID", "order Qty", "Total"};
//            DefaultTableModel model = new DefaultTableModel(columns, 0);
//
//            for (Burger c : customerArray) {
//                Object[] row = {c.getOrderID(), c.getQty(), c.getQty() * UNITE_PRICE};
//                model.addRow(row);
//            }
//
//            return model;
//
//        }
//        return null;
//    }
//   public boolean updateOrder(Burger burger){
//   
//   }
    public static LinkedList getAllBurgers(int status) throws FileNotFoundException {
        Scanner input = new Scanner(new File("burger.txt"));
        LinkedList linkedList = new LinkedList();
        while (input.hasNext()) {
            String line = input.nextLine();
            String[] rowData = line.split(",");
            if (Integer.parseInt(rowData[4]) == (status)) {
                linkedList.add(new Burger(rowData[0], rowData[1], rowData[2], Integer.parseInt(rowData[3]), Integer.parseInt(rowData[4])));
            }
        }
        return linkedList;
    }

    public LinkedList getBurger(String customerId) throws FileNotFoundException {
        Scanner input = new Scanner(new File("burger.txt"));
        LinkedList linkedList = new LinkedList();
        while (input.hasNext()) {
            String line = input.nextLine();
            String[] rowData = line.split(",");
            if (rowData[1].equals(customerId)) {
                linkedList.add(new Burger(rowData[0], Integer.parseInt(rowData[3])));
                return linkedList;
            }
        }
        return null;
    }

    public Burger[] sort() throws FileNotFoundException {
        Scanner input = new Scanner(new File("burger.txt"));
        LinkedList linkedList = new LinkedList();
        while (input.hasNext()) {
            String line = input.nextLine();
            String[] rowData = line.split(",");
            Burger b = new Burger(rowData[0], rowData[1], rowData[2], Integer.parseInt(rowData[3]), Integer.parseInt(rowData[4]));
            linkedList.add(b);
        }
       Burger[] burgersArray = linkedList.toArray();
        for (int i = 0; i < burgersArray.length - 1; i++) {
            for (int j = 0; j < burgersArray.length - i - 1; j++) {
                if (burgersArray[j].getQty() < burgersArray[j + 1].getQty()) {
                    Burger temp = burgersArray[j];
                    burgersArray[j] = burgersArray[j + 1];
                    burgersArray[j + 1] = temp;
                }
            }
        }
        return burgersArray;
    }

}
