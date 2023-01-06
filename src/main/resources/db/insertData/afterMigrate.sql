set foreign_key_checks = 0;

truncate table clients;
truncate table orders;
truncate table products;
truncate table revinfo;
truncate table clients_audit;

set foreign_key_checks = 1;
