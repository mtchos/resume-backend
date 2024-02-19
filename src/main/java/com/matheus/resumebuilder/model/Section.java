package com.matheus.resumebuilder.model;

import java.util.List;
import java.util.Objects;

public class Section {

    private String title;

    private String subtitle;

    private List<Sentence> sentences;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Section section)) return false;
        return Objects.equals(getTitle(), section.getTitle()) &&
               Objects.equals(subtitle, section.subtitle) &&
               Objects.equals(sentences, section.sentences);
    }

    @Override public int hashCode() {
        return Objects.hash(getTitle(), subtitle, sentences);
    }
}
