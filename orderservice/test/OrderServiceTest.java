import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.fhdw.ify208.ticketmaster.common.model.AddressDTO;
import de.fhdw.ify208.ticketmaster.common.model.BaseDTO;
import de.fhdw.ify208.ticketmaster.common.model.CustomerDTO;
import de.fhdw.ify208.ticketmaster.common.model.EventDTO;
import de.fhdw.ify208.ticketmaster.common.model.OrderDTO;
import de.fhdw.ify208.ticketmaster.model.CustomerManager;
import de.fhdw.ify208.ticketmaster.model.EventManager;
import de.fhdw.ify208.ticketmaster.model.OrderManager;

public class OrderServiceTest {

	private OrderManager _theOrderManager = null;
	
	@Before
	public void init() {

		_theOrderManager = OrderManager.getInstance();
	}

	@Test
	public void placeOrder() {
		// TODO Auto-generated method stub
		OrderDTO result = new OrderDTO();
		EventDTO event = new EventDTO();
		CustomerDTO customer = new CustomerDTO();
		AddressDTO shipaddress = new AddressDTO();
		AddressDTO billaddress = new AddressDTO();
		int quantity=1;
		
		event.setid(new Long(1));
		customer.setid(new Long(10));
		shipaddress.setid(new Long(7));
		billaddress.setid(new Long(7));
		result = _theOrderManager.placeOrder(event, customer, shipaddress, billaddress, quantity);
		Assert.assertTrue("Place order:",result.getReturncode() == 0);
		
		quantity=2;
		event.setid(new Long(2));
		customer.setid(new Long(10));
		shipaddress.setid(new Long(7));
		billaddress.setid(new Long(7));
		result = _theOrderManager.placeOrder(event, customer, shipaddress, billaddress, quantity);
		Assert.assertTrue("No tickets left:",result.getReturncode() != 0);
	}

	@Test
	public void cancelOrder() {
		//public BaseDTO cancelOrder(OrderDTO orderDTO){
		BaseDTO result = new BaseDTO();
		OrderDTO order = new OrderDTO();
		order.setid(new Long(12));
		result = _theOrderManager.cancelOrder(order);
		Assert.assertTrue("Cancel Order:", result.getReturncode() == 0);

		order.setid(new Long(8));
		result = _theOrderManager.cancelOrder(order);
		Assert.assertTrue("Cancel Order not possible:", result.getReturncode() != 0);
	}
}
