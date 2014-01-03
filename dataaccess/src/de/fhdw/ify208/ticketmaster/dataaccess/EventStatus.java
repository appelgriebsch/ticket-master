package de.fhdw.ify208.ticketmaster.dataaccess;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: appelgriebsch
 * Date: 11/6/11
 * Time: 8:51 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "EventStatus.All",
                query = "SELECT evt FROM EventStatus evt")
})
@Table(name = "t_eventstatus")
public class EventStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String description;
    private String displayname;

    public final Integer STATUS_OPEN = 1;
    public final Integer STATUS_COMPLETED = 2;
    public final Integer STATUS_VOIDED = 3;

    public EventStatus() {
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