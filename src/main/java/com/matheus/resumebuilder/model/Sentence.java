package com.matheus.resumebuilder.model;

import java.util.List;
import java.util.Objects;

public class Sentence {

    private String entry;

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public Sentence() {

    }

    public Sentence(String entry) {
        this.entry = entry;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence sentence)) return false;
        return Objects.equals(getEntry(), sentence.getEntry());
    }

    @Override public int hashCode() {
        return Objects.hash(getEntry());
    }
}
