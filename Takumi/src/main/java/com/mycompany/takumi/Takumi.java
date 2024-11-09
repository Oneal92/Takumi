
package com.mycompany.takumi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Takumi {
    private List<Cards> deck;
    private Player player;
    private Player computer;
    private Scanner scanner;

    public Takumi() {
        deck = new ArrayList<>();
        player = new Player("Player");
        computer = new Player("Computer");
        scanner = new Scanner(System.in);
        initializeDeck();
        shuffleDeck();
        dealCards();
    }

    private void initializeDeck() {
        deck.add(new Cards("Angel of Light", 8, 5));
        deck.add(new Cards("Dr.Stellar", 5, 8));
        deck.add(new Cards("Frost Dragon", 7, 7));
        deck.add(new Cards("AI J9213", 6, 6));
        deck.add(new Cards("Mystic Warrior", 9, 4));
        deck.add(new Cards("Onryo", 10, 3));
        deck.add(new Cards("Queen Sorceress", 7, 9));
        deck.add(new Cards("Satori", 6, 8));
        deck.add(new Cards("Sinister G", 5, 7));
        deck.add(new Cards("Vamp", 8, 6));
        deck.add(new Cards("Snake Beast", 4, 10));
        deck.add(new Cards("Void of Despair", 10, 10));
    }

    private void shuffleDeck() {
        Collections.shuffle(deck);
    }

    private void dealCards() {
        for (int i = 0; i < 4; i++) {
            player.addCard(deck.remove(0));
            computer.addCard(deck.remove(0));
        }
    }

    private int getUserCardChoice(int handSize) {
        System.out.print("Choose a card to attack with (1-" + handSize + "): ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice < 1 || choice > handSize) {
                System.out.println("Invalid choice. Please try again.");
                return getUserCardChoice(handSize);
            }
            return choice - 1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return getUserCardChoice(handSize);
        }
    }

    public void start() {
        int playerScore = 0;
        int computerScore = 0;
        int rounds = 4;

        System.out.println("Welcome to Takumi Card Battle Game!");

        for (int round = 1; round <= rounds; round++) {
            System.out.println("Round " + round);
            player.displayHand();
            int playerChoice = getUserCardChoice(player.getHand().size());
            Cards playerCard = player.getHand().get(playerChoice);
            player.removeCard(playerCard);
            System.out.println();
            System.out.println("You played: " + playerCard);

            int computerChoice = (int) (Math.random() * computer.getHand().size());
            Cards computerCard = computer.getHand().get(computerChoice);
            computer.removeCard(computerCard);
            System.out.println();
            System.out.println("Computer played: " + computerCard);

            if (playerCard.getAttackPower() > computerCard.getDefense()) {
                System.out.println();
                System.out.println("You win this round!");
                System.out.println();
            } else if (computerCard.getAttackPower() > playerCard.getDefense()) {
                System.out.println();
                System.out.println("Computer wins this round!");
                System.out.println();
            } else if (computerCard.getDefense() > playerCard.getAttackPower()){
                System.out.println();
                System.out.println("The computer stopped you with their defense and won this round!");
                System.out.println();
            }else if (playerCard.getAttackPower() > computerCard.getDefense()){
                System.out.println();
                System.out.println("You've stopped their attack!");
                System.out.println();
            }else{
                System.out.println();
                System.out.println("Both Cards Are Evenly Match");
                System.out.println();
            }

            System.out.println("-----------------------------------");
        }

        System.out.println("Final Scores: Player - " + playerScore + ", Computer - " + computerScore);
        if (playerScore > computerScore) {
            System.out.println();
            System.out.println("Congratulations! You win the game!");
        } else if (computerScore > playerScore) {
            System.out.println();
            System.out.println("Computer wins the game!");
        } else {
            System.out.println();
            System.out.println("The game is a tie!");
        }
        
        scanner.close();
    }
}
