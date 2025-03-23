package com.sales.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FeePostRequest {
    @NotBlank(message = "The field 'mcc' is required")
    private String mcc;
    @NotBlank(message = "The field 'cardSchemaId' is required")
    private String cardSchemaId;
    @NotBlank(message = "The field 'cardSchemaDescription' is required")
    private String cardSchemaDescription;
    @NotBlank(message = "The field 'serviceId' is required")
    private String serviceId;
    @NotBlank(message = "The field 'serviceDescription' is required")
    private String serviceDescription;
    @NotBlank(message = "The field 'numberOfInstallment' is required")
    private String numberOfInstallment;
    @NotBlank(message = "The field 'transactionTypeId' is required")
    private String transactionTypeId;
    @NotBlank(message = "The field 'transactionTypeDescription' is required")
    private String transactionTypeDescription;
    @NotBlank(message = "The field 'feePercent' is required")
    private String feePercent;
    @NotBlank(message = "The field 'numberOfDays' is required")
    private String numberOfDays;
    @NotBlank(message = "The field 'effectiveDate' is required")
    private String effectiveDate;
    @NotBlank(message = "The field 'expireDate' is required")
    private String expireDate;
    @NotBlank(message = "The field 'feeCategory' is required")
    private String feeCategory;
    @NotBlank(message = "The field 'captureMethod' is required")
    private String captureMethod;
}
