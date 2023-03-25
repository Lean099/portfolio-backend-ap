CREATE TABLE public.address (
	id CHAR(36) NOT NULL,
    id_user CHAR(36) NOT NULL,
	country CHAR(36) NULL,
	city CHAR(36) NULL,
	province CHAR(36) NULL,
	CONSTRAINT address_PK PRIMARY KEY (id),
    CONSTRAINT address_city_FK FOREIGN KEY (city) REFERENCES public.city(id),
	CONSTRAINT address_country_FK FOREIGN KEY (country) REFERENCES public.country(id),
	CONSTRAINT address_province_FK FOREIGN KEY (province) REFERENCES public.province(id),
	CONSTRAINT address_users_FK FOREIGN KEY (id_user) REFERENCES public.users(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;