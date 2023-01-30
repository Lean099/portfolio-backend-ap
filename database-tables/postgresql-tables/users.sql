CREATE TABLE public.users (
	id char(36) NOT NULL,
	firstname varchar(100) NULL,
	lastname varchar(100) NULL,
	email varchar(100) NOT NULL,
	"password" char(60) NOT NULL,
	about text NULL,
	dob date NULL,
	city varchar(50) NULL,
	id_profile_picture char(36) NULL,
	id_banner_picture char(36) NULL,
	CONSTRAINT users_pk PRIMARY KEY (id)
);