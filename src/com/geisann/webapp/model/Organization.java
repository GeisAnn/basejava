package com.geisann.webapp.model;

import java.time.YearMonth;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    private final YearMonth startDate;
    private final YearMonth endDate;
    private final String position;
    private final String text;

    public Organization(String name, String url, YearMonth startDate, YearMonth endDate, String position, String text) {
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(position, "position must not be null");
        this.homePage = new Link(name, url);
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", position='" + position + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(homePage, that.homePage) && startDate.equals(that.startDate) && endDate.equals(that.endDate) && position.equals(that.position) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, startDate, endDate, position, text);
    }
}
