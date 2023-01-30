CREATE TABLE public."work" (
	id char(36) NOT NULL,
	id_user char(36) NOT NULL,
	company varchar(100) NULL,
	job varchar(100) NULL,
	startdate date NULL,
	enddate date NULL,
	id_picture char(36) NOT NULL,
	CONSTRAINT work_pk PRIMARY KEY (id),
	CONSTRAINT work_fk FOREIGN KEY (id_user) REFERENCES public.users(id)
);