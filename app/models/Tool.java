package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Tool extends Model {

    @Id
    public Long id;

    public String title;

    public String price;

    public String description;

    public String owner;


    /*public List<Tool> toolList:*/


    public static Finder<Long, Tool> find = new Finder<Long, Tool>(Tool.class);

}
