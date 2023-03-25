CREATE TABLE public."work" (
	id bpchar(36) NOT NULL,
	id_user bpchar(36) NOT NULL,
	company varchar(100) NULL,
	job varchar(100) NULL,
	startdate date NULL,
	enddate date NULL,
	id_picture bpchar(36) NULL,
	CONSTRAINT work_pk PRIMARY KEY (id),
	CONSTRAINT work_picture_fk FOREIGN KEY (id_picture) REFERENCES public.pictures(id),
	CONSTRAINT work_user_fk FOREIGN KEY (id_user) REFERENCES public.users(id)
);