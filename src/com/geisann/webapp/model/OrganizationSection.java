package com.geisann.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationSection extends AbstractSection {

    private static final long serialVersionUID = 1L;

    private List<Organization> list;

    public OrganizationSection() {
    }

    public OrganizationSection(List<Organization> list) {
        Objects.requireNonNull(list, "list must not be null");
        this.list = list;
    }

    public OrganizationSection(Organization... list) {
        this(Arrays.asList(list));
    }

    public List<Organization> getList() {
        return list;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationSection that = (OrganizationSection) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
