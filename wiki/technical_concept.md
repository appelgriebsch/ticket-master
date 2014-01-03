== Technical Concept ==

=== System Architecture ===

The backend service of the ticket system will be developed in Java 6 using the JAX-WS for easy hosting the SOAP 1.1 services in the Apache Tomcat web container. The data for the application is stored in a separate PostgreSQL database that the web services have access to via JDBC.

{{system_overview.png|System overview}}

Each of the web services is separated from the other service by business functionality:

* **customer service**: deals with everything concerning the profile of a registered customer
* **event service**: deals with the events available in the system and their ratings
* **order service**: deals with the orders that customers have placed in the system incl. void of outstanding orders

The general architecture of such a web service is based on the following layered approach:

{{webservice_architecture.png|WebService architecture}}

=== Database Model ===

The main entities in the data model are:

* **user**: holds any user account that has access to the system
* **artist**: collects artist information like name, genre, ...
* **address**: specifies an address / location that is used in the system
* **event**: describes an event that is held at a specific location (address) and performed by various artists (artist)
* **order**: holds information about the order of tickets a user (customer) has placed for a specific event
* **rating**: get the rating of the user for an event that he has visited

{{ticketDB.Model.png|TicketDB Datamodel}}

=== Web Services ===

==== Data Transfer Objects ====

**Customer**
|**Property**|**Comments**|
|Salutation| |
|FirstName| |
|LastName| |
|Gender|(Male/Female)|
|BirthDate| |
|Type|(see: TypeCode)|
|UserName| |
|Password|(encrypted)|
|Email| |

**Address**
|**Property**|**Comments**|
|Type|(see: TypeCode)|
|AddressLine| |
|StreetName| |
|ZipCode| |
|CityName| |
|Country|(see: Country)|
|District| |

**Artist**
|**Property**|**Comments**|
|StageName| |
|FirstName| |
|LastName| |
|Genre|(see: TypeCode)|

**Country**
|**Property**|**Comments**|
|ISO Code| |
|Name| |
|Description| |

**Event**
|**Property**|**Comments**|
|StartDate| |
|EndDate| |
|Description| |
|AdUrl| |
|Location|(see: Address)|
|Category|(see: TypeCode)|
|MaxNoOfTickets| |
|Price| |
|AvailNoOfTickets| |
|Artists|(see: Artist)|
|Ratings|(see: Rating)|
|AverageRating| |

**Order**
|**Property**|**Comments**|
|Event|(see: Event)|
|Customer|(see: Customer)|
|Date| |    
|Status|(see: TypeCode)|
|ShippingAddress|(see: Address)|
|BillingAddress|(see: Address)|
|Quantity| |

**Rating**
|**Property**|**Comments**|
|UserName| |
|Rating| |
|Comment| |
|Date| |

**TypeCode**
|**Property**|**Comments**|
|Name| |
|Description| |

==== Customer Service ====

The customer service deals with customer related information in the ticket system and provides access to and maintains customer data. It is also responsible for signing on a customer and validating the sign-on credentials.

**Operations**:

* List<Address> getCustomerAddresses(Customer theCustomer)

* Customer SignOn(String userName, String password)
* boolean ChangePassword(String userName, String oldPassword, String newPassword)
* boolean RegisterCustomer(Customer theCustomer)
* boolean MaintainAddress(Customer theCustomer, Address theAddress)
* boolean RemoveAddress(Customer theCustomer, Address theAddress)
* boolean CloseCustomerProfile(Customer theCustomer)

==== Event Service ====

The event service deals with event related information in the ticket system and provides access to and maintains event and artist data. 

**Operations**:

* List<Event> getEventsByArtist(String artistName)
* List<Event> getEventsByLocation(String cityName)
* List<Event> getEventsByGenre(String genre)
* List<Event> getEventsByCategory(String category)
* List<Event> getEventsByDateRange(Date startDate, Date endDate)

* boolean RegisterNewEvent(Event theEvent)
* boolean RegisterNewArtist(Artist theArtist)
* boolean CancelEvent(Event theEvent)
* boolean RateEvent(Event theEvent, Customer theCustomer, double rating, String comment)

==== Order Service ====

The order service deals with the checkout and ordering process of the ticket system. It allows to send order requests for specific events by registered customers as well as list and maintain those orders later on.

**Operations**:

* List<Order> getCustomerOrders(Customer theCustomer)

* Order PlaceOrder(Event theEvent, Customer theCustomer, Address shippingAddress, Address BillingAddress, int quantity)
* boolean CancelOrder(Order theOrder)

=== Client Application ===

==== Screen Prototypes ====

{{StartWeb.png|start screen in webbrowser}}

{{ProfileWeb.png|profile screen in webbrowser}}

{{CheckoutWeb.png|checkout screen in webbrowser}}