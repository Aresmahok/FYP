CREATE TABLE player (
	id bigint not null,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	player_number bigint,
	team_id bigint
);

CREATE TABLE team (
	id bigint not null,
	name VARCHAR(255),
	short_hand_name varchar(255) not null,
	initial_seeding bigint,
	current_seeding bigint,
	spirit_score bigint
);

insert into team (id, name, short_hand_name, initial_seeding) values (1, 'The Blazers', 'Blaze Hard', 2);
insert into player (id, first_name, last_name, team_id, player_number) values (1, 'Bob', 'Marl', 1, 420);
insert into player (id, first_name, last_name, team_id, player_number) values (2, 'Randy', 'Bobandy', 1,  69)