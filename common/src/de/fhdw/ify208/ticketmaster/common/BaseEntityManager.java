package de.fhdw.ify208.ticketmaster.common;

import de.fhdw.ify208.ticketmaster.common.model.CountryListDTO;
import de.fhdw.ify208.ticketmaster.common.model.TypeCodeListDTO;
import de.fhdw.ify208.ticketmaster.dataaccess.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author ankariu
 */

public class BaseEntityManager {

    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketmaster.dataaccess");

    /**
     * Protected method initializing transaction-handling
     * @return instance of EntityManager from factory 
     */
    protected EntityManager _startup() {
        EntityManager _em = emf.createEntityManager();
        _em.getTransaction().begin();
        return _em;
    }


    /**
     * Protected method finishing transaction-handling
     * @param em instance of EntityManager that has to be closed 
     */
    protected void _cleanup(EntityManager em) {
        em.close();
    }


    /**
     * Protected method checking if customer exists (for security reasons)
     * @param customerID id of customer which has to be checked on database
     * @return instance of user belonging to customerID
     */
    protected User _checkCustomerExists(long customerID) {
        // local variables
        EntityManager _em = null;
        User _customer = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _customer = _em.find(User.class, customerID);

            // commit transaction
            _em.getTransaction().commit();
        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _customer;
    }


    /**
     * Protected method checking if event exists (for security reasons)
     * @param eventID id of event which has to be checked on database
     * @return instance of event belonging to eventID
     */
    protected Event _checkEventExists(long eventID) {
        // local variables
        EntityManager _em = null;
        Event _event = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _event = _em.find(Event.class, eventID);

            // commit transaction
            _em.getTransaction().commit();
        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _event;
    }

    /**
     * @param startDate
     * @param endDate
     * @param location
     * @return
     */
    protected Event _checkEventExistsOnLocation(Date startDate, Date endDate, Address location) {

        // local variables
        EntityManager _em = null;
        Event _event = null;

        Address address = _checkAddressExists(location.getAddressType().getDisplayname(),
                location.getAddressline(),
                location.getCityname(), location.getCountry().getIsocode());

        if (address == null)       // address does not exist -> event could not be scheduled at this address
            return _event;

        // logic
        try {

            // startup-sequence
            _em = _startup();

            // logical-sequence
            _event = (Event) _em.createNamedQuery("Event.findEventOnLocation")
                    .setParameter("locationID", address.getId())
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .getSingleResult();

            // commit transaction
            _em.getTransaction().commit();
        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _event;
    }

    /**
     * Protected method checking if address exists (for security reasons)
     * @param addressID id of address which has to be checked on database
     * @return instance of address belonging to addressID
     */
    protected Address _checkAddressExists(long addressID) {
        // local variables
        EntityManager _em = null;
        Address _address = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _address = _em.find(Address.class, addressID);

            // commit transaction
            _em.getTransaction().commit();
        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _address;
    }


    /**
     * Protected method checking if order exists (for security reasons)
     * @param orderID id of order which has to be checked on database
     * @return instance of order belonging to orderID
     */
    protected Order _checkOrderExists(long orderID) {
        // local variables
        EntityManager _em = null;
        Order _order = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _order = _em.find(Order.class, orderID);

            // commit transaction
            _em.getTransaction().commit();
        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _order;
    }


    /**
     * Protected method checking if artist exists (for security reasons)
     * @param artistID id of artist which has to be checked on database
     * @return instance of artist belonging to artistID
     */
    protected Artist _checkArtistExists(long artistID) {
        // local variables
        EntityManager _em = null;
        Artist _artist = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _artist = _em.find(Artist.class, artistID);

            // commit transaction
            _em.getTransaction().commit();
        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _artist;
    }


    /**
     * Protected method checking if order exists (for security reasons)
     * @param artistName name of artist which has to be checked on database
     * @return instance of artist belonging to artistName
     */
    protected Artist _checkArtistExists(String artistName) {
        // local variables
        EntityManager _em = null;
        Artist _artist = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _artist = (Artist) _em.createNamedQuery("Artist.findByArtistName")
		                               .setParameter("artistName", artistName).getSingleResult();

            // commit transaction
            _em.getTransaction().commit();
        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _artist;
    }


    /**
     * Protected method checking if genre exists (for security reasons)
     * @param genreName name of genre which has to be checked on database
     * @return instance of genre belonging to genreName
     */
    protected Genre _checkGenreExists(String genreName) {
        // local variables
        EntityManager _em = null;
        Genre _genre = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _genre = (Genre) _em.createNamedQuery("Genre.findByName").setParameter("genreName", genreName).getSingleResult();

            // commit transaction
            _em.getTransaction().commit();
        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _genre;
    }

    /**
     * @return instance of TypeCodeListDTO
     */
    public TypeCodeListDTO getAddressTypes() {

        TypeCodeListDTO listDTO = new TypeCodeListDTO();
        EntityMapper mapper = new EntityMapper();

        List<AddressType> _listOfAddressTypes = this._getAllAddressTypes();
        for (Iterator<AddressType> iter = _listOfAddressTypes.iterator(); iter.hasNext(); ) {

            listDTO.addTypeCodeToList(mapper.getTypeCodeDTOFromAddressType(iter.next()));
        }

        if (listDTO.getTypeCodeDTOList().size() > 0) {
            listDTO.setReturncode(0);
        } else {
            listDTO.setReturncode(99);
            listDTO.setMessage("Error getting address types from database");
        }
        return listDTO;
    }

    private List<AddressType> _getAllAddressTypes() {

        // local variables
        EntityManager _em = null;
        List<AddressType> _result = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _result = _em.createNamedQuery("AddressType.All").getResultList();

            // commit transaction
            _em.getTransaction().commit();

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _result;
    }

    public CountryListDTO getCountries() {

        CountryListDTO listDTO = new CountryListDTO();
        EntityMapper mapper = new EntityMapper();

        List<Country> _listOfCountries = this._getAllCountries();
        for (Iterator<Country> iter = _listOfCountries.iterator(); iter.hasNext(); ) {

            listDTO.addCountryToList(mapper.getCountryDTOFromCountry(iter.next()));
        }

        if (listDTO.getCountryDTOList().size() > 0) {
            listDTO.setReturncode(0);
        } else {
            listDTO.setReturncode(99);
            listDTO.setMessage("Error getting address types from database");
        }
        return listDTO;
    }

    private List<Country> _getAllCountries() {

        // local variables
        EntityManager _em = null;
        List<Country> _result = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _result = _em.createNamedQuery("Country.All").getResultList();

            // commit transaction
            _em.getTransaction().commit();

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _result;
    }

    protected Address _createAddress(Address address) {

        // local variables
        EntityManager _em = null;
        Address result = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _em.persist(address);

            // commit transaction
            _em.getTransaction().commit();

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
        } finally {
            // close-sequence
            _cleanup(_em);
        }

        return _checkAddressExists(address.getAddressType().getDisplayname(),
                address.getAddressline(),
                address.getCityname(),
                address.getCountry().getIsocode());
    }

    /**
     * @param typeCode
     * @param addressLine
     * @param cityName
     * @param countryCode
     * @return
     */
    protected Address _checkAddressExists(String typeCode, String addressLine,
                                          String cityName, String countryCode) {

        // local variables
        EntityManager _em = null;
        Address _result = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _result = (Address) _em.createNamedQuery("Address.findAddress")
                    .setParameter("adrLine", addressLine)
                    .setParameter("adrType", typeCode)
                    .setParameter("cityName", cityName)
                    .setParameter("countryCode", countryCode)
                    .getSingleResult();

            // commit transaction
            _em.getTransaction().commit();

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _result;
    }
}