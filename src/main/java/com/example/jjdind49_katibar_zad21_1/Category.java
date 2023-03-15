package com.example.jjdind49_katibar_zad21_1;

public enum Category {
    FOOD("Artykuły spożywcze"),
    HOME("Artykuły domowe"),
    OTHER("Inne");


    private final String pl;

    Category(String pl) {
        this.pl = pl;
    }

    public String getPl() {
        return pl;
    }
}
