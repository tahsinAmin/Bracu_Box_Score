package com.highchart.trychart.modal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BracubBoxScore {
    private String title;
    private List<String> categories;
    private List<PlayerScore> series;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<PlayerScore> getSeries() {
        return series;
    }

    public void setSeries(List<PlayerScore> series) {
        this.series = series;
    }
}
