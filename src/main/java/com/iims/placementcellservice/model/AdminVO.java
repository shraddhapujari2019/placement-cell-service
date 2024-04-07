package com.iims.placementcellservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class AdminVO {
    int admin_id;
    String title;
    String first_name;
    String middle_name;
    String last_name;
    String email;
    String mobile_number;
    String course;
    String college_name;
    String password;

}