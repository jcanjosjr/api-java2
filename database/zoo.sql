CREATE SCHEMA IF NOT EXISTS zoo DEFAULT CHARACTER SET utf8 ;
USE zoo;

CREATE TABLE leao (
	id INT NOT NULL AUTO_INCREMENT,
	nome varchar(255) NOT NULL,
	alimentacao INT NOT NULL,
	visitantes INT NOT NULL,
	jaula_id INT NOT NULL,
	PRIMARY KEY (id),
    UNIQUE INDEX idL_UNIQUE (id ASC)
) ENGINE = InnoDB;

CREATE TABLE jaula (
	id INT NOT NULL AUTO_INCREMENT,
	descricao varchar(255) NOT NULL,
	PRIMARY KEY (id),
    UNIQUE INDEX idJ_UNIQUE (id ASC)
) ENGINE = InnoDB;

CREATE TABLE golfinho (
	id INT NOT NULL AUTO_INCREMENT,
	nome varchar(255) NOT NULL,
	treinamento INT NOT NULL,
	jaula_id INT NOT NULL,
	PRIMARY KEY (id),
    UNIQUE INDEX idG_UNIQUE (id ASC)
) ENGINE InnoDB;

CREATE TABLE alimentacao (
	id INT NOT NULL AUTO_INCREMENT,
	leao_id INT NOT NULL,
	data DATE NOT NULL,
	detalhes varchar(255) NOT NULL,
	PRIMARY KEY (id),
    UNIQUE INDEX idA_UNIQUE (id ASC)
) ENGINE InnoDB;

CREATE TABLE treinamento (
	id INT NOT NULL AUTO_INCREMENT,
	golfinho_id INT NOT NULL,
	data DATE NOT NULL,
	detalhes varchar(255) NOT NULL,
	PRIMARY KEY (id),
    UNIQUE INDEX idT (id ASC)
) ENGINE InnoDB;


ALTER TABLE `leao` ADD CONSTRAINT `leao_fk0` FOREIGN KEY (`jaula_id`) REFERENCES `jaula`(`id`);

ALTER TABLE `golfinho` ADD CONSTRAINT `golfinho_fk0` FOREIGN KEY (`jaula_id`) REFERENCES `jaula`(`id`);

ALTER TABLE `alimentacao` ADD CONSTRAINT `alimentacao_fk0` FOREIGN KEY (`leao_id`) REFERENCES `leao`(`id`);

ALTER TABLE `treinamento` ADD CONSTRAINT `treinamento_fk0` FOREIGN KEY (`golfinho_id`) REFERENCES `golfinho`(`id`);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO jaula VALUES (1, 'Jaula para Leão');
INSERT INTO jaula VALUES (2, 'Jaula para Golfinhos');
INSERT INTO golfinho VALUES (1, 'Vigarista', 2, 2);
INSERT INTO leao VALUES (1, 'Dudu Duelista', 2, 1, 1);
