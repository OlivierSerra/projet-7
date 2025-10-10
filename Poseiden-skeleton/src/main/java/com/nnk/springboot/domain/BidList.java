package com.nnk.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "bidlist")
public class BidList {
    // TODO: Map columns in data table BIDLIST with corresponding java fields
    /**
     * déclaration des varaibles
     */

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer bidListId;
    private String account;
    private String type;
    @DecimalMin(value = "0.0", inclusive = false)
    private double bidQuantity;
    @DecimalMin(value = "0.0", inclusive = false)
    private double askQuantity;
    private double bid;
    private double ask;
    private String benchmark;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate bidListDate;
    private String commentary;
    private String security;
    private String status;
    private String trader;
    private String book;
    private String creationName;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate;
    private String revisionName;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate revisionDate;
    private String dealName;
    private String dealType;
    private String sourceListId;
    private String side;

    //Constructeurs*

    /**
     * constructeurs vides
     */
    public BidList(){}

    /**
     * constructeurs pleins
     */

    public BidList(Integer bidListId, String account, String type, double bidQuantity,
                   double askQuantity, double bid, double ask, String benchmark,
                   LocalDate bidListDate, String commentary, String security, String status,
                   String trader, String book, String creationName, LocalDate creationDate,
                   String revisionName, LocalDate revisionDate, String dealName, String dealType,
                   String sourceListId, String side) {
        this.bidListId = bidListId;
        this.account = account;
        this.type = type;
        this.bidQuantity = bidQuantity;
        this.askQuantity = askQuantity;
        this.bid = bid;
        this.ask = ask;
        this.benchmark = benchmark;
        this.bidListDate = bidListDate;
        this.commentary = commentary;
        this.security = security;
        this.status = status;
        this.trader = trader;
        this.book = book;
        this.creationName = creationName;
        this.creationDate = creationDate;
        this.revisionName = revisionName;
        this.revisionDate = revisionDate;
        this.dealName = dealName;
        this.dealType = dealType;
        this.sourceListId = sourceListId;
        this.side = side;
    }

    //getters et setters
    public Integer getBidListId() {
        return bidListId;
    }

    public void setBidListId(Integer bidListId) {
        this.bidListId = bidListId;
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

    public double getBidQuantity() {
        return bidQuantity;
    }

    public void setBidQuantity(double bidQuantity) {
        this.bidQuantity = bidQuantity;
    }

    public double getAskQuantity() {
        return askQuantity;
    }

    public void setAskQuantity(double askQuantity) {
        this.askQuantity = askQuantity;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public String getBenchmark() {
        return benchmark;
    }

    public void setBenchmark(String benchmark) {
        this.benchmark = benchmark;
    }

    public LocalDate getBidListDate() {
        return bidListDate;
    }

    public void setBidListDate(LocalDate bidListDate) {
        this.bidListDate = bidListDate;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getCreationName() {
        return creationName;
    }

    public void setCreationName(String creationName) {
        this.creationName = creationName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getRevisionName() {
        return revisionName;
    }

    public void setRevisionName(String revisionName) {
        this.revisionName = revisionName;
    }

    public LocalDate getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(LocalDate revisionDate) {
        this.revisionDate = revisionDate;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getSourceListId() {
        return sourceListId;
    }

    public void setSourceListId(String sourceListId) {
        this.sourceListId = sourceListId;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }
}
