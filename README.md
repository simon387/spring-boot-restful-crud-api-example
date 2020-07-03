# spring-boot-restful-crud-api-example

## About
Spring Boot RESTful CRUD API Examples with MySQL database

+ Gradle 4.0+
+ Java 1.8+
+ Spring Boot
+ Spring JPA
+ Hibernate
+ MySQL 5.6+ / MariaDB

With example tables ```person``` and ```phone```

## Database setup

Create Database Example

```sql
create schema spring_boot_demo;
```

Create Table Example

```sql
CREATE TABLE `person`
(
    `id`   INT         NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
);
```

```sql
CREATE TABLE `phone`
(
    `id`        INT         NOT NULL AUTO_INCREMENT,
    `person_id` INT         NULL,
    `phone`     VARCHAR(45) NULL,
    PRIMARY KEY (`id`),
    INDEX `PERSON_FK_idx` (`person_id` ASC),
    CONSTRAINT `PERSON_FK`
        FOREIGN KEY (`person_id`)
            REFERENCES `person` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);
```

## How to start

Now you can start Spring Boot-based application by following command (from app root):

```
gradle bootRun
```

For stopping embedded Tomcat use next command:

```
gradle -stop
```

Try to execute test command (use browser or curl):

```
curl localhost:8080/api/add?name=newUserName
```

Default test REST API supports following commands:

```
- /api/get?id=<PERSON_ID> (GET)
- /api/add?name=<NAME>[&phone=<PHONE>] (GET)
- /api/edit?id=<PERSON_ID>[&name=<NEW_NAME>&phone=<NEW_PHONE>] (GET)
- /api/delete?id=<PERSON_ID> (GET)
```

## TODO

+ rename entity, add dtos
+ add one annotation example
+ add StringPool
+ add Config
+ add AOP with interceptort
+ add cross origin setting
+ add schedulers