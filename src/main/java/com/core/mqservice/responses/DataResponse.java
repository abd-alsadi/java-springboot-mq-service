package com.core.mqservice.responses;

import com.core.mqservice.constants.ModConstant;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class DataResponse {
    private String message;
    private Object data;
    private  ModConstant.StatusCode statusCode;
}
