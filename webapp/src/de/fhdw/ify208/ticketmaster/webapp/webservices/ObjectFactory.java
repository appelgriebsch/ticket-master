package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the de.fhdw.ify208.ticketmaster.webapp.webservices package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Event_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "event");
    private final static QName _Address_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "address");
    private final static QName _Order_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "order");
    private final static QName _PlaceOrderResponse_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "PlaceOrderResponse");
    private final static QName _GetOrderStatusesResponse_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "GetOrderStatusesResponse");
    private final static QName _Artists_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "artists");
    private final static QName _GetCustomerOrders_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "GetCustomerOrders");
    private final static QName _Ratings_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "ratings");
    private final static QName _GetCustomerOrdersResponse_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "GetCustomerOrdersResponse");
    private final static QName _Artist_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "artist");
    private final static QName _Rating_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "rating");
    private final static QName _Orders_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "orders");
    private final static QName _Typecodes_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "typecodes");
    private final static QName _GetOrderStatuses_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "GetOrderStatuses");
    private final static QName _Typecode_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "typecode");
    private final static QName _CancelOrderResponse_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "CancelOrderResponse");
    private final static QName _Country_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "country");
    private final static QName _PlaceOrder_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "PlaceOrder");
    private final static QName _Customer_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "customer");
    private final static QName _CancelOrder_QNAME = new QName("de.fhdw.ify208.ticketmaster.common.model", "CancelOrder");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.fhdw.ify208.ticketmaster.webapp.webservices
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetOrderStatuses }
     */
    public GetOrderStatuses createGetOrderStatuses() {
        return new GetOrderStatuses();
    }

    /**
     * Create an instance of {@link GetCustomerOrders }
     */
    public GetCustomerOrders createGetCustomerOrders() {
        return new GetCustomerOrders();
    }

    /**
     * Create an instance of {@link CountryDTO }
     */
    public CountryDTO createCountryDTO() {
        return new CountryDTO();
    }

    /**
     * Create an instance of {@link RatingDTO }
     */
    public RatingDTO createRatingDTO() {
        return new RatingDTO();
    }

    /**
     * Create an instance of {@link TypeCodeDTO }
     */
    public TypeCodeDTO createTypeCodeDTO() {
        return new TypeCodeDTO();
    }

    /**
     * Create an instance of {@link GetOrderStatusesResponse }
     */
    public GetOrderStatusesResponse createGetOrderStatusesResponse() {
        return new GetOrderStatusesResponse();
    }

    /**
     * Create an instance of {@link EventDTO }
     */
    public EventDTO createEventDTO() {
        return new EventDTO();
    }

    /**
     * Create an instance of {@link GetCustomerOrdersResponse }
     */
    public GetCustomerOrdersResponse createGetCustomerOrdersResponse() {
        return new GetCustomerOrdersResponse();
    }

    /**
     * Create an instance of {@link ArtistDTO }
     */
    public ArtistDTO createArtistDTO() {
        return new ArtistDTO();
    }

    /**
     * Create an instance of {@link PlaceOrderResponse }
     */
    public PlaceOrderResponse createPlaceOrderResponse() {
        return new PlaceOrderResponse();
    }

    /**
     * Create an instance of {@link CancelOrderResponse }
     */
    public CancelOrderResponse createCancelOrderResponse() {
        return new CancelOrderResponse();
    }

    /**
     * Create an instance of {@link CancelOrder }
     */
    public CancelOrder createCancelOrder() {
        return new CancelOrder();
    }

    /**
     * Create an instance of {@link OrderDTO }
     */
    public OrderDTO createOrderDTO() {
        return new OrderDTO();
    }

    /**
     * Create an instance of {@link TypeCodeListDTO }
     */
    public TypeCodeListDTO createTypeCodeListDTO() {
        return new TypeCodeListDTO();
    }

    /**
     * Create an instance of {@link ArtistListDTO }
     */
    public ArtistListDTO createArtistListDTO() {
        return new ArtistListDTO();
    }

    /**
     * Create an instance of {@link BaseDTO }
     */
    public BaseDTO createBaseDTO() {
        return new BaseDTO();
    }

    /**
     * Create an instance of {@link RatingListDTO }
     */
    public RatingListDTO createRatingListDTO() {
        return new RatingListDTO();
    }

    /**
     * Create an instance of {@link AddressDTO }
     */
    public AddressDTO createAddressDTO() {
        return new AddressDTO();
    }

    /**
     * Create an instance of {@link OrderListDTO }
     */
    public OrderListDTO createOrderListDTO() {
        return new OrderListDTO();
    }

    /**
     * Create an instance of {@link CustomerDTO }
     */
    public CustomerDTO createCustomerDTO() {
        return new CustomerDTO();
    }

    /**
     * Create an instance of {@link PlaceOrder }
     */
    public PlaceOrder createPlaceOrder() {
        return new PlaceOrder();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventDTO }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "event")
    public JAXBElement<EventDTO> createEvent(EventDTO value) {
        return new JAXBElement<EventDTO>(_Event_QNAME, EventDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressDTO }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "address")
    public JAXBElement<AddressDTO> createAddress(AddressDTO value) {
        return new JAXBElement<AddressDTO>(_Address_QNAME, AddressDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderDTO }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "order")
    public JAXBElement<OrderDTO> createOrder(OrderDTO value) {
        return new JAXBElement<OrderDTO>(_Order_QNAME, OrderDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceOrderResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "PlaceOrderResponse")
    public JAXBElement<PlaceOrderResponse> createPlaceOrderResponse(PlaceOrderResponse value) {
        return new JAXBElement<PlaceOrderResponse>(_PlaceOrderResponse_QNAME, PlaceOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderStatusesResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "GetOrderStatusesResponse")
    public JAXBElement<GetOrderStatusesResponse> createGetOrderStatusesResponse(GetOrderStatusesResponse value) {
        return new JAXBElement<GetOrderStatusesResponse>(_GetOrderStatusesResponse_QNAME, GetOrderStatusesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArtistListDTO }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "artists")
    public JAXBElement<ArtistListDTO> createArtists(ArtistListDTO value) {
        return new JAXBElement<ArtistListDTO>(_Artists_QNAME, ArtistListDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomerOrders }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "GetCustomerOrders")
    public JAXBElement<GetCustomerOrders> createGetCustomerOrders(GetCustomerOrders value) {
        return new JAXBElement<GetCustomerOrders>(_GetCustomerOrders_QNAME, GetCustomerOrders.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RatingListDTO }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "ratings")
    public JAXBElement<RatingListDTO> createRatings(RatingListDTO value) {
        return new JAXBElement<RatingListDTO>(_Ratings_QNAME, RatingListDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomerOrdersResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "GetCustomerOrdersResponse")
    public JAXBElement<GetCustomerOrdersResponse> createGetCustomerOrdersResponse(GetCustomerOrdersResponse value) {
        return new JAXBElement<GetCustomerOrdersResponse>(_GetCustomerOrdersResponse_QNAME, GetCustomerOrdersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArtistDTO }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "artist")
    public JAXBElement<ArtistDTO> createArtist(ArtistDTO value) {
        return new JAXBElement<ArtistDTO>(_Artist_QNAME, ArtistDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RatingDTO }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "rating")
    public JAXBElement<RatingDTO> createRating(RatingDTO value) {
        return new JAXBElement<RatingDTO>(_Rating_QNAME, RatingDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderListDTO }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "orders")
    public JAXBElement<OrderListDTO> createOrders(OrderListDTO value) {
        return new JAXBElement<OrderListDTO>(_Orders_QNAME, OrderListDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TypeCodeListDTO }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "typecodes")
    public JAXBElement<TypeCodeListDTO> createTypecodes(TypeCodeListDTO value) {
        return new JAXBElement<TypeCodeListDTO>(_Typecodes_QNAME, TypeCodeListDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderStatuses }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "GetOrderStatuses")
    public JAXBElement<GetOrderStatuses> createGetOrderStatuses(GetOrderStatuses value) {
        return new JAXBElement<GetOrderStatuses>(_GetOrderStatuses_QNAME, GetOrderStatuses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TypeCodeDTO }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "typecode")
    public JAXBElement<TypeCodeDTO> createTypecode(TypeCodeDTO value) {
        return new JAXBElement<TypeCodeDTO>(_Typecode_QNAME, TypeCodeDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelOrderResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "CancelOrderResponse")
    public JAXBElement<CancelOrderResponse> createCancelOrderResponse(CancelOrderResponse value) {
        return new JAXBElement<CancelOrderResponse>(_CancelOrderResponse_QNAME, CancelOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountryDTO }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "country")
    public JAXBElement<CountryDTO> createCountry(CountryDTO value) {
        return new JAXBElement<CountryDTO>(_Country_QNAME, CountryDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceOrder }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "PlaceOrder")
    public JAXBElement<PlaceOrder> createPlaceOrder(PlaceOrder value) {
        return new JAXBElement<PlaceOrder>(_PlaceOrder_QNAME, PlaceOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerDTO }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "customer")
    public JAXBElement<CustomerDTO> createCustomer(CustomerDTO value) {
        return new JAXBElement<CustomerDTO>(_Customer_QNAME, CustomerDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelOrder }{@code >}}
     */
    @XmlElementDecl(namespace = "de.fhdw.ify208.ticketmaster.common.model", name = "CancelOrder")
    public JAXBElement<CancelOrder> createCancelOrder(CancelOrder value) {
        return new JAXBElement<CancelOrder>(_CancelOrder_QNAME, CancelOrder.class, null, value);
    }

}
