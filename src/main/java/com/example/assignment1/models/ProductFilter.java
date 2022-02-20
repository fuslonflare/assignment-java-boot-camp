package com.example.assignment1.models;

public class ProductFilter extends BaseFilter {
    private String keyword;

    public ProductFilter(int page, int itemPerPage, String keyword) {
        this.setPage(page);
        this.setItemPerPage(itemPerPage);
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
