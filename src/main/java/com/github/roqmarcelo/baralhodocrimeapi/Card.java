package com.github.roqmarcelo.baralhodocrimeapi;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Card {
    private String wantedName;
    private Suit suit;
    private String imageUrl;

    Card(@NonNull final String wantedName, @NonNull final Suit suit, @NotNull final String imageUrl) {
        this.wantedName = wantedName;
        this.suit = suit;
        this.imageUrl = imageUrl;
    }

    public String getWantedName() {
        return wantedName;
    }

    public Suit getSuit() {
        return suit;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(wantedName, card.wantedName) &&
                suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wantedName, suit);
    }

    @Override
    public String toString() {
        return "Card{" +
                "wantedName='" + wantedName + '\'' +
                ", suit=" + suit +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}