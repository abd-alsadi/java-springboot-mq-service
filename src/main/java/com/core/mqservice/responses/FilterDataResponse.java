package com.core.mqservice.responses;

import com.core.mqservice.constants.ModConstant;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class FilterDataResponse {
    private String message;
    private Object data;
    private int count;
    private  ModConstant.StatusCode statusCode;
}
