== Functional Requirements ==

1.  Search for events

The ticket system allow to look for event based on:

* a location
* an artist
* a genre (rock, pop, classic)
* a date/time for the event

2.  Buy tickets

To buy a ticket the customer has to check-in to the system with his customer profile (email address + password). If not already registered she can easily do this by providing some basic personal information. 
If the customer founds an event of interest she has to check first if there are still tickets available for this event and what the pricing conditions for those tickets are. If she is satisfied with the order conditions she can enter the amount of tickets to buy and starting the order process:

----
//Select Event -> Select No. of Tickets -> Check Availability of Tickets -> Enter Shipping Address -> Select Payment Method -> Review Order Details -> Submit the Order//
----

3.  Benchmark events

After the event has passed the attendees to this event can rate it within a five star rating system as well as leaving a comment on the good and bad parts of it. The rating can also be done based on the artist that has performed on this event - just in case there was an event where more than one artist was on stage. For the rating of an event the customer has to:

----
// Entering the customer profile -> Select the Customer Event History -> Select an event from the list that has just passed -> Rate the event / artist & optionally: leave a comment for this event / artist //
----

4. Customer Profile

The system keeps track of the registered customers and their orders. Therefore for each customer a profile is generated containing the basic personal information of that customer (e.g. first / lastname, birthdate, gender, address, email-id). The customer can sign-into the system by providing an unique email-id and a password.

In the customer profile view the events that customer bought are shown ordered by date descending. For passed events the average rating of that event is shown. If the customer hasn't rated the event already she will asked to do so (see No. 3).

----
//Choose to register with system -> Enter personal information -> Enter account logon data -> Submit data//
----

5.  Void Order

The customer can check for outstanding orders - those ones that haven't been delivered yet and can cancel the order as long as being in this state. She has to acknowledge the cancellation as well as give a hint to the system (predefined selection list) of the reason for the cancellation.

----
//Logon to Customer Profile -> Choose to view all outstanding orders -> Select order to void -> Provide a reason for the void -> Acknowledge void of order -> Submit data//
----

== Use Cases ==

{{use cases.png|use case diagram}}
