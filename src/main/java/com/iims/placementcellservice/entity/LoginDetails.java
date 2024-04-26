package com.iims.placementcellservice.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "login_details")
@Data
public class LoginDetails {
    @Id
    String userName;
    String password;
    String isAdmin;
    Date lastLoginDate;
    Date lastPasswordReset;
    Date passwordExpirationDate;
    String accountStatus;
}

