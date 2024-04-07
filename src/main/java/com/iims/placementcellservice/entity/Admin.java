package com.iims.placementcellservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "admin_info")
@Data
public class Admin {
    @Id
    int admin_id;
    String title;
    String first_name;
    String middle_name;
    String last_name;
    String email;
    String mobile_number;
    String course;
    String college_name;
}
