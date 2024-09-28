package com.tournament.authentication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String username;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private Integer mobileNo;
    private String emailId;
    private Integer age;
//    {"userId":352,"username":"string","password":"string","confirmPassword":null,"firstName":"string","LastName":"string","mobileNo":0,"emailId":"string","age":0,"lastName":"string"}
}
