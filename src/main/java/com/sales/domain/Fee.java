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
@Data
public class Fee {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String mcc;
    @Column(nullable = false, unique = true)
    private String cardSchemaId;
    @Column(nullable = false)
    private String cardSchemaDescription;
    @Column(nullable = false, unique = true)
    private String serviceId;
    @Column(nullable = false)
    private String serviceDescription;
    @Column(nullable = false)
    private String numberOfInstallment;
    @Column(nullable = false, unique = true)
    private String transactionTypeId;
    @Column(nullable = false)
    private String transactionTypeDescription;
    @Column(nullable = false)
    private String feePercent;
    @Column(nullable = false)
    private String numberOfDays;
    @Column(nullable = false)
    private String effectiveDate;
    @Column(nullable = false)
    private String expireDate;
    @Column(nullable = false)
    private String feeCategory;
    @Column(nullable = false, unique = true)
    private String captureMethod;

}
