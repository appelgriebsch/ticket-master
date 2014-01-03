package de.fhdw.ify208.ticketmaster.common.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author appelgriebsch
 */
@XmlRootElement(name = "orders")
public class OrderListDTO extends BaseDTO {

    private List<OrderDTO> orders = new ArrayList<OrderDTO>();

    public void addOrderToList(OrderDTO orderDTO) {
        orders.add(orderDTO);
    }

    @XmlElement(name = "order")
    public Collection<OrderDTO> getOrderDTOList() {
        return orders;
    }
}
