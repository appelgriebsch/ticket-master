import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.fhdw.ify208.ticketmaster.common.model.AddressDTO;
import de.fhdw.ify208.ticketmaster.common.model.ArtistDTO;
import de.fhdw.ify208.ticketmaster.common.model.BaseDTO;
import de.fhdw.ify208.ticketmaster.common.model.CountryDTO;
import de.fhdw.ify208.ticketmaster.common.model.CustomerDTO;
import de.fhdw.ify208.ticketmaster.common.model.EventDTO;
import de.fhdw.ify208.ticketmaster.common.model.TypeCodeDTO;
import de.fhdw.ify208.ticketmaster.model.EventManager;

public class EventServiceTest {

	private EventManager _theEventManager = null;

	@Before
	public void init() {

		_theEventManager = EventManager.getInstance();
	}

	@Test
	public void createEvent() {
		EventDTO event = new EventDTO();
		AddressDTO location = new AddressDTO();
		TypeCodeDTO tpCode = new TypeCodeDTO();
		TypeCodeDTO tpCode1 = new TypeCodeDTO();
		CountryDTO country = new CountryDTO();
		BaseDTO result = new BaseDTO();
		Date d1 = new Date(2011, 12, 31, 20, 0,0);
		Date d2 = new Date(2011, 12, 31, 21, 0,0);
		country.setIsoCode("TUR");
		tpCode.setId(1);
		tpCode.setDescription("Test");
		tpCode1.setId(1);
		location.setid(new Long(3));
		location.setAddressType(tpCode1);
		location.setCountry(country);
		location.setAddressLine("TEST MARK");
		location.setStreetName("TEST MARK");
		location.setZipCode("33333");
		location.setCityName("TEST MARK");
		location.setDistrict("NRW");
		event.setid(new Long(3));
		event.setAdUrl("Test");
		event.setDescription("TEST MARK");
		event.setLocation(location);
		event.setMaxNoOfTickets(20);
		event.setTicketPrice(new BigDecimal(2.00));
		event.setCategory(tpCode);
		event.setEndDate(d2);
		event.setStartDate(d1);
		result = _theEventManager.registerNewEvent(event);
		Assert.assertTrue("New Event:",result.getReturncode() == 0);
	}

	@Test
	public void createArtist() {
		BaseDTO result = new BaseDTO();
		ArtistDTO artist = new ArtistDTO();
		TypeCodeDTO tpCode = new TypeCodeDTO();
		tpCode.setId(1);
		tpCode.setDescription("Test");
		artist.setid(new Long(4));
		artist.setStageName("Test4");
		artist.setFirstName("First");
		artist.setLastName("Last");
		artist.setMessage("Test");
		artist.setGenre(tpCode);
		artist.setMessage("Test");
		result = _theEventManager.registerNewArtist(artist);
		Assert.assertTrue("New Artist:",result.getReturncode() == 0);
		
		artist.setid(new Long(2));
		artist.setStageName("Test");
		artist.setFirstName("First");
		artist.setLastName("Last");
		artist.setMessage("Test");
		artist.setGenre(tpCode);
		artist.setMessage("Test");
		result = _theEventManager.registerNewArtist(artist);
		Assert.assertTrue("New Artist not registered:",result.getReturncode() != 0);	
	}
	
	@Test
	public void cancelEvent() {
		EventDTO event = new EventDTO();
		BaseDTO result = new BaseDTO();
		event.setid(new Long(2));
		result = _theEventManager.cancelEvent(event);
		Assert.assertTrue("Cancel event:",result.getReturncode() == 0);
		
		event.setid(new Long(3));
		result = _theEventManager.cancelEvent(event);
		Assert.assertTrue("Cancel event not successfull:",result.getReturncode() != 0);		
	}
	
	@Test
	public void rateEvent() {
		EventDTO event = new EventDTO();
		BaseDTO result = new BaseDTO();
		CustomerDTO customer = new CustomerDTO();
		customer.setid(new Long(10));
		event.setid(new Long(1));
		result = _theEventManager.rateEvent(event,customer,5,"Test");
		Assert.assertTrue("Rate event:",result.getReturncode() == 0);
		
		event.setid(new Long(2));
		result = _theEventManager.rateEvent(event,customer,5,"Test");
		Assert.assertTrue("Rate not possible event:",result.getReturncode() != 0);		
	}


}
