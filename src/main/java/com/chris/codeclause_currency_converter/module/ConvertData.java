package com.chris.codeclause_currency_converter.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConvertData {
    private String from_this_currency;
    private String to_this_currency;
    @NotEmpty(message = "enter value")
    private Double amount_to_be_converted;
}
