package com.challenge.scenario4.model;

public class EmojiCheck {
    int funnyEmojis = 0;
    int upsetEmojis = 0;

    public void countEmojis(String input) {
        funnyEmojis = 0;
        upsetEmojis = 0;

        for (int i = 0; i < input.length() - 2; i++) {
            if (input.startsWith(":-)", i)) {
                funnyEmojis++;
            } else if (input.startsWith(":-(", i)) {
                upsetEmojis++;
            }
        }
    }

    public String returnFeeling(String input) {
        countEmojis(input);

        if (funnyEmojis > upsetEmojis) {
            return "funny";
        } else if (upsetEmojis > funnyEmojis) {
            return "upset";
        } else {
            return "neutral";
        }
    }
}
