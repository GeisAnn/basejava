package com.geisann.webapp.model;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    private List<Position> positions = new ArrayList<>();

    public Organization(String name, String url, List<Position> positions) {
        this.homePage = new Link(name, url);
        this.positions = positions;
    }

    public Organization(String name, String url, Position ... positions) {
        this (name, url, Arrays.asList(positions));
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", positions=" + positions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(homePage, that.homePage) && Objects.equals(positions, that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, positions);
    }

    public static class Position {
        private final YearMonth startDate;
        private final YearMonth endDate;
        private final String position;
        private final String text;

        public Position(YearMonth startDate, YearMonth endDate, String position, String text) {
            Objects.requireNonNull(startDate, "startDate must not be null");
            Objects.requireNonNull(endDate, "endDate must not be null");
            Objects.requireNonNull(position, "position must not be null");
            this.startDate = startDate;
            this.endDate = endDate;
            this.position = position;
            this.text = text;
        }

        public YearMonth getStartDate() {
            return startDate;
        }

        public YearMonth getEndDate() {
            return endDate;
        }

        public String getPosition() {
            return position;
        }

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "startDate=" + startDate +
                    ", endDate=" + endDate +
                    ", position='" + position + '\'' +
                    ", text='" + text + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position1 = (Position) o;
            return Objects.equals(startDate, position1.startDate) && Objects.equals(endDate, position1.endDate) && Objects.equals(position, position1.position) && Objects.equals(text, position1.text);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startDate, endDate, position, text);
        }
    }
}
