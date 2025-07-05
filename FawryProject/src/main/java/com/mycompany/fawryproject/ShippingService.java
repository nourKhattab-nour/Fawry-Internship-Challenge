/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fawryproject;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ShippingService {

    public static void ship(ArrayList<Shippable> items) {
        System.out.println("** Shipment notice **");

        double totalWeight = 0;

        int cheeseCount = 0;                      // Count cheese items
        double cheeseWeight = 0;

        int biscuitCount = 0;                    // Count biscuit items
        double biscuitWeight = 0;

        int tvCount = 0;                         // Count TV items
        double tvWeight = 0;

        for (int i = 0; i < items.size(); i++) {     // Go through all items and count them
            Shippable item = items.get(i);
            String name = item.getName();

            if (name.equals("Cheese")) {
                cheeseCount++;
                cheeseWeight = item.getWeight();
            } else if (name.equals("Biscuits")) {
                biscuitCount++;
                biscuitWeight = item.getWeight();
            } else if (name.equals("TV")) {
                tvCount++;
                tvWeight = item.getWeight();
            }
        }

        if (cheeseCount > 0) {                        // Print cheese if any
            double weight = cheeseWeight * cheeseCount;
            totalWeight += weight;
            System.out.println(cheeseCount + "x Cheese\t\t" + (int) weight + "g");
        }

        if (biscuitCount > 0) {                     // Print biscuits if any
            double weight = biscuitWeight * biscuitCount;
            totalWeight += weight;
            System.out.println(biscuitCount + "x Biscuits\t\t" + (int) weight + "g");
        }

        if (tvCount > 0) {                         // Print TV if any
            double weight = tvWeight * tvCount;
            totalWeight += weight;
            System.out.println(tvCount + "x TV\t\t" + (int) weight + "g");
        }

        System.out.println("Total package weight " + totalWeight / 1000 + "kg");
        System.out.println();
    }
}
