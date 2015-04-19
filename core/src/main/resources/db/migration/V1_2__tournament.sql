CREATE TABLE tournament (
    id bigint not null,
    name varchar(255) not null,
    location varchar(255) not null,
    numPitches bigint not null,
);

insert into tournament (id, name, location, numPitches) values (1, 'Unileague', 'Santry', 6);