package models;

import com.avaje.ebean.validation.Email;
import com.avaje.ebean.validation.NotEmpty;
import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 10/28/12
 * Time: 1:07 PM
 */
@Entity
@Table(name="employee")
public class Employee implements Serializable {
    @Column(name="id")
    @Id
    public Long id;

    @NotEmpty
    @Column(name="first_name")
    public String firstName;

    @Column(name="last_name")
    public String lastName;

    public String address;

    @NotEmpty
    public String code;

    public String phone;

    @Email
    public String email;
}
