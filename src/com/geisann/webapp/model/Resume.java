package com.geisann.webapp.model;

import java.io.Serializable;
import java.util.*;

/**
 * Initial resume class
 */
public class Resume implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String uuid;
    private final String fullName;
    private final Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private final Map<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public String getContacts(ContactType type) {
        return contacts.get(type);
    }

    public void setContacts(ContactType type, String value) {
        contacts.put(type, value);
    }

    public AbstractSection getSections(SectionType type) {
        return sections.get(type);
    }

    public void setSections(SectionType type, AbstractSection section) {
        sections.put(type, section);
    }

    @Override
    public String toString() {
        return uuid + '\'' + fullName + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) && Objects.equals(fullName, resume.fullName) && Objects.equals(contacts, resume.contacts) && Objects.equals(sections, resume.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, contacts, sections);
    }
}
