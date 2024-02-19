package com.matheus.resumebuilder.model;

import java.util.Objects;

public class Title {

    private String entry;

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public Title() {

    }

    public Title(String entry) {
        this.entry = entry;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Title title)) return false;
        return Objects.equals(getEntry(), title.getEntry());
    }

    @Override public int hashCode() {
        return Objects.hash(getEntry());
    }
}
