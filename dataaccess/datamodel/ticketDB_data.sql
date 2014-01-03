--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.1
-- Dumped by pg_dump version 9.1.1
-- Started on 2011-10-30 20:06:37

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- TOC entry 1971 (class 0 OID 16397)
-- Dependencies: 162
-- Data for Name: t_addresstype; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO t_addresstype(displayname, description) VALUES ('Billing', 'This is a billing address');
INSERT INTO t_addresstype(displayname, description) VALUES ('Shipping', 'This is a shipping address');
INSERT INTO t_addresstype(displayname, description) VALUES ('Location', 'This is a event location');

--
-- TOC entry 1974 (class 0 OID 16412)
-- Dependencies: 165
-- Data for Name: t_country; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO t_country VALUES ('AFG', 'Afghanistan', NULL);
INSERT INTO t_country VALUES ('ALA', 'Åland Islands', NULL);
INSERT INTO t_country VALUES ('DZA', 'Algeria (El Djazaïr)', NULL);
INSERT INTO t_country VALUES ('ALB', 'Albania', NULL);
INSERT INTO t_country VALUES ('ASM', 'American Samoa', NULL);
INSERT INTO t_country VALUES ('AND', 'Andorra', NULL);
INSERT INTO t_country VALUES ('AGO', 'Angola', NULL);
INSERT INTO t_country VALUES ('AIA', 'Anguilla', NULL);
INSERT INTO t_country VALUES ('ATA', 'Antarctica', NULL);
INSERT INTO t_country VALUES ('ATG', 'Antigua and Barbuda', NULL);
INSERT INTO t_country VALUES ('ARG', 'Argentina', NULL);
INSERT INTO t_country VALUES ('ARM', 'Armenia', NULL);
INSERT INTO t_country VALUES ('ABW', 'Aruba', NULL);
INSERT INTO t_country VALUES ('AUS', 'Australia', NULL);
INSERT INTO t_country VALUES ('AUT', 'Austria', NULL);
INSERT INTO t_country VALUES ('AZE', 'Azerbaijan', NULL);
INSERT INTO t_country VALUES ('BHS', 'Bahamas', NULL);
INSERT INTO t_country VALUES ('BHR', 'Bahrain', NULL);
INSERT INTO t_country VALUES ('BGD', 'Bangladesh', NULL);
INSERT INTO t_country VALUES ('BRB', 'Barbados', NULL);
INSERT INTO t_country VALUES ('BLR', 'Belarus', NULL);
INSERT INTO t_country VALUES ('BEL', 'Belgium', NULL);
INSERT INTO t_country VALUES ('BLZ', 'Belize', NULL);
INSERT INTO t_country VALUES ('BEN', 'Benin', NULL);
INSERT INTO t_country VALUES ('BMU', 'Bermuda', NULL);
INSERT INTO t_country VALUES ('BTN', 'Bhutan', NULL);
INSERT INTO t_country VALUES ('BOL', 'Bolivia', NULL);
INSERT INTO t_country VALUES ('BIH', 'Bosnia and Herzegovina', NULL);
INSERT INTO t_country VALUES ('BWA', 'Botswana', NULL);
INSERT INTO t_country VALUES ('BVT', 'Bouvet Island', NULL);
INSERT INTO t_country VALUES ('BRA', 'Brazil', NULL);
INSERT INTO t_country VALUES ('IOT', 'British Indian Ocean Territory', NULL);
INSERT INTO t_country VALUES ('BRN', 'Brunei Darussalam', NULL);
INSERT INTO t_country VALUES ('BGR', 'Bulgaria', NULL);
INSERT INTO t_country VALUES ('BFA', 'Burkina Faso', NULL);
INSERT INTO t_country VALUES ('BDI', 'Burundi', NULL);
INSERT INTO t_country VALUES ('KHM', 'Cambodia', NULL);
INSERT INTO t_country VALUES ('CMR', 'Cameroon', NULL);
INSERT INTO t_country VALUES ('CAN', 'Canada', NULL);
INSERT INTO t_country VALUES ('CPV', 'Cape Verde', NULL);
INSERT INTO t_country VALUES ('CYM', 'Cayman Islands', NULL);
INSERT INTO t_country VALUES ('CAF', 'Central African Republic', NULL);
INSERT INTO t_country VALUES ('TCD', 'Chad (T''Chad)', NULL);
INSERT INTO t_country VALUES ('CHL', 'Chile', NULL);
INSERT INTO t_country VALUES ('CHN', 'China', NULL);
INSERT INTO t_country VALUES ('CXR', 'Christmas Island', NULL);
INSERT INTO t_country VALUES ('CCK', 'Cocos (Keeling) Islands', NULL);
INSERT INTO t_country VALUES ('COL', 'Colombia', NULL);
INSERT INTO t_country VALUES ('COM', 'Comoros', NULL);
INSERT INTO t_country VALUES ('COG', 'Congo', NULL);
INSERT INTO t_country VALUES ('COD', 'Congo', NULL);
INSERT INTO t_country VALUES ('COK', 'Cook Islands', NULL);
INSERT INTO t_country VALUES ('CRI', 'Costa Rica', NULL);
INSERT INTO t_country VALUES ('CIV', 'CÔte D''Ivoire (Ivory Coast)', NULL);
INSERT INTO t_country VALUES ('HRV', 'Croatia (hrvatska)', NULL);
INSERT INTO t_country VALUES ('CUB', 'Cuba', NULL);
INSERT INTO t_country VALUES ('CYP', 'Cyprus', NULL);
INSERT INTO t_country VALUES ('CZE', 'Czech Republic', NULL);
INSERT INTO t_country VALUES ('DNK', 'Denmark', NULL);
INSERT INTO t_country VALUES ('DJI', 'Djibouti', NULL);
INSERT INTO t_country VALUES ('DMA', 'Dominica', NULL);
INSERT INTO t_country VALUES ('DOM', 'Dominican Republic', NULL);
INSERT INTO t_country VALUES ('ECU', 'Ecuador', NULL);
INSERT INTO t_country VALUES ('EGY', 'Egypt', NULL);
INSERT INTO t_country VALUES ('SLV', 'El Salvador', NULL);
INSERT INTO t_country VALUES ('GNQ', 'Equatorial Guinea', NULL);
INSERT INTO t_country VALUES ('ERI', 'Eritrea', NULL);
INSERT INTO t_country VALUES ('EST', 'Estonia', NULL);
INSERT INTO t_country VALUES ('ETH', 'Ethiopia', NULL);
INSERT INTO t_country VALUES ('FRO', 'Faeroe Islands', NULL);
INSERT INTO t_country VALUES ('FLK', 'Falkland Islands (Malvinas)', NULL);
INSERT INTO t_country VALUES ('FJI', 'Fiji', NULL);
INSERT INTO t_country VALUES ('FIN', 'Finland', NULL);
INSERT INTO t_country VALUES ('FRA', 'France', NULL);
INSERT INTO t_country VALUES ('GUF', 'French Guiana', NULL);
INSERT INTO t_country VALUES ('PYF', 'French Polynesia', NULL);
INSERT INTO t_country VALUES ('ATF', 'French Southern Territories', NULL);
INSERT INTO t_country VALUES ('GAB', 'Gabon', NULL);
INSERT INTO t_country VALUES ('GMB', 'Gambia', NULL);
INSERT INTO t_country VALUES ('GEO', 'Georgia', NULL);
INSERT INTO t_country VALUES ('DEU', 'Germany (Deutschland)', NULL);
INSERT INTO t_country VALUES ('GHA', 'Ghana', NULL);
INSERT INTO t_country VALUES ('GIB', 'Gibraltar', NULL);
INSERT INTO t_country VALUES ('GBR', 'Great Britain', NULL);
INSERT INTO t_country VALUES ('GRC', 'Greece', NULL);
INSERT INTO t_country VALUES ('GRL', 'Greenland', NULL);
INSERT INTO t_country VALUES ('GRD', 'Grenada', NULL);
INSERT INTO t_country VALUES ('GLP', 'Guadeloupe', NULL);
INSERT INTO t_country VALUES ('GUM', 'Guam', NULL);
INSERT INTO t_country VALUES ('GTM', 'Guatemala', NULL);
INSERT INTO t_country VALUES ('GIN', 'Guinea', NULL);
INSERT INTO t_country VALUES ('GNB', 'Guinea-bissau', NULL);
INSERT INTO t_country VALUES ('GUY', 'Guyana', NULL);
INSERT INTO t_country VALUES ('HTI', 'Haiti', NULL);
INSERT INTO t_country VALUES ('HMD', 'Heard Island and Mcdonald Islands', NULL);
INSERT INTO t_country VALUES ('HND', 'Honduras', NULL);
INSERT INTO t_country VALUES ('HKG', 'Hong Kong (Special Administrative Region of China)', NULL);
INSERT INTO t_country VALUES ('HUN', 'Hungary', NULL);
INSERT INTO t_country VALUES ('ISL', 'Iceland', NULL);
INSERT INTO t_country VALUES ('IND', 'India', NULL);
INSERT INTO t_country VALUES ('IDN', 'Indonesia', NULL);
INSERT INTO t_country VALUES ('IRN', 'Iran (Islamic Republic of Iran)', NULL);
INSERT INTO t_country VALUES ('IRQ', 'Iraq', NULL);
INSERT INTO t_country VALUES ('IRL', 'Ireland', NULL);
INSERT INTO t_country VALUES ('ISR', 'Israel', NULL);
INSERT INTO t_country VALUES ('ITA', 'Italy', NULL);
INSERT INTO t_country VALUES ('JAM', 'Jamaica', NULL);
INSERT INTO t_country VALUES ('JPN', 'Japan', NULL);
INSERT INTO t_country VALUES ('JOR', 'Jordan (Hashemite Kingdom of Jordan)', NULL);
INSERT INTO t_country VALUES ('KAZ', 'Kazakhstan', NULL);
INSERT INTO t_country VALUES ('KEN', 'Kenya', NULL);
INSERT INTO t_country VALUES ('KIR', 'Kiribati', NULL);
INSERT INTO t_country VALUES ('PRK', 'Korea (Democratic Peoples Republic pf [North] Korea)', NULL);
INSERT INTO t_country VALUES ('KOR', 'Korea (Republic of [South] Korea)', NULL);
INSERT INTO t_country VALUES ('KWT', 'Kuwait', NULL);
INSERT INTO t_country VALUES ('KGZ', 'Kyrgyzstan', NULL);
INSERT INTO t_country VALUES ('LAO', 'Lao People''s Democratic Republic', NULL);
INSERT INTO t_country VALUES ('LVA', 'Latvia', NULL);
INSERT INTO t_country VALUES ('LBN', 'Lebanon', NULL);
INSERT INTO t_country VALUES ('LSO', 'Lesotho', NULL);
INSERT INTO t_country VALUES ('LBR', 'Liberia', NULL);
INSERT INTO t_country VALUES ('LBY', 'Libya (Libyan Arab Jamahirya)', NULL);
INSERT INTO t_country VALUES ('LIE', 'Liechtenstein (Fürstentum Liechtenstein)', NULL);
INSERT INTO t_country VALUES ('LTU', 'Lithuania', NULL);
INSERT INTO t_country VALUES ('LUX', 'Luxembourg', NULL);
INSERT INTO t_country VALUES ('MAC', 'Macao (Special Administrative Region of China)', NULL);
INSERT INTO t_country VALUES ('MKD', 'Macedonia (Former Yugoslav Republic of Macedonia)', NULL);
INSERT INTO t_country VALUES ('MDG', 'Madagascar', NULL);
INSERT INTO t_country VALUES ('MWI', 'Malawi', NULL);
INSERT INTO t_country VALUES ('MYS', 'Malaysia', NULL);
INSERT INTO t_country VALUES ('MDV', 'Maldives', NULL);
INSERT INTO t_country VALUES ('MLI', 'Mali', NULL);
INSERT INTO t_country VALUES ('MLT', 'Malta', NULL);
INSERT INTO t_country VALUES ('MHL', 'Marshall Islands', NULL);
INSERT INTO t_country VALUES ('MTQ', 'Martinique', NULL);
INSERT INTO t_country VALUES ('MRT', 'Mauritania', NULL);
INSERT INTO t_country VALUES ('MUS', 'Mauritius', NULL);
INSERT INTO t_country VALUES ('MYT', 'Mayotte', NULL);
INSERT INTO t_country VALUES ('MEX', 'Mexico', NULL);
INSERT INTO t_country VALUES ('FSM', 'Micronesia (Federated States of Micronesia)', NULL);
INSERT INTO t_country VALUES ('MDA', 'Moldova', NULL);
INSERT INTO t_country VALUES ('MCO', 'Monaco', NULL);
INSERT INTO t_country VALUES ('MNG', 'Mongolia', NULL);
INSERT INTO t_country VALUES ('MSR', 'Montserrat', NULL);
INSERT INTO t_country VALUES ('MAR', 'Morocco', NULL);
INSERT INTO t_country VALUES ('MOZ', 'Mozambique (Moçambique)', NULL);
INSERT INTO t_country VALUES ('MMR', 'Myanmar (formerly Burma)', NULL);
INSERT INTO t_country VALUES ('NAM', 'Namibia', NULL);
INSERT INTO t_country VALUES ('NRU', 'Nauru', NULL);
INSERT INTO t_country VALUES ('NPL', 'Nepal', NULL);
INSERT INTO t_country VALUES ('NLD', 'Netherlands', NULL);
INSERT INTO t_country VALUES ('ANT', 'Netherlands Antilles', NULL);
INSERT INTO t_country VALUES ('NCL', 'New Caledonia', NULL);
INSERT INTO t_country VALUES ('NZL', 'New Zealand', NULL);
INSERT INTO t_country VALUES ('NIC', 'Nicaragua', NULL);
INSERT INTO t_country VALUES ('NER', 'Niger', NULL);
INSERT INTO t_country VALUES ('NGA', 'Nigeria', NULL);
INSERT INTO t_country VALUES ('NIU', 'Niue', NULL);
INSERT INTO t_country VALUES ('NFK', 'Norfolk Island', NULL);
INSERT INTO t_country VALUES ('MNP', 'Northern Mariana Islands', NULL);
INSERT INTO t_country VALUES ('NOR', 'Norway', NULL);
INSERT INTO t_country VALUES ('OMN', 'Oman', NULL);
INSERT INTO t_country VALUES ('PAK', 'Pakistan', NULL);
INSERT INTO t_country VALUES ('PLW', 'Palau', NULL);
INSERT INTO t_country VALUES ('PSE', 'Palestinian Territories', NULL);
INSERT INTO t_country VALUES ('PAN', 'Panama', NULL);
INSERT INTO t_country VALUES ('PNG', 'Papua New Guinea', NULL);
INSERT INTO t_country VALUES ('PRY', 'Paraguay', NULL);
INSERT INTO t_country VALUES ('PER', 'Peru', NULL);
INSERT INTO t_country VALUES ('PHL', 'Philippines', NULL);
INSERT INTO t_country VALUES ('PCN', 'Pitcairn', NULL);
INSERT INTO t_country VALUES ('POL', 'Poland', NULL);
INSERT INTO t_country VALUES ('PRT', 'Portugal', NULL);
INSERT INTO t_country VALUES ('PRI', 'Puerto Rico', NULL);
INSERT INTO t_country VALUES ('QAT', 'Qatar', NULL);
INSERT INTO t_country VALUES ('REU', 'RÉunion', NULL);
INSERT INTO t_country VALUES ('ROU', 'Romania', NULL);
INSERT INTO t_country VALUES ('RUS', 'Russian Federation', NULL);
INSERT INTO t_country VALUES ('RWA', 'Rwanda', NULL);
INSERT INTO t_country VALUES ('SHN', 'Saint Helena', NULL);
INSERT INTO t_country VALUES ('KNA', 'Saint Kitts and Nevis', NULL);
INSERT INTO t_country VALUES ('LCA', 'Saint Lucia', NULL);
INSERT INTO t_country VALUES ('SPM', 'Saint Pierre and Miquelon', NULL);
INSERT INTO t_country VALUES ('VCT', 'Saint Vincent and the Grenadines', NULL);
INSERT INTO t_country VALUES ('WSM', 'Samoa (formerly Western Samoa)', NULL);
INSERT INTO t_country VALUES ('SMR', 'San Marino (Republic of)', NULL);
INSERT INTO t_country VALUES ('STP', 'Sao Tome and Principe', NULL);
INSERT INTO t_country VALUES ('SAU', 'Saudi Arabia (Kingdom of Saudi Arabia)', NULL);
INSERT INTO t_country VALUES ('SEN', 'Senegal', NULL);
INSERT INTO t_country VALUES ('SCG', 'Serbia and Montenegro (formerly Yugoslavia)', NULL);
INSERT INTO t_country VALUES ('SYC', 'Seychelles', NULL);
INSERT INTO t_country VALUES ('SLE', 'Sierra Leone', NULL);
INSERT INTO t_country VALUES ('SGP', 'Singapore', NULL);
INSERT INTO t_country VALUES ('SVK', 'Slovakia (Slovak Republic)', NULL);
INSERT INTO t_country VALUES ('SVN', 'Slovenia', NULL);
INSERT INTO t_country VALUES ('SLB', 'Solomon Islands', NULL);
INSERT INTO t_country VALUES ('SOM', 'Somalia', NULL);
INSERT INTO t_country VALUES ('ZAF', 'South Africa (zuid Afrika)', NULL);
INSERT INTO t_country VALUES ('SGS', 'South Georgia and the South Sandwich Islands', NULL);
INSERT INTO t_country VALUES ('ESP', 'Spain (españa)', NULL);
INSERT INTO t_country VALUES ('LKA', 'Sri Lanka', NULL);
INSERT INTO t_country VALUES ('SDN', 'Sudan', NULL);
INSERT INTO t_country VALUES ('SUR', 'Suriname', NULL);
INSERT INTO t_country VALUES ('SJM', 'Svalbard and Jan Mayen', NULL);
INSERT INTO t_country VALUES ('SWZ', 'Swaziland', NULL);
INSERT INTO t_country VALUES ('SWE', 'Sweden', NULL);
INSERT INTO t_country VALUES ('CHE', 'Switzerland (Confederation of Helvetia)', NULL);
INSERT INTO t_country VALUES ('SYR', 'Syrian Arab Republic', NULL);
INSERT INTO t_country VALUES ('TWN', 'Taiwan ("Chinese Taipei" for IOC)', NULL);
INSERT INTO t_country VALUES ('TJK', 'Tajikistan', NULL);
INSERT INTO t_country VALUES ('TZA', 'Tanzania', NULL);
INSERT INTO t_country VALUES ('THA', 'Thailand', NULL);
INSERT INTO t_country VALUES ('TLS', 'Timor-Leste (formerly East Timor)', NULL);
INSERT INTO t_country VALUES ('TGO', 'Togo', NULL);
INSERT INTO t_country VALUES ('TKL', 'Tokelau', NULL);
INSERT INTO t_country VALUES ('TON', 'Tonga', NULL);
INSERT INTO t_country VALUES ('TTO', 'Trinidad and Tobago', NULL);
INSERT INTO t_country VALUES ('TUN', 'Tunisia', NULL);
INSERT INTO t_country VALUES ('TUR', 'Turkey', NULL);
INSERT INTO t_country VALUES ('TKM', 'Turkmenistan', NULL);
INSERT INTO t_country VALUES ('TCA', 'Turks and Caicos Islands', NULL);
INSERT INTO t_country VALUES ('TUV', 'Tuvalu', NULL);
INSERT INTO t_country VALUES ('UGA', 'Uganda', NULL);
INSERT INTO t_country VALUES ('UKR', 'Ukraine', NULL);
INSERT INTO t_country VALUES ('ARE', 'United Arab Emirates', NULL);
INSERT INTO t_country VALUES ('USA', 'United States', NULL);
INSERT INTO t_country VALUES ('UMI', 'United States Minor Outlying Islands', NULL);
INSERT INTO t_country VALUES ('URY', 'Uruguay', NULL);
INSERT INTO t_country VALUES ('UZB', 'Uzbekistan', NULL);
INSERT INTO t_country VALUES ('VUT', 'Vanuatu', NULL);
INSERT INTO t_country VALUES ('VAT', 'Vatican City (Holy See)', NULL);
INSERT INTO t_country VALUES ('VEN', 'Venezuela', NULL);
INSERT INTO t_country VALUES ('VNM', 'Viet Nam', NULL);
INSERT INTO t_country VALUES ('VGB', 'Virgin Islands', NULL);
INSERT INTO t_country VALUES ('VIR', 'Virgin Islands', NULL);
INSERT INTO t_country VALUES ('WLF', 'Wallis and Futuna', NULL);
INSERT INTO t_country VALUES ('ESH', 'Western Sahara (formerly Spanish Sahara)', NULL);
INSERT INTO t_country VALUES ('YEM', 'Yemen (Arab Republic)', NULL);
INSERT INTO t_country VALUES ('ZMB', 'Zambia', NULL);
INSERT INTO t_country VALUES ('ZWE', 'Zimbabwe', NULL);

--
-- TOC entry 1979 (class 0 OID 16436)
-- Dependencies: 170
-- Data for Name: t_eventstatus; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO t_eventstatus(displayname, description) VALUES ('Open', 'The event is opened');
INSERT INTO t_eventstatus(displayname, description) VALUES ('Closed', 'The event is closed');
INSERT INTO t_eventstatus(displayname, description) VALUES ('Cancelled', 'The event has been cancelled');

--
-- TOC entry 1979 (class 0 OID 16436)
-- Dependencies: 170
-- Data for Name: t_orderstatus; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO t_orderstatus(displayname, description) VALUES ('In Progress', 'The order is in progress');
INSERT INTO t_orderstatus(displayname, description) VALUES ('Completed', 'The order has been completed');
INSERT INTO t_orderstatus(displayname, description) VALUES ('Voided', 'The order has been voided');

--
-- TOC entry 1983 (class 0 OID 16457)
-- Dependencies: 174
-- Data for Name: t_usertype; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO t_usertype(displayname, description) VALUES ('Private', 'This is a private customer');
INSERT INTO t_usertype(displayname, description) VALUES ('Business', 'This is a business customer');
INSERT INTO t_usertype(displayname, description) VALUES ('SiteAdmin', 'This is a site administrator');
