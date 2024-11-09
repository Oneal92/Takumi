/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.takumi;

/**
 *
 * @author bapti
 */

// Cards.java

public class Cards {
    private String name;
    private int attackPower;
    private int defense;

    public Cards(String name, int attackPower, int defense) {
        this.name = name;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public String toString() {
        return name + " (Attack: " + attackPower + ", Defense: " + defense + ")";
    }
}
