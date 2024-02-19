package com.matheus.resumebuilder.model;

import java.util.List;
import java.util.Objects;

public class Resume {

    private String contactInfo;

    private String name;

    private List<Section> sections;

    public Resume() {

    }

    public Resume(final String name, final String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public Resume(final String name) {
        this.name = name;
    }

    public Resume(final List<Section> sections) {
        this.sections = sections;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(String contactInfo, String name, List<Section> sections) {
        this.sections = sections;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resume resume)) return false;
        return Objects.equals(getContactInfo(), resume.getContactInfo()) &&
               Objects.equals(getName(), resume.getName()) &&
               Objects.equals(getSections(), resume.getSections());
    }

    @Override public int hashCode() {
        return Objects.hash(getContactInfo(), getName(), getSections());
    }
}
