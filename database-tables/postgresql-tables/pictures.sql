CREATE TABLE public.pictures (
	id bpchar(36) NOT NULL,
	id_user bpchar(36) NOT NULL,
	id_entity bpchar(36) NULL,
	public_id varchar(255) NOT NULL,
	filename varchar(255) NULL,
	url varchar(500) NOT NULL,
	CONSTRAINT pictures_pk PRIMARY KEY (id),
	CONSTRAINT pictures_user_fk FOREIGN KEY (id_user) REFERENCES public.users(id)
);