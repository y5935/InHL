create table user (
	`username` varchar (32) not null,
	`password` varchar (32) not null,
	`profession` varchar (20) not null,
	`classAndGrade` varchar (20) not null,
	`realname` varchar (20) not null,
	`sex` varchar (6) not null,
	`level` tinyint(1) not null,
	primary key (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table tijian (
	`username` varchar (32) not null,
	`height` int (11) not null,
	`weight` int (11) not null,
	`vitalCapacity` int (11) not null,
	`chestCircumference` int (11) not null,
	`leftEye` varchar (11) not null,
	`rigthEye` varchar (11) not null,
	`remark` varchar (64) not null,
	primary key (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;