package com.geisann.webapp.model;

import java.time.YearMonth;
import java.util.Objects;

public class Organization {
    private final String name;
    private final YearMonth startDate;
    private final YearMonth endDate;
    private final String position;
    private final String text;

    public Organization(String name, YearMonth startDate, YearMonth endDate, String position, String text) {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(position, "position must not be null");
        //Objects.requireNonNull(text, "text must not be null");
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "name='" + name + '\'' +
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
        return Objects.equals(name, that.name) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(position, that.position) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startDate, endDate, position, text);
    }
}
