package com.iims.placementcellservice.model;

import lombok.Data;

@Data
public class ResetDto {

    String username;
    String validationString;
    String newPassword;
}
