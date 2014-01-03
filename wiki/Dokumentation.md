﻿Fachhochschule der Wirtschaft
-FHDW-
Bielefeld

Ausarbeitung
zur
Vorlesung

Praxis der Softwareentwicklung II



Thema:
Entwicklung von Webservices
für ein Ticketsystem

Projektname: "Ticketmaster"

Projektmitglieder:

Andreas Gerlach
André Karius
Mark Künert
Holger Jürgens
Andreas Pörtner


7. Semester
Studiengang Bachelor of Science
Schwerpunkt: Wirtschaftsinformatik


Eingereicht am:

17. Dezember 2011



 
= Abbildungsverzeichnis =

Fehler! Es konnten keine Einträge für ein Abbildungsverzeichnis gefunden werden.
 
= 1 Pflichtenheft  =
== 1.1	Zielbestimmung ==
Rollen definieren Benutzer und Event-Agent, Künstler

Folgende Kriterien müssen die Webservices des „Ticketmaster“ erfüllen:
=== 1.1.1 Musskriterien ===

* Anforderung 1:

Benutzer müssen nach Events suchen können und eine Ergebnisliste erhalten, Suchkriterien hierfür sind:
Datum, Ort, Künstler, Genre, Preis, Kategorie [Musik, Sport, Musicals, Festivals]

* Anforderung 2:

Die Kunden des "Ticketmaster" sollen Tickets erwerben können, wobei die Verfügbarkeit der Tickets auf einen Blick für die Anwender ersichtlich sein muss.
Des Weiteren wird zwischen Privat- und Geschäftskunden unterschieden.

* Anforderung 3:

Kunden, welche Karten für einen Event erworben haben, dürfen einen Künstler oder einen Event in Verbindung mit einem Event oder Künstler bewerten. Hierfür müssen sich die Kunden einloggen.
Die Bewertungsskala reicht von 1 bis 5, wobei 5 die beste Bewertung ist. Die Musskriterien einer Bewertung sind der Künstler und der Event.

*	Anforderung 4:
**	Kaufhistorie für den Kunden

=== 1.1.2	Kannkriterien ===

* Anforderung 5:
** Datenverwaltung des Kunden durch den Kunden selbst
*** Vor- und Nachname
*** Adresse
** Straße und Hausnummer
** Postleitzahl und Ort

* Anforderung 6:
** Eventverwaltung für den Event-Agent
*** Neue Events anlegen:
** Name des Künstlers
** Ort
** Datum
** Genre - hier muss eine Auswahl getroffen werden
** Kategorie hier muss eine Auswahl getroffen werden
** Anzahl der Tickets
** Preis der Tickets
*** Neuen Künstler anlegen  Abgleich mit bestehen Künstlern!!!

*	Anforderung 7:
**	E-Mail Rückmeldungen
***	Nach der Registrierung
***	Nach dem Ticket Erwerb
***	Nach der Änderung von persönlichen Daten
***	Nach erfolgreicher Stornierung einer Bestellung

=== 1.1.3	Abgrenzungskriterien ===

Der Ticketversand sowie der Zahlungsverkehr werden extern abgewickelt und sind somit kein Bestandteil des Produktes. Das Produkt wird ausschließlich für folgende Länder entwickelt: Deutschland, Österreich, Schweiz. Des Weiteren werden keinerlei Sicherheitsanforderungen an die Anwendung gestellt.

== 1.2	Produkteinsatz ==

Das Produkt dient in erster Linie nur dem Projekt und soll nicht darüber hinaus verwendet werden. Der Dozent soll an Hand des Produktes die geforderten Leistungen überprüfen können. In ihrer derzeitigen Form dient die Anwendung als Machbarkeitsstudie. Für einen produktiven Einsatz in einem Geschäftsmodell müssten jedoch weitere Funktionen hinzugefügt werden.

== 1.3	Produktübersicht ==

Das Produkt mit dem Namen „Ticketmaster“ dient zum Verkauf und Erwerb von Tickets für verschiedene Events aus den Bereichen „Musik, Sport, Musical und Festivals“. Um die Suche nach einem Künstler oder Event zu vereinfachen, wird eine entsprechende Suchfunktion angeboten. Des Weiteren sollten die registrierten Kunden die Möglichkeit haben einen Künstler in Verbindung mit einem Event zu bewerten. 

== 1.4	Produktfunktionen == 

Schon oben mehrmals beschreiben

== 1.5	Produktdaten ==

Um eine reibungslose Funktionalität des Produkt zu gewährleisten müssen verschiedene Daten in einer Datenbank abgelegt werden. Folgende Daten und Datentypen werden in der Datenbank gespeichert:

	Name	Datatype		
Customer				
	Lastname	String		
	Firstname	String		
	Street	String		
	Zip-Code	Integer		
	City	String		
	Country	String		
	E-Mail	String		
	Type	String		
				
Event				
	Name	String		
	Start-Date	Date		
	End-Date	Date		
	Venue	String		
	Artist	String		
	Price	Double		
	Categorie	String		
	Genre	String		
	Amout of Tickets	Integer		
	Available Tickets	Interger		
				
Rating				
	Rating	Integer		
	Text	String		
				
Order				
	Status	Integer		
	Orderdate	Date		
				
				

== 1.6	Qualitätsanforderungen ==

Die Anwendung muss dokumentiert werden. Dies umfasst eine fachliche wie technische Dokumentation. Der Quelltext wird mit JavaDoc dokumentiert. Damit soll die Wartbarkeit der Anwendung gewährleistet werden.

 
== 1.7	Benutzungsoberfläche ==

Bestandteil dieses Projekts ist ebenfalls die Erstellung eines Clients zum Konsumieren der Webservices. Im Folgenden sind mögliche Entwürfe der Benutzeroberfläche abgebildet. Die Oberflächen können nach Abstimmung mit dem Projektleiter im Projektverlauf aktualisiert werden. Das Pflichtenheft wird in diesem Fall nicht aktualisiert.

=== 1.7.1	Einstiegseite ===
=== 1.7.2	Suche nach Events ===
=== 1.7.3	Registrierung zum Ticketkauf ===
=== 1.7.4	Ticketkauf ===
=== 1.7.5	Bestellhistorie für den Kunden ===
=== 1.7.6	Datenpflege der eigenen Kundendaten ===
=== 1.7.7	Eventanlage durch Event Agent ===


 
== 1.8	Nicht-funktionale Anforderungen ==

Randbedingungen:

* Der Versand bestellter Tickets erfolgt extern
* Das gesamte Zahlungswesen wird  werden extern abgewickelt

Interoperabilität:

* Der Client wir in einem Webbrowser dargestellt und ist daher programmunabhängig

Einfache Bedienbarkeit:

* Die Oberfläche des Clients ist intuitiv und einfach gestaltet

Wartbarkeit:

* Dokumentation
* Dokumentation im Quelltext

== 1.9	Technische Produktumgebung ==

Der Apache Tomcat wird als Ausführungsumgebung benutzt. Eine PostgreSQL 9.1 dient als Datenbankplattform. Die Webservices werden mit dem Framework Jax-WS implementiert.
Als Programmiersprache wird Java 6 benutzt.

== 1.10	Spezielle Anforderungen an die Entwicklungsumgebung ==

Als Entwicklungsumgebung wird Eclipse Indigo genutzt. Eclipse ist den Mitgliedern
bereits aus früheren Projekten für Java-Entwicklung, bekannt. Daher wurde lag eine Entscheidung nah diese Umgebung erneut zu nutzen. Zudem ist der Funktionsumfang sehr groß und bringt alle Merkmale mit, die für dieses Projekt benötigt wurden. Aufgrund der Erweiterbarkeit der Entwicklungsumgebung und den zahlreichen, teilweise kostenlos verfügbaren Komponenten lässt sich Eclipse an unterschiedlichste Anforderungen anpassen. Zum Testen der Webservices im Entwicklungsprozess wird SoapUI genutzt. SoapUI war eine Empfehlung des Dozenten.
 
= 2 Fachkonzept =

== 2.1	Klassen im Model Paket ==

== 2.2	Klassen im View Paket ==

== 2.3 AppController Klasse ==


= 3 Projektplan =

{{https://bbuseruploads.s3.amazonaws.com/appelgriebsch/ticketmaster/downloads/Projektplan.jpg?Signature=qGvCn3srEN1o2ezAAOSO88r8I7g%3D&Expires=1321046636&AWSAccessKeyId=0EMWEFSGA12Z1HF1TZ82|Projektplan}}
[Zur besseren Ansicht ist der Projektplan nochmals auf dem Datenträger im PDF- und MS Excel-Format zu finden]

= 4 Test =

Zum Abprüfen der Funktionalität werden folgende Benutzertests und Funktionalitätstest durchgeführt:
Testfall	Vorbedingung	Aktion	Erwartetes Resultat
Neuen Benutzer anlegen	Benutzer nicht vorhanden	Benutzer anlegen	Benutzer angelegt und Benutzer erhält Bestätigungmail
Vorhandenden Benutzer erneut anlegen	Benutzer ist bereits mit der gleichen E-Mailadresse vorhanden	Benutzer anlegen	Benutzer kann nicht erneut angelegt werden
Benutzerdaten ändern	Benutzer ist vorhanden	Benutzerdaten ändern	Benutzerdaten in der Datenbank geändert und Bestätigungsemail
Buchung vornehmen	Event liegt in der Zukunft	Buchung eingeben und abschicken	Buchung im System vorhanden, Benutzer erhält Bestätigungsmail und Status der Bestellung gesetzt
Bestellung stornieren	Bestellung vom Benutzer liegt vor	Bestellung stornieren	Bestellung wird im System gelöscht und Bestätigungsmail an den Benutzer versand
 
= 5 Fazit / Bewertung =


