CREATE TABLE PLACE(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	slug VARCHAR(50),
	city VARCHAR(50) NOT NULL,
	state VARCHAR(50) NOT NULL,
	created_at  DATE NOT NULL,
	updated_at  DATE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO PLACE (name, slug, city, state, created_at, updated_at) VALUES(
	'Ibirapuera', null, 'São Paulo', 'SP', '2019-11-28', null
);