CREATE TABLE public.users (
	id bpchar(36) NOT NULL,
	firstname varchar(100) NULL,
	lastname varchar(100) NULL,
	email varchar(100) NOT NULL,
	"password" varchar(255) NOT NULL,
	about text NULL,
	dob date NULL,
	address bpchar(36) NULL,
	id_profile_picture bpchar(36) NULL,
	id_banner_picture bpchar(36) NULL,
	phone varchar(20) NULL,
	github_url varchar(500) NULL,
	linkedin_url varchar(500) NULL,
	CONSTRAINT users_pk PRIMARY KEY (id),
	CONSTRAINT users_address_fk FOREIGN KEY (address) REFERENCES public.address(id),
	CONSTRAINT users_banner_pictures_fk FOREIGN KEY (id_banner_picture) REFERENCES public.pictures(id),
	CONSTRAINT users_profile_pictures_fk FOREIGN KEY (id_profile_picture) REFERENCES public.pictures(id)
);