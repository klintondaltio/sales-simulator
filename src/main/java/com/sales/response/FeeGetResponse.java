package com.sales.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FeeGetResponse {
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
}
