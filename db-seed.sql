drop database if exists sample;
create database sample;
use sample;

CREATE TABLE `message` (
  `id` varchar(11) NOT NULL DEFAULT '',
  `value` varchar(11) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;