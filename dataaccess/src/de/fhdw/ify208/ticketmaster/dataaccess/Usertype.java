package de.fhdw.ify208.ticketmaster.dataaccess;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the t_usertype database table.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Usertype.All",
                query = "SELECT ut FROM Usertype ut")
})
@Table(name = "t_usertype")
public class Usertype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private String description;
    private String displayname;

    public Usertype() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(length = 2147483647)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Column(nullable = false, length = 20)
    public String getDisplayname() {
        return this.displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

}