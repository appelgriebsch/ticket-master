--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.1
-- Dumped by pg_dump version 9.1.1
-- Started on 2011-10-23 19:23:07 CEST

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

SET default_with_oids = false;

--
-- TOC entry 161 (class 1259 OID 16911)
-- Dependencies: 5
-- Name: t_address; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE t_address (
    id serial NOT NULL,
    type int NOT NULL,
    addressline character varying(80) NOT NULL,
    streetname character varying(128) NOT NULL,
    zipcode character varying(20) NOT NULL,
    cityname character varying(40) NOT NULL,
    countrycode character varying(3) NOT NULL,
    districtcode character varying(20) NOT NULL
);


--
-- TOC entry 162 (class 1259 OID 16914)
-- Dependencies: 5
-- Name: t_addresstype; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE t_addresstype (
    id serial NOT NULL,
    displayname character varying(20) NOT NULL,
    description text
);


--
-- TOC entry 163 (class 1259 OID 16920)
-- Dependencies: 5
-- Name: t_artist; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE t_artist (
    id serial NOT NULL,
    displayname character varying(80) NOT NULL,
    firstname character varying(40),
    lastname character varying(40),
    genre int NOT NULL
);


--
-- TOC entry 168 (class 1259 OID 16944)
-- Dependencies: 5
-- Name: t_category; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE t_category (
    id serial NOT NULL,
    displayname character varying(20) NOT NULL,
    description text
);


--
-- TOC entry 164 (class 1259 OID 16923)
-- Dependencies: 5
-- Name: t_country; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE t_country (
    isocode character varying(3) NOT NULL,
    name character varying(80) NOT NULL,
    description text
);


--
-- TOC entry 165 (class 1259 OID 16929)
-- Dependencies: 5
-- Name: t_event; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE t_event (
    id serial NOT NULL,
    startdate timestamp with time zone NOT NULL,
    enddate timestamp with time zone NOT NULL,
    description text NOT NULL,
    adurl character varying(255) NOT NULL,
    location bigint NOT NULL,
    maxtickets integer NOT NULL,
    price numeric NOT NULL,
    category serial NOT NULL,
    status int NOT NULL
);

--
-- TOC entry 170 (class 1259 OID 16953)
-- Dependencies: 5
-- Name: t_eventstatus; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE t_eventstatus (
    id serial NOT NULL,
    displayname character varying(20) NOT NULL,
    description text
);


--
-- TOC entry 166 (class 1259 OID 16935)
-- Dependencies: 5
-- Name: t_event_artist; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE t_event_artist (
    eventid int NOT NULL,
    artistid int NOT NULL
);


--
-- TOC entry 167 (class 1259 OID 16938)
-- Dependencies: 5
-- Name: t_genre; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE t_genre (
    id serial NOT NULL,
    displayname character varying(20) NOT NULL,
    description text
);


--
-- TOC entry 169 (class 1259 OID 16950)
-- Dependencies: 5
-- Name: t_order; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE t_order (
    id serial NOT NULL,
    userid int NOT NULL,
    eventid int NOT NULL,
    date timestamp with time zone NOT NULL,
    quantity integer NOT NULL,
    status int NOT NULL,
    "shippingAddress" int NOT NULL,
    "billingAddress" int NOT NULL
);


--
-- TOC entry 170 (class 1259 OID 16953)
-- Dependencies: 5
-- Name: t_orderstatus; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE t_orderstatus (
    id serial NOT NULL,
    displayname character varying(20) NOT NULL,
    description text
);


--
-- TOC entry 171 (class 1259 OID 16959)
-- Dependencies: 5
-- Name: t_rating; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE t_rating (
    id serial NOT NULL,
    rating numeric NOT NULL,
    comment text,
    date timestamp with time zone NOT NULL
);


--
-- TOC entry 172 (class 1259 OID 16965)
-- Dependencies: 5
-- Name: t_user; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE t_user (
    id serial NOT NULL,
    salutation character varying(8) NOT NULL,
    firstname character varying(40) NOT NULL,
    lastname character varying(40) NOT NULL,
    gender int NOT NULL,
    birthdate date NOT NULL,
    type int NOT NULL,
    username character varying(40) NOT NULL,
    password character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    status int NOT NULL
);


--
-- TOC entry 174 (class 1259 OID 16977)
-- Dependencies: 5
-- Name: t_user_address; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE t_user_address (
    userid int NOT NULL,
    addressid int NOT NULL
);


--
-- TOC entry 173 (class 1259 OID 16971)
-- Dependencies: 5
-- Name: t_usertype; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE t_usertype (
    id serial NOT NULL,
    displayname character varying(20) NOT NULL,
    description text
);


--
-- TOC entry 2162 (class 2606 OID 16981)
-- Dependencies: 161 161
-- Name: pk_address; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_address
    ADD CONSTRAINT pk_address PRIMARY KEY (id);


--
-- TOC entry 2164 (class 2606 OID 16983)
-- Dependencies: 162 162
-- Name: pk_addresstype; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_addresstype
    ADD CONSTRAINT pk_addresstype PRIMARY KEY (id);


--
-- TOC entry 2168 (class 2606 OID 16985)
-- Dependencies: 163 163
-- Name: pk_artist; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_artist
    ADD CONSTRAINT pk_artist PRIMARY KEY (id);


--
-- TOC entry 2186 (class 2606 OID 16995)
-- Dependencies: 168 168
-- Name: pk_category; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_category
    ADD CONSTRAINT pk_category PRIMARY KEY (id);


--
-- TOC entry 2172 (class 2606 OID 16987)
-- Dependencies: 164 164
-- Name: pk_countrycode; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_country
    ADD CONSTRAINT pk_countrycode PRIMARY KEY (isocode);


--
-- TOC entry 2176 (class 2606 OID 16989)
-- Dependencies: 165 165
-- Name: pk_event; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_event
    ADD CONSTRAINT pk_event PRIMARY KEY (id);


--
-- TOC entry 2180 (class 2606 OID 16991)
-- Dependencies: 166 166 166
-- Name: pk_event_artist; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_event_artist
    ADD CONSTRAINT pk_event_artist PRIMARY KEY (eventid, artistid);

--
-- TOC entry 2199 (class 2606 OID 16999)
-- Dependencies: 170 170
-- Name: t_eventstatus; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_eventstatus
    ADD CONSTRAINT pk_eventstatus PRIMARY KEY (id);

--
-- TOC entry 2182 (class 2606 OID 16993)
-- Dependencies: 167 167
-- Name: pk_genre; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_genre
    ADD CONSTRAINT pk_genre PRIMARY KEY (id);


--
-- TOC entry 2195 (class 2606 OID 16997)
-- Dependencies: 169 169
-- Name: pk_order; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_order
    ADD CONSTRAINT pk_order PRIMARY KEY (id);


--
-- TOC entry 2199 (class 2606 OID 16999)
-- Dependencies: 170 170
-- Name: pk_orderstatus; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_orderstatus
    ADD CONSTRAINT pk_orderstatus PRIMARY KEY (id);


--
-- TOC entry 2204 (class 2606 OID 17001)
-- Dependencies: 171 171
-- Name: pk_rating; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_rating
    ADD CONSTRAINT pk_rating PRIMARY KEY (id);


--
-- TOC entry 2207 (class 2606 OID 17003)
-- Dependencies: 172 172
-- Name: pk_user; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_user
    ADD CONSTRAINT pk_user PRIMARY KEY (id);


--
-- TOC entry 2217 (class 2606 OID 17007)
-- Dependencies: 174 174 174
-- Name: pk_user_address; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_user_address
    ADD CONSTRAINT pk_user_address PRIMARY KEY (userid, addressid);


--
-- TOC entry 2211 (class 2606 OID 17005)
-- Dependencies: 173 173
-- Name: pk_usertype; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_usertype
    ADD CONSTRAINT pk_usertype PRIMARY KEY (id);


--
-- TOC entry 2166 (class 2606 OID 17009)
-- Dependencies: 162 162
-- Name: unq_addresstype_displayname; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_addresstype
    ADD CONSTRAINT unq_addresstype_displayname UNIQUE (displayname);


--
-- TOC entry 2170 (class 2606 OID 17011)
-- Dependencies: 163 163
-- Name: unq_artist_displayname; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_artist
    ADD CONSTRAINT unq_artist_displayname UNIQUE (displayname);


--
-- TOC entry 2188 (class 2606 OID 17015)
-- Dependencies: 168 168
-- Name: unq_category_displayname; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_category
    ADD CONSTRAINT unq_category_displayname UNIQUE (displayname);


--
-- TOC entry 2201 (class 2606 OID 17019)
-- Dependencies: 170 170
-- Name: unq_eventstatus_displayname; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_eventstatus
    ADD CONSTRAINT unq_eventstatus_displayname UNIQUE (displayname);
    
--
-- TOC entry 2184 (class 2606 OID 17013)
-- Dependencies: 167 167
-- Name: unq_genre_displayname; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_genre
    ADD CONSTRAINT unq_genre_displayname UNIQUE (displayname);


--
-- TOC entry 2197 (class 2606 OID 17017)
-- Dependencies: 169 169 169
-- Name: unq_order_user_event; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_order
    ADD CONSTRAINT unq_order_user_event UNIQUE (userid, eventid, date);


--
-- TOC entry 2201 (class 2606 OID 17019)
-- Dependencies: 170 170
-- Name: unq_orderstatus_displayname; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_orderstatus
    ADD CONSTRAINT unq_orderstatus_displayname UNIQUE (displayname);


--
-- TOC entry 2209 (class 2606 OID 17021)
-- Dependencies: 172 172
-- Name: unq_user_username; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_user
    ADD CONSTRAINT unq_user_username UNIQUE (username);


--
-- TOC entry 2213 (class 2606 OID 17023)
-- Dependencies: 173 173
-- Name: unq_usertype_displayname; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_usertype
    ADD CONSTRAINT unq_usertype_displayname UNIQUE (displayname);


--
-- TOC entry 2159 (class 1259 OID 17024)
-- Dependencies: 161
-- Name: fki_address_addresstype; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_address_addresstype ON t_address USING btree (type);


--
-- TOC entry 2160 (class 1259 OID 17025)
-- Dependencies: 161
-- Name: fki_address_country; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_address_country ON t_address USING btree (countrycode);


--
-- TOC entry 2173 (class 1259 OID 17026)
-- Dependencies: 165
-- Name: fki_event_address; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_event_address ON t_event USING btree (location);


--
-- TOC entry 2177 (class 1259 OID 17027)
-- Dependencies: 166
-- Name: fki_event_artist_artist; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_event_artist_artist ON t_event_artist USING btree (artistid);

--
-- TOC entry 2191 (class 1259 OID 17029)
-- Dependencies: 169
-- Name: fki_event_eventstatus; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_event_eventstatus ON t_event USING btree (status);

--
-- TOC entry 2174 (class 1259 OID 17095)
-- Dependencies: 165
-- Name: fki_event_category; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_event_category ON t_event USING btree (category);


--
-- TOC entry 2189 (class 1259 OID 17119)
-- Dependencies: 169
-- Name: fki_order_billingaddress; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_order_billingaddress ON t_order USING btree ("billingAddress");


--
-- TOC entry 2190 (class 1259 OID 17028)
-- Dependencies: 169
-- Name: fki_order_event; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_order_event ON t_order USING btree (eventid);


--
-- TOC entry 2191 (class 1259 OID 17029)
-- Dependencies: 169
-- Name: fki_order_orderstatus; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_order_orderstatus ON t_order USING btree (status);


--
-- TOC entry 2192 (class 1259 OID 17113)
-- Dependencies: 169
-- Name: fki_order_shippingaddress; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_order_shippingaddress ON t_order USING btree ("shippingAddress");


--
-- TOC entry 2193 (class 1259 OID 17030)
-- Dependencies: 169
-- Name: fki_order_user; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_order_user ON t_order USING btree (userid);


--
-- TOC entry 2202 (class 1259 OID 17031)
-- Dependencies: 171
-- Name: fki_rating_order; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_rating_order ON t_rating USING btree (id);


--
-- TOC entry 2178 (class 1259 OID 17032)
-- Dependencies: 166
-- Name: fki_t_event_artist_event; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_t_event_artist_event ON t_event_artist USING btree (eventid);


--
-- TOC entry 2214 (class 1259 OID 17107)
-- Dependencies: 174
-- Name: fki_user_address_address; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_user_address_address ON t_user_address USING btree (addressid);


--
-- TOC entry 2215 (class 1259 OID 17101)
-- Dependencies: 174
-- Name: fki_user_address_user; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_user_address_user ON t_user_address USING btree (userid);


--
-- TOC entry 2205 (class 1259 OID 17033)
-- Dependencies: 172
-- Name: fki_user_usertype; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX fki_user_usertype ON t_user USING btree (type);


--
-- TOC entry 2218 (class 2606 OID 17034)
-- Dependencies: 162 161 2163
-- Name: fk_address_addresstype; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_address
    ADD CONSTRAINT fk_address_addresstype FOREIGN KEY (type) REFERENCES t_addresstype(id);


--
-- TOC entry 2219 (class 2606 OID 17039)
-- Dependencies: 161 164 2171
-- Name: fk_address_country; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_address
    ADD CONSTRAINT fk_address_country FOREIGN KEY (countrycode) REFERENCES t_country(isocode);


--
-- TOC entry 2220 (class 2606 OID 17044)
-- Dependencies: 163 167 2181
-- Name: fk_artist_genre; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_artist
    ADD CONSTRAINT fk_artist_genre FOREIGN KEY (genre) REFERENCES t_genre(id);


--
-- TOC entry 2221 (class 2606 OID 17049)
-- Dependencies: 2161 165 161
-- Name: fk_event_address; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_event
    ADD CONSTRAINT fk_event_address FOREIGN KEY (location) REFERENCES t_address(id);


--
-- TOC entry 2223 (class 2606 OID 17054)
-- Dependencies: 166 2167 163
-- Name: fk_event_artist_artist; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_event_artist
    ADD CONSTRAINT fk_event_artist_artist FOREIGN KEY (artistid) REFERENCES t_artist(id);


--
-- TOC entry 2222 (class 2606 OID 17090)
-- Dependencies: 165 168 2185
-- Name: fk_event_category; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_event
    ADD CONSTRAINT fk_event_category FOREIGN KEY (category) REFERENCES t_category(id);

--
-- TOC entry 2226 (class 2606 OID 17064)
-- Dependencies: 170 2198 169
-- Name: fk_event_eventstatus; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_event
    ADD CONSTRAINT fk_event_eventstatus FOREIGN KEY (status) REFERENCES t_eventstatus(id);
    
--
-- TOC entry 2229 (class 2606 OID 17114)
-- Dependencies: 169 161 2161
-- Name: fk_order_billingaddress; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_order
    ADD CONSTRAINT fk_order_billingaddress FOREIGN KEY ("billingAddress") REFERENCES t_address(id);


--
-- TOC entry 2225 (class 2606 OID 17059)
-- Dependencies: 2175 169 165
-- Name: fk_order_event; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_order
    ADD CONSTRAINT fk_order_event FOREIGN KEY (eventid) REFERENCES t_event(id);


--
-- TOC entry 2226 (class 2606 OID 17064)
-- Dependencies: 170 2198 169
-- Name: fk_order_orderstatus; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_order
    ADD CONSTRAINT fk_order_orderstatus FOREIGN KEY (status) REFERENCES t_orderstatus(id);


--
-- TOC entry 2228 (class 2606 OID 17108)
-- Dependencies: 169 161 2161
-- Name: fk_order_shippingaddress; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_order
    ADD CONSTRAINT fk_order_shippingaddress FOREIGN KEY ("shippingAddress") REFERENCES t_address(id);


--
-- TOC entry 2227 (class 2606 OID 17069)
-- Dependencies: 172 2206 169
-- Name: fk_order_user; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_order
    ADD CONSTRAINT fk_order_user FOREIGN KEY (userid) REFERENCES t_user(id);


--
-- TOC entry 2230 (class 2606 OID 17074)
-- Dependencies: 169 171 2194
-- Name: fk_rating_order; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_rating
    ADD CONSTRAINT fk_rating_order FOREIGN KEY (id) REFERENCES t_order(id);


--
-- TOC entry 2233 (class 2606 OID 17102)
-- Dependencies: 174 2161 161
-- Name: fk_user_address_address; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_user_address
    ADD CONSTRAINT fk_user_address_address FOREIGN KEY (addressid) REFERENCES t_address(id);


--
-- TOC entry 2232 (class 2606 OID 17096)
-- Dependencies: 174 172 2206
-- Name: fk_user_address_user; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_user_address
    ADD CONSTRAINT fk_user_address_user FOREIGN KEY (userid) REFERENCES t_user(id);


--
-- TOC entry 2231 (class 2606 OID 17079)
-- Dependencies: 172 173 2210
-- Name: fk_user_usertype; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_user
    ADD CONSTRAINT fk_user_usertype FOREIGN KEY (type) REFERENCES t_usertype(id);


--
-- TOC entry 2224 (class 2606 OID 17084)
-- Dependencies: 166 165 2175
-- Name: t_event_artist_event; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY t_event_artist
    ADD CONSTRAINT t_event_artist_event FOREIGN KEY (eventid) REFERENCES t_event(id);


-- Completed on 2011-10-23 19:23:07 CEST

--
-- PostgreSQL database dump complete
--

