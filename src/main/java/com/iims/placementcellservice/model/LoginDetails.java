package com.iims.placementcellservice.model;

import lombok.Data;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
@Data
public class LoginDetails {
    long login_id;
    String password;
    boolean is_admin;
    Date last_login_date;
    Date last_password_reset;
    Date password_expiration_date;
    String Account_status;
}

