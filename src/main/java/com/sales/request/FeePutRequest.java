package com.sales.request;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FeePutRequest {
    @NotNull
    private Long id;
    private String mcc;
    private String cardSchemaId;
    private String cardSchemaDescription;
    private String serviceId;
    private String serviceDescription;
    private String numberOfInstallment;
    private String transactionTypeId;
    private String transactionTypeDescription;
    private String feePercent;
    private String numberOfDays;
    private String effectiveDate;
    private String expireDate;
    private String feeCategory;
    private String captureMethod;
}
