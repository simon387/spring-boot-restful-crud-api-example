# spring-boot-restful-crud-api-example
Spring Boot RESTful CRUD API Examples with MySQL database

## db setup

Create Database Example

```sql
create schema spring_boot_demo;
```

Create Table Example

```sql
CREATE TABLE `product`
(
    `id`    int(11)     NOT NULL AUTO_INCREMENT,
    `name`  varchar(45) NOT NULL,
    `price` float       NOT NULL,
    PRIMARY KEY (`id`)
);
```