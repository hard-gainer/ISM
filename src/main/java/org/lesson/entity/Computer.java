package org.lesson.entity;

import java.time.LocalDate;
import java.util.List;

public class Computer {
    private String type;
    private String func;
    private LocalDate productionDate;
    private List<String> tests;
    private LocalDate testDeadline;

    public Computer(String type, String func, LocalDate productionDate, List<String> tests, LocalDate testDeadline) {
        this.type = type;
        this.func = func;
        this.productionDate = productionDate;
        this.tests = tests != null ? tests : List.of();
        this.testDeadline = testDeadline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public List<String> getTests() {
        return tests;
    }

    public void setTests(List<String> tests) {
        this.tests = tests;
    }

    public LocalDate getTestDeadline() {
        return testDeadline;
    }

    public void setTestDeadline(LocalDate testDeadline) {
        this.testDeadline = testDeadline;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "type='" + type + '\'' +
                ", func='" + func + '\'' +
                ", productionDate='" + productionDate + '\'' +
                ", tests=" + tests +
                ", testDeadline='" + testDeadline + '\'' +
                '}';
    }
}
