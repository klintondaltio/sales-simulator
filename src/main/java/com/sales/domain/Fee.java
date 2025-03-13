package com.sales.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@With
@Entity
public class Fee {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String mcc;
    @Column(nullable = false)
    private String cardSchemaId;
    @Column(nullable = false, unique = true)
    private String cardSchemaDescription;
    @Column(nullable = false, unique = true)
    private String serviceId;
    @Column(nullable = false, unique = true)
    private String serviceDescription;
    @Column(nullable = false, unique = true)
    private String numberOfInstallment;
    @Column(nullable = false, unique = true)
    private String transactionTypeId;
    @Column(nullable = false, unique = true)
    private String transactionTypeDescription;
    @Column(nullable = false, unique = true)
    private String feePercent;
    @Column(nullable = false, unique = true)
    private String numberOfDays;
    @Column(nullable = false)
    private String effectiveDate;
    @Column(nullable = false)
    private String expireDate;
    @Column(nullable = false)
    private String feeCategory;
    @Column(nullable = false, unique = true)
    private String captureMethod;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getCardSchemaId() {
        return cardSchemaId;
    }

    public void setCardSchemaId(String cardSchemaId) {
        this.cardSchemaId = cardSchemaId;
    }

    public String getCardSchemaDescription() {
        return cardSchemaDescription;
    }

    public void setCardSchemaDescription(String cardSchemaDescription) {
        this.cardSchemaDescription = cardSchemaDescription;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getNumberOfInstallment() {
        return numberOfInstallment;
    }

    public void setNumberOfInstallment(String numberOfInstallment) {
        this.numberOfInstallment = numberOfInstallment;
    }

    public String getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(String transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public String getTransactionTypeDescription() {
        return transactionTypeDescription;
    }

    public void setTransactionTypeDescription(String transactionTypeDescription) {
        this.transactionTypeDescription = transactionTypeDescription;
    }

    public String getFeePercent() {
        return feePercent;
    }

    public void setFeePercent(String feePercent) {
        this.feePercent = feePercent;
    }

    public String getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(String numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getFeeCategory() {
        return feeCategory;
    }

    public void setFeeCategory(String feeCategory) {
        this.feeCategory = feeCategory;
    }

    public String getCaptureMethod() {
        return captureMethod;
    }

    public void setCaptureMethod(String captureMethod) {
        this.captureMethod = captureMethod;
    }
}
