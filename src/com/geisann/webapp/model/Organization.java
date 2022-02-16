package com.geisann.webapp.model;

import com.geisann.webapp.util.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.geisann.webapp.util.DateUtil.of;

@XmlAccessorType(XmlAccessType.FIELD)
public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;

    private Link homePage;
    private List<Position> positions = new ArrayList<>();

    public Organization() {
    }

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

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Position implements Serializable{
        @XmlJavaTypeAdapter(LocalDateAdapter.class)
        private LocalDate startDate;
        @XmlJavaTypeAdapter(LocalDateAdapter.class)
        private LocalDate endDate;
        private String position;
        private String text;

        public Position() {
        }

        public Position(int startYear, int startMonth, String title, String description) {
            this(of(startYear, startMonth), LocalDate.now(), title, description);
        }

        public Position(int startYear, int startMonth, int endYear, int endMonth, String position, String text) {
            this(of(startYear, startMonth), of(endYear, endMonth), position, text);
        }

        public Position(LocalDate startDate, LocalDate endDate, String position, String text) {
            Objects.requireNonNull(startDate, "startDate must not be null");
            Objects.requireNonNull(endDate, "endDate must not be null");
            Objects.requireNonNull(position, "position must not be null");
            this.startDate = startDate;
            this.endDate = endDate;
            this.position = position;
            this.text = text;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public LocalDate getEndDate() {
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
