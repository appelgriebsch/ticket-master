== Non functional Requirements ==

1. external billing

The withdrawal of the order amount is not part of the ordering process. Instead the order process ends with the selection of the payment method:

* cash
* credit card (visa, master card, american express)
* paypal

That said there will be a short "please wait..." operation at the end of the order process to simulate the talking to an external billing system. This will always SUCCEED so that the order is placed and paid afterwards.

2. deliver tickets by mail

As no physical ticket will be delivered to the customer as by now ALL orders will be outstanding for at least 2-3 days to simulate the order shipping process and allow the customer to void the order in this timeframe.
