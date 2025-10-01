package com.nnk.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.sql.Timestamp;


@Entity
@Table(name = "trade")
public class Trade {
    // TODO: Map columns in data table TRADE with corresponding java fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String account;

    private String type;

    private Integer buyQuantity;

    public Trade(){
    }

    public Trade(Integer id, String account, String type, Integer buyQuantity){
        this.id = id;
        this.account = account;
        this.type = type;
        this.buyQuantity = buyQuantity;
    }


    //getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = Id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {

        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(Integer buyQuantity) {
        this.buyQuantity = buyQuantity;
    }
}
