package com.nnk.springboot.domain;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDate;


@Entity
@Table(name = "curvepoint")
public class CurvePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "curve_id")
    private Integer curveId;
    @NotNull
    @Column(name = "term")
    private double term;

    @NotNull
    @Column(name = "curve_value")
    private double value;

    @NotNull
    @Column(name = "crationDate")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate;

    @NotNull
    @Column(name = "asOfDate")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate asOfDate;


    public CurvePoint() {

    }

    public CurvePoint(Integer curveId, double term, double value, LocalDate creationDate, LocalDate asOfDate) {
        this.curveId = curveId;
        this.term = term;
        this.value = value;
        this.creationDate = creationDate;
        this.asOfDate = asOfDate;
    }

    //getters & setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurveId() {
        return curveId;
    }

    public void setCurveId(Integer curveId) {
        this.curveId = curveId;
    }

    public double getTerm() {
        return term;
    }

    public void setTerm(double term) {
        this.term = term;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getAsOfDate() {
        return asOfDate;
    }

    public void setAsOfDate(LocalDate asOfDate) {
        this.asOfDate = asOfDate;
    }
}