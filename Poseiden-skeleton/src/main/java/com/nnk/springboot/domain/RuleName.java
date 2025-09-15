package com.nnk.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Entity
@Table(name = "rulename")
public class RuleName {
    // TODO: Map columns in data table RULENAME with corresponding java fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    private String Name;

    private String Description;
    private String Json;
    private String template;
    private String SQLStr;
    private String SQLPart;

    public RuleName(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getJson() {
        return Json;
    }

    public void setJson(String json) {
        Json = json;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getSQLStr() {
        return SQLStr;
    }

    public void setSQLStr(String SQLStr) {
        this.SQLStr = SQLStr;
    }

    public String getSQLPart() {
        return SQLPart;
    }

    public void setSQLPart(String SQLPart) {
        this.SQLPart = SQLPart;
    }

    public RuleName(String Name, String Description, String Json, String template, String SQLStr, String SQLPart) {
        this.Name = Name;
        this.Description = Description;
        this.Json = Json;
        this.template = template;
        this.SQLStr = SQLStr;
        this.SQLPart = SQLPart;
    }

}
