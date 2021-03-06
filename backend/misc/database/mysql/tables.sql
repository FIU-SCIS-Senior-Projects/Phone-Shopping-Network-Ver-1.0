-- -----------------------------------------------------
-- Schema psnv1
-- -----------------------------------------------------
-- Phone Shopping Network Version 1

-- -----------------------------------------------------
-- Table User
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS User (
  userName VARCHAR(30) NOT NULL,
  firstName VARCHAR(45) NULL,
  lastName VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  phone VARCHAR(15) NULL,
  PRIMARY KEY (userName))
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table Roles
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Roles (
  roleId INT NOT NULL AUTO_INCREMENT,
  roleName VARCHAR(15) NOT NULL,
  description VARCHAR(45) NULL,
  PRIMARY KEY (roleId))
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table UserRoles
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS UserRoles (
  userName VARCHAR(30) NOT NULL,
  roleId INT NOT NULL)
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table Address
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Address (
  addressId INT NOT NULL AUTO_INCREMENT,
  addressLineOne VARCHAR(45) NOT NULL,
  addressLineTwo VARCHAR(30) NULL,
  city VARCHAR(15) NULL,
  state VARCHAR(15) NULL,
  zipCode VARCHAR(5) NOT NULL,
  PRIMARY KEY (addressId))
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table Product
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Product (
  productId INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(45) NULL,
  description VARCHAR(200) NULL,
  info VARCHAR(300) NULL,
  PRIMARY KEY (productId))
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table Order
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Orders (
  orderId INT NOT NULL AUTO_INCREMENT,
  orderNumber VARCHAR(50) NOT NULL,
  orderStatus VARCHAR(10) NULL,
  shippingAddress INT,
  billingAddress INT,
  PRIMARY KEY (orderId))
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table OrderPlacement
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS OrderPlacement (
  userName VARCHAR(30) NOT NULL,
  orderId INT NOT NULL)
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table ProductOrder
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ProductOrder (
  orderId INT NOT NULL,
  productId INT NOT NULL,
  unitPrice FLOAT NULL,
  count INT NULL)
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table AddressTypes
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS AddressTypes (
  typeName VARCHAR(10) NOT NULL,
  displayName VARCHAR(45) NULL,
  PRIMARY KEY (typeName))
  ENGINE = InnoDB;


