package com.company.example.service.specifications;

public class FilterCriteria {
    private String field;
    private Object value;

    public FilterCriteria() {
    }

    public FilterCriteria(String field, Object value) {
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }


    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
