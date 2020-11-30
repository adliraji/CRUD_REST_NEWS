CREATE TABLE `logol_${adlir}`.`news`
 ( `id` VARCHAR(100) NOT NULL ,
 `title` VARCHAR(100) NOT NULL ,
 `description` TEXT NOT NULL , 
 `created_date` DATETIME(100) NOT NULL ) 
 ENGINE = InnoDB;