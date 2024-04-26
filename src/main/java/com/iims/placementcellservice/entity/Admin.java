package com.iims.placementcellservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "admin_info")
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
