package com.github.roqmarcelo.baralhodocrimeapi;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
class CardParser {

    Card parse(@NonNull final Suit suit, @NonNull final Element element) {
        Elements images = element.getElementsByTag("img");

        if (images.isEmpty()) {
            throw new IllegalArgumentException(); // change to specific exception
        }

        Node image = images.get(0);

        String title = element.attr("title");
        String imageUrl = parseImage(image);

        return new Card(title, suit, imageUrl);
    }

    private String parseImage(@NotNull final Node image) {
        String[] sources = image.attr("srcset").split(CardParser.Separator.COMMA);

        String selectedSrc = sources[sources.length - 2].trim(); // 1024w

        return selectedSrc.split(Separator.EMPTY)[0];
    }

    private static class Separator {
        private static final String COMMA = ",";
        private static final String EMPTY = " ";
    }
}