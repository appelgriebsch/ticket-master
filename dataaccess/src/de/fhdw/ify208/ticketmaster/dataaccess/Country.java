package de.fhdw.ify208.ticketmaster.dataaccess;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the t_country database table.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Country.All",
                query = "SELECT ctr FROM Country ctr")
})
@Table(name = "t_country")
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;
    private String isocode;
    private String description;
    private String name;

    public Country() {
    }


    @Id
    @Column(unique = true, nullable = false, length = 3)
    public String getIsocode() {
        return this.isocode;
    }

    public void setIsocode(String isocode) {
        this.isocode = isocode;
    }


    @Column(length = 2147483647)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Column(nullable = false, length = 80)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}