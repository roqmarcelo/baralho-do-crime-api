package com.github.roqmarcelo.baralhodocrimeapi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Component
class CardRetrieverJob {

    private final CardParser parser;

    CardRetrieverJob(@NonNull final CardParser parser) {
        this.parser = parser;
    }

    void execute() {
        List<Card> cards = new ArrayList<>();

        EnumSet.allOf(Suit.class).forEach(suit -> {
            try {
                Document document =  Jsoup.connect(suit.getUrl()).get();

                Elements elements =  document.getElementsByAttribute("data-gallery");

                elements.forEach(element -> {
                    Card card = parser.parse(suit, element);
                    cards.add(card);
                });
            } catch (IOException e) {
                System.out.println(String.format("Could not retrieve suit %s", suit.toString()));
            }
        });

        System.out.println(cards);
    }
}