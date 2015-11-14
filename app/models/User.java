package models;


import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends Model {

    @Id
    public Long id;

    public String name;

    public String email;

    public String username;

    public String password;

    public String phone;

}