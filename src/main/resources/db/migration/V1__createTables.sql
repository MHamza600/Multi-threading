CREATE TABLE if not exists request_details (
  id int(20) NOT NULL AUTO_INCREMENT,
  method_call varchar(100) DEFAULT NULL,
  parameters TEXT DEFAULT NULL,
  url TEXT DEFAULT NULL,
  request_date DATETIME DEFAULT now(),
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE if not exists counter_details (
  id int(20) NOT NULL AUTO_INCREMENT,
  thread_name varchar(200) DEFAULT NULL,
  thread_value int(5) DEFAULT NULL,
  request_time DATETIME DEFAULT now(),
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;