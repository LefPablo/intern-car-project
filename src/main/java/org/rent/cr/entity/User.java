package org.rent.cr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.rent.cr.dto.view.View;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@JsonView(View.Public.class)
public class User extends GeneralEntity {
    @JsonIgnore
    @OneToOne (mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Employee employee;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders;

    @Column (name = "username")
    @NotBlank(message = "Name must be set")
    private String name;

    @Column (name = "userage")
    @Min(value = 18, message = "User must be 18 or older")
    private Integer age;


    @Column (name = "userpassport")
    private String passport;

    @Column (name = "userphone")
    @NotBlank(message = "User phone must be set")
    private String phone;

    @Column (name = "userdrivexp")
    @Min(value = 1, message = "Drive experience must be 1 and over")
    private Integer drivexp;

    @Column (name = "userdrivlic")
    private String drivlic;

    @Column (name = "useremail")
    @Email(message = "Email is not correct")
    private String email;
}
