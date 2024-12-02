package com.challenge.scenario4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Input: ");
        String input = scan.nextLine();
        String output = "";

        int funnyEmojis = 0;
        int upsetEmojis = 0;

        for (int i = 0; i < input.length() - 2; i++) {
            if (input.startsWith(":-)", i)) {
                funnyEmojis++;
            } else if (input.startsWith(":-(", i)) {
                upsetEmojis++;
            }
        }

        if (funnyEmojis > upsetEmojis) {
            output = "funny";
        } else if (upsetEmojis > funnyEmojis) {
            output = "upset";
        } else {
            output = "neutral";
        }

        System.out.println("Output: " + output);
    }
}
