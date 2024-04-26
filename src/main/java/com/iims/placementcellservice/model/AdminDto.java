package com.iims.placementcellservice.model;

import lombok.Data;

@Data
public class AdminDto {
    int adminId;
    String title;
    String firstName;
    String middleName;
    String lastName;
    String email;
    String mobileNumber;
    String course;
    String collegeName;
    String username;
}
