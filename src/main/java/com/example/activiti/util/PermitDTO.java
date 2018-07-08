package com.example.activiti.util;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-20
 * @Time: 14:15
 */
public class PermitDTO {

    private String table;
    private String resource;
    private Integer number;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PermitDTO{" +
                "table='" + table + '\'' +
                ", resource='" + resource + '\'' +
                ", number=" + number +
                '}';
    }
}
