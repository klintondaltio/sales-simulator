package com.sales.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DefaultErrorMessage (int value, String message) {

}
