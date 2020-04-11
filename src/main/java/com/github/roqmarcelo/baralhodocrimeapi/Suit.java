package com.github.roqmarcelo.baralhodocrimeapi;

import org.springframework.lang.NonNull;

public enum Suit {
    CLUBS("https://disquedenuncia.com/baralho-do-crime/paus/"),
    DIAMONDS("https://disquedenuncia.com/baralho-do-crime/ouros/"),
    HEARTS("https://disquedenuncia.com/baralho-do-crime/copas/"),
    SPADES("https://disquedenuncia.com/baralho-do-crime/espadas/");

    Suit(@NonNull final String url) {
        this.url = url;
    }

    private String url;

    public String getUrl() {
        return url;
    }
}