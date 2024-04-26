package com.iims.placementcellservice.model;

import lombok.Data;

@Data
public class ResetDto {

    String userName;
    String validationString;
    String newPassword;
}
