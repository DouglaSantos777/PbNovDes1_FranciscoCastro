package com.challenge.scenario4;

import com.challenge.scenario4.model.EmojiCheck;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        EmojiCheck react = new EmojiCheck();

        System.out.print("Input: ");
        String text = scan.nextLine();
        System.out.print("Output: ");
        System.out.println(react.returnFeeling(text));

    }
}
