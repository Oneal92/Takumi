/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.takumi;

/**
 *
 * @author bapti
 */
// Player.java

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Cards> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    // Add a card to the player's hand
    public void addCard(Cards card) {
        hand.add(card);
    }

    // Remove a card from the player's hand
    public void removeCard(Cards card) {
        hand.remove(card);
    }

    // Get the player's hand
    public List<Cards> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    // Display the player's hand
    public void displayHand() {
        System.out.println(name + "'s Hand:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println((i + 1) + ". " + hand.get(i));
        }
    }
}

 