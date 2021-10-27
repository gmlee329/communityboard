create table if not exists `board`
(
    `doc_no` int(10) not null,
    `title` varchar(400)  not null,
    `content` varchar(4000) not null,
    `writer` varchar(400)  not null,
    `reg_dttm` datetime default current_timestamp,
    `view_count` int(10) default 0,
    primary key (`doc_no`)
);

create table if not exists `reply`
(
    `reply_no` int(10) not null,
    `doc_no` int(10) not null,
    `writer` varchar(400)  not null,
    `comment` varchar(4000) not null,
    `reg_dttm` datetime default current_timestamp,
    primary key (`reply_no`, `doc_no`),
    foreign key (`doc_no`) references `board` (`doc_no`)
);