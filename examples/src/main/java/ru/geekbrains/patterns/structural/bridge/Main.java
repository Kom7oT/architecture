package ru.geekbrains.patterns.structural.bridge;

import ru.geekbrains.patterns.structural.bridge.themes.DarkTheme;
import ru.geekbrains.patterns.structural.bridge.themes.Theme;
import ru.geekbrains.patterns.structural.bridge.webPage.About;
import ru.geekbrains.patterns.structural.bridge.webPage.Careers;

public class Main {
    public static void main(String[] args) {
        Theme darkTheme = new DarkTheme();
        About about = new About(darkTheme);
        Careers careers = new Careers(darkTheme);

        System.out.printf(about.getContent());
        System.out.println();
        System.out.println(careers.getContent());
    }
}
