CREATE TABLE public.address (
	id bpchar(36) NOT NULL,
	id_user bpchar(36) NOT NULL,
	country bpchar(36) NULL,
	city bpchar(36) NULL,
	province bpchar(36) NULL,
	CONSTRAINT address_pk PRIMARY KEY (id),
	CONSTRAINT address_city_fk FOREIGN KEY (city) REFERENCES public.city(id),
	CONSTRAINT address_country_fk FOREIGN KEY (country) REFERENCES public.country(id),
	CONSTRAINT address_province_fk FOREIGN KEY (province) REFERENCES public.province(id),
	CONSTRAINT address_users_fk FOREIGN KEY (id_user) REFERENCES public.users(id)
);