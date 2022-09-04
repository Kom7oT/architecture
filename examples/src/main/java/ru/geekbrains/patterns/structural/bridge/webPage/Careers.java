package ru.geekbrains.patterns.structural.bridge.webPage;

import ru.geekbrains.patterns.structural.bridge.themes.Theme;

public class Careers implements WebPage {
    protected Theme theme;

    public Careers(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String getContent() {
        return "Careers page in " + theme.getColor();
    }
}
