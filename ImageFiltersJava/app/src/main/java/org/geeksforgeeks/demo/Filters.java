package org.geeksforgeeks.demo;

import com.mukesh.imageproccessing.filters.Filter;

public class Filters {
    private String title;
    private Filter filter;

    public Filters(String title, Filter filter) {
        this.title = title;
        this.filter = filter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }
}