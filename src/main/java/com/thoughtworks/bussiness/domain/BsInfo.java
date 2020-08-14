package com.thoughtworks.bussiness.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class BsInfo {
    @NotNull
    private String productName;
    @NotNull
    private float productPrice;
    @NotNull
    private float productUnit;
    @NotNull
    private String productUrl;
}
