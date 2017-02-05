# kafka-sample

`Sample Producer`
Kafka sample producer 

`Sample Consumer`
Kafka sample consumer


`Sample FileReader`
Read data from input.txt and published it to topic

`Sample DBConnection`
Consumes the message from the topic and save in mysql store

`Message`
Sample event class

`MessageDecoder`
Deserializer class for Message Object

`MessageEncoder`
Serializer class for Message Object


`Mysql`
DB Name: sample

CREATE TABLE `message` (
  `id` varchar(11) NOT NULL DEFAULT '',
  `value` varchar(11) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;