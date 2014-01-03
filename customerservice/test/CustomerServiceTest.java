import de.fhdw.ify208.ticketmaster.common.model.AddressDTO;
import de.fhdw.ify208.ticketmaster.common.model.AddressListDTO;
import de.fhdw.ify208.ticketmaster.common.model.BaseDTO;
import de.fhdw.ify208.ticketmaster.common.model.CountryDTO;
import de.fhdw.ify208.ticketmaster.common.model.CustomerDTO;
import de.fhdw.ify208.ticketmaster.common.model.GenderType;
import de.fhdw.ify208.ticketmaster.common.model.TypeCodeDTO;
import de.fhdw.ify208.ticketmaster.model.CustomerManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * @author mkuenert
 *
*/


public class CustomerServiceTest {

	private CustomerManager _theCustomerManager = null;

	@Before
	public void init() {

		_theCustomerManager = CustomerManager.getInstance();
	}

	@Test
	public void registerNewCustomer() {

		TypeCodeDTO tpCode = new TypeCodeDTO();
		tpCode.setName("Private");
		tpCode.setId(1);

		CustomerDTO newCustomer = new CustomerDTO();
		newCustomer.setBirthdate(new Date(1976,10,9));
		newCustomer.setEmail("info@appelgriebsch.com");
		newCustomer.setFirstName("Andreas");
		newCustomer.setGenderType(GenderType.Male);
		newCustomer.setLastName("Gerlach");
		newCustomer.setPassword("12345");       // TODO: encrypt password !!!
		newCustomer.setSalutation("Hr.");
		newCustomer.setType(tpCode);
		newCustomer.setUserName("appelgriebsch");

		BaseDTO result = _theCustomerManager.registerCustomer(newCustomer);

		Assert.assertTrue("Customer created", result.getReturncode() == 0);
	}

	@Test
	public void signOnCustomer() {

		CustomerDTO customer = _theCustomerManager.signOn("appelgriebsch", "12345");
		Assert.assertTrue("Customer signed on", customer.getReturncode() == 0);

		customer = _theCustomerManager.signOn("appelgriebsch", "54321");
		Assert.assertTrue("Password mismatch", customer.getReturncode() != 0);

		customer = _theCustomerManager.signOn("nonexistcustomer", "111111");
		Assert.assertTrue("Customer didn't exist", customer.getReturncode() != 0);
	}

	@Test
		public void changeCustomerPassword() {

		BaseDTO result = _theCustomerManager.changePassword("appelgriebsch", "12345", "1234");
		Assert.assertTrue("Password change successfull", result.getReturncode() == 0);
		
		result = _theCustomerManager.changePassword("test", "12345", "1234");
		Assert.assertTrue("Password change not successfull", result.getReturncode() != 0);
	}

	@Test
	public void getCustomerAddresses() {
		CustomerDTO customer = _theCustomerManager.signOn("appelgriebsch", "1234");
		AddressListDTO result = _theCustomerManager.getCustomerAddresses(customer);
		Assert.assertTrue("Got Customer Adresses:",result.getReturncode() == 0);
		
		customer = _theCustomerManager.signOn("test", "1234");
		result = _theCustomerManager.getCustomerAddresses(customer);
		Assert.assertTrue("Could not get Customer Adresses:",result.getReturncode() != 0);
	}

	@Test
	public void maintainCustomerAddress() {
		CustomerDTO customer = _theCustomerManager.signOn("appelgriebsch", "1234");
		AddressDTO address = new AddressDTO();
		TypeCodeDTO tpCode = new TypeCodeDTO();
		tpCode.setName("Private");
		tpCode.setId(1);
		CountryDTO countryDTO = new CountryDTO();
		countryDTO.setIsoCode("TUR");
		address.setAddressType(tpCode);
		address.setAddressLine("Mustetstrasse 7");
		address.setCityName("Musterstadt");
		address.setCountry(countryDTO);
		address.setDistrict("NRW");
		address.setZipCode("33397");
		address.setStreetName("Mustetstrasse 7");
		address.setMessage("TEST");
		AddressDTO result = _theCustomerManager.maintainAddress(customer,address);
		Assert.assertTrue("Maintain address:",result.getReturncode() == 0);
	}

	@Test
	public void removeCustomerAddress() {
		CustomerDTO customer = _theCustomerManager.signOn("appelgriebsch", "1234");
		AddressDTO address = new AddressDTO();
		TypeCodeDTO tpCode = new TypeCodeDTO();
		tpCode.setName("Private");
		tpCode.setId(1);
		CountryDTO countryDTO = new CountryDTO();
		countryDTO.setIsoCode("TUR");
		address.setid(new Long(7));
		address.setAddressType(tpCode);
		address.setAddressLine("Mustetstrasse 7");
		address.setCityName("Musterstadt");
		address.setCountry(countryDTO);
		address.setDistrict("NRW");
		address.setZipCode("33397");
		address.setStreetName("Mustetstrasse 7");
		address.setMessage("TEST");
		BaseDTO result = _theCustomerManager.removeAddress(customer, address);
		Assert.assertTrue("Maintain address:",result.getReturncode() == 0);
	}

	/*@Test
	public void closeCustomerProfile() {

		CustomerDTO customer = _theCustomerManager.signOn("appelgriebsch", "1234");
		BaseDTO result = _theCustomerManager.closeCustomerProfile(customer);
		Assert.assertTrue("Close profile:", result.getReturncode() == 0);
	}*/
	
}
