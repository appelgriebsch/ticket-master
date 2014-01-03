package de.fhdw.ify208.ticketmaster.dataaccess;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the t_category database table.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Category.All",
                query = "SELECT cat FROM Category cat")
})
@Table(name = "t_category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String description;
    private String displayname;
    private List<Event> Events;

    public Category() {
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


    //bi-directional many-to-one association to Event
    @OneToMany(mappedBy = "category")
    public List<Event> getEvents() {
        return this.Events;
    }

    public void setEvents(List<Event> Events) {
        this.Events = Events;
    }

}