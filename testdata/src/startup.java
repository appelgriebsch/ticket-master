import de.fhdw.ify208.ticketmaster.common.model.*;
import de.fhdw.ify208.ticketmaster.model.CustomerManager;
import de.fhdw.ify208.ticketmaster.model.EventManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: appelgriebsch
 * Date: 11/25/11
 * Time: 9:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class startup {

	private static CustomerManager _theCustomerManager = null;
	private static EventManager _theEventManager = null;
	private static List<TypeCodeDTO> _categories = null;
	private static List<TypeCodeDTO> _genres = null;
	private static List<TypeCodeDTO> _stati = null;
	private static List<TypeCodeDTO> _addressTypes = null;
	private static List<CountryDTO> _countries = null;

	public static void init() {

		_theCustomerManager = CustomerManager.getInstance();
		_theEventManager = EventManager.getInstance();

		TypeCodeListDTO tpResult = _theEventManager.getCategories();
		_categories = new ArrayList<TypeCodeDTO>(tpResult.getTypeCodeDTOList());

		tpResult = _theEventManager.getGenres();
		_genres = new ArrayList<TypeCodeDTO>(tpResult.getTypeCodeDTOList());

		tpResult = _theEventManager.getEventStatuses();
		_stati = new ArrayList<TypeCodeDTO>(tpResult.getTypeCodeDTOList());

		tpResult = _theEventManager.getAddressTypes();
		_addressTypes = new ArrayList<TypeCodeDTO>(tpResult.getTypeCodeDTOList());

		CountryListDTO countryListDTO = _theEventManager.getCountries();
		_countries = new ArrayList<CountryDTO>(countryListDTO.getCountryDTOList());
	}

	public static void registerNewCustomer() {

		TypeCodeListDTO tpList = _theCustomerManager.getCustomerTypes();
		TypeCodeDTO tpCode = null;

		for (TypeCodeDTO t : tpList.getTypeCodeDTOList()) {

			if (t.getName().equals("Private")) {
				tpCode = t;
				break;
			}
		}

		CustomerDTO newCustomer = new CustomerDTO();
		newCustomer.setBirthdate(new Date(1976, 10, 9));
		newCustomer.setEmail("info@appelgriebsch.com");
		newCustomer.setFirstName("Andreas");
		newCustomer.setGenderType(GenderType.Male);
		newCustomer.setLastName("Gerlach");
		newCustomer.setPassword("12345");       // TODO: encrypt password !!!
		newCustomer.setSalutation("Hr.");
		newCustomer.setType(tpCode);
		newCustomer.setUserName("appelgriebsch");

		BaseDTO result = _theCustomerManager.registerCustomer(newCustomer);

		System.out.print("creating customer:");
		System.out.println(result.getMessage());
	}

	public static void createEvents() {

		try {

			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder bld = fac.newDocumentBuilder();
			Document doc = bld.parse(new File("./eventservice/test/events.xml"));

			NodeList eventList = doc.getElementsByTagName("event");

			for (int i = 0; i < eventList.getLength(); ++i) {

				Node event = eventList.item(i);

				if (event.getNodeType() != Node.ELEMENT_NODE)
					continue;

				Element elemNode = (Element) event;
				EventDTO eventDTO = new EventDTO();
				NodeList childs = elemNode.getChildNodes();

				for (int j = 0; j < childs.getLength(); ++j) {

					Node elemChild = childs.item(j);

					if (elemChild.getNodeName().equals("category")) {
						String category = elemChild.getTextContent().trim();
						TypeCodeDTO tpCategory = findCategory(category);
						eventDTO.setCategory(tpCategory);
					}

					if (elemChild.getNodeName().equals("artist")) {
						String artist = elemChild.getTextContent().trim();
						ArtistDTO artistDTO = _theEventManager.findArtist(artist);
						ArtistListDTO artistList = new ArtistListDTO();
						artistList.addArtistToList(artistDTO);
						eventDTO.setArtists(artistList);
					}

					if (elemChild.getNodeName().equals("url")) {
						eventDTO.setAdUrl(elemChild.getTextContent().trim());
					}

					if (elemChild.getNodeName().equals("description")) {
						eventDTO.setDescription(elemChild.getTextContent());
					}

					if (elemChild.getNodeName().equals("enddate")) {
						eventDTO.setEndDate(DatatypeConverter.parseDateTime(elemChild.getTextContent().trim()).getTime());
					}

					if (elemChild.getNodeName().equals("startdate")) {
						eventDTO.setStartDate(DatatypeConverter.parseDateTime(elemChild.getTextContent().trim()).getTime());
					}

					if (elemChild.getNodeName().equals("price")) {
						eventDTO.setTicketPrice(DatatypeConverter.parseDecimal(elemChild.getTextContent().trim()));
					}

					if (elemChild.getNodeName().equals("allocation")) {
						eventDTO.setMaxNoOfTickets(Integer.parseInt(elemChild.getTextContent().trim()));
					}

					if (elemChild.getNodeName().equals("location")) {

						AddressDTO adressDTO = new AddressDTO();
						NodeList locChilds = elemChild.getChildNodes();

						TypeCodeDTO addressTypeDTO = findAddressType("Location");
						adressDTO.setAddressType(addressTypeDTO);

						for (int k = 0; k < locChilds.getLength(); ++k) {

							Node elemLocation = locChilds.item(k);

							if (elemLocation.getNodeName().equals("country")) {
								String country = elemLocation.getTextContent().trim();
								CountryDTO countryDTO = findCountry(country);
								adressDTO.setCountry(countryDTO);
							}

							if (elemLocation.getNodeName().equals("address")) {
								adressDTO.setAddressLine(elemLocation.getTextContent().trim());
							}

							if (elemLocation.getNodeName().equals("city")) {
								adressDTO.setCityName(elemLocation.getTextContent().trim());
							}

							if (elemLocation.getNodeName().equals("district")) {
								adressDTO.setDistrict(elemLocation.getTextContent().trim());
							}

							if (elemLocation.getNodeName().equals("streetname")) {
								adressDTO.setStreetName(elemLocation.getTextContent().trim());
							}

							if (elemLocation.getNodeName().equals("zip")) {
								adressDTO.setZipCode(elemLocation.getTextContent().trim());
							}
						}

						eventDTO.setLocation(adressDTO);
					}
				}

				BaseDTO result = _theEventManager.registerNewEvent(eventDTO);

				System.out.print("creating event: ");
				System.out.println(result.getMessage());

				init();     // reload existing type codes in case it has been created
			}

		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
		} catch (IOException e) {
		}
	}

	public static void createArtists() {

		try {

			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder bld = fac.newDocumentBuilder();
			Document doc = bld.parse(new File("./eventservice/test/artists.xml"));

			NodeList artistList = doc.getDocumentElement().getElementsByTagName("artist");

			for (int i = 0; i < artistList.getLength(); ++i) {

				Node artist = artistList.item(i);

				if (artist.getNodeType() != Node.ELEMENT_NODE)
					continue;

				Element elemNode = (Element) artist;
				ArtistDTO artistDTO = new ArtistDTO();

				NodeList childs = elemNode.getChildNodes();

				for (int j = 0; j < childs.getLength(); ++j) {

					Node item = childs.item(j);

					if (item.getNodeName().equals("genre")) {

						String genre = item.getTextContent().trim();
						TypeCodeDTO tpGenre = findGenre(genre);
						artistDTO.setGenre(tpGenre);
					}

					if (item.getNodeName().equals("firstname")) {
						artistDTO.setFirstName(item.getTextContent().trim());
					}

					if (item.getNodeName().equals("lastname")) {
						artistDTO.setLastName(item.getTextContent().trim());
					}

					if (item.getNodeName().equals("stagename")) {
						artistDTO.setStageName(item.getTextContent().trim());
					}
				}

				BaseDTO result = _theEventManager.registerNewArtist(artistDTO);

				System.out.print("creating artist: ");
				System.out.println(result.getMessage());

				init(); // reload existing type code in case it has been created
			}

		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
		} catch (IOException e) {
		}
	}

	public static TypeCodeDTO findGenre(String genre) {

		for (TypeCodeDTO typeCode : _genres) {

			if (typeCode.getName().equalsIgnoreCase(genre))
				return typeCode;
		}

		TypeCodeDTO newTypeCode = new TypeCodeDTO();
		newTypeCode.setName(genre);
		newTypeCode.setDescription(String.format("Genre: %s", genre));
		_genres.add(newTypeCode);

		return newTypeCode;
	}

	public static TypeCodeDTO findCategory(String category) {

		for (TypeCodeDTO typeCode : _categories) {

			if (typeCode.getName().equalsIgnoreCase(category))
				return typeCode;
		}

		TypeCodeDTO newTypeCode = new TypeCodeDTO();
		newTypeCode.setName(category);
		newTypeCode.setDescription(String.format("Category: %s", category));
		_categories.add(newTypeCode);

		return newTypeCode;
	}

	public static TypeCodeDTO findAddressType(String addressType) {

		for (TypeCodeDTO typeCode : _addressTypes) {

			if (typeCode.getName().equalsIgnoreCase(addressType))
				return typeCode;
		}

		TypeCodeDTO newTypeCode = new TypeCodeDTO();
		newTypeCode.setName(addressType);
		newTypeCode.setDescription(String.format("AddressType: %s", addressType));
		_addressTypes.add(newTypeCode);

		return newTypeCode;
	}

	public static CountryDTO findCountry(String country) {

		for (CountryDTO countryDTO : _countries) {

			if (countryDTO.getIsoCode().equalsIgnoreCase(country))
				return countryDTO;
		}

		return null;
	}

	public static void main(String[] args) {

		init();
		registerNewCustomer();
		createArtists();
		createEvents();
	}
}
