package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Accounts")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "username", nullable = false)
    @NotBlank(message = "{aUNblank}")
    private String username;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "{aPWblank}")
    private String password;

    @Column(name = "fullname", nullable = false)
    @NotBlank(message = "{aFNblank}")
    private String fullname;

    @Column(name = "email", nullable = false)
    @NotBlank(message = "{aEMblank}")
    @Email(message = "{aEMregex}")
    private String email;

    @Column(name = "admin")
    @NotNull(message = "{aADMnull}")
    private Integer admin;

}
