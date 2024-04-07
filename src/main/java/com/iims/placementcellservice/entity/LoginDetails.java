package com.iims.placementcellservice.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "login_details")
@Data
public class LoginDetails {
    @Id
    long login_id;
    String password;
    boolean is_admin;
    Date last_login_date;
    Date last_password_reset;
    Date password_expiration_date;
    String Account_status;
}

