-- -----------------------------------------------------
-- Indexes and Unique keys
-- -----------------------------------------------------
CREATE UNIQUE INDEX idx_alo_zc_unique ON Address (addressLineOne, zipCode ASC);

CREATE INDEX fk_placed_order_user_idx ON OrderPlacement (userName ASC);
CREATE INDEX fk_placed_order_order_idx ON OrderPlacement (orderNumber ASC);

CREATE UNIQUE INDEX idx_un_on_unique ON OrderPlacement (userName, orderNumber ASC);

CREATE UNIQUE INDEX idx_on_pn_unique ON ProductOrder (productId, orderNumber  ASC);

CREATE UNIQUE INDEX idx_un_ai_unique ON UserAddress (userName, addressId, typeName ASC);

CREATE UNIQUE INDEX idx_oi_ai_unique ON OrderAddress (orderNumber, addressId, typeName ASC);


-- -----------------------------------------------------
-- Constraints
-- -----------------------------------------------------
ALTER TABLE UserRoles
  ADD CONSTRAINT fk_user_role_user
    FOREIGN KEY (userName)
    REFERENCES User (userName)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
ALTER TABLE UserRoles
  ADD CONSTRAINT fk_user_role_role
    FOREIGN KEY (roleId)
    REFERENCES Roles (roleId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE OrderPlacement
  ADD CONSTRAINT fk_user_placed_order
    FOREIGN KEY (userName)
    REFERENCES User (userName)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE OrderPlacement
  ADD CONSTRAINT fk_placed_order
    FOREIGN KEY (orderNumber)
    REFERENCES Orders (orderNumber)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE ProductOrder
  ADD CONSTRAINT fk_product_order_order
    FOREIGN KEY (orderNumber)
    REFERENCES Orders (orderNumber)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE ProductOrder
  ADD CONSTRAINT fk_product_order_product
    FOREIGN KEY (productId)
    REFERENCES Product (productId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE UserAddress
  ADD CONSTRAINT fk_user_address_user
    FOREIGN KEY (userName)
    REFERENCES User (userName)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE UserAddress
  ADD CONSTRAINT fk_user_address_address
    FOREIGN KEY (addressId)
    REFERENCES Address (addressId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE UserAddress
  ADD CONSTRAINT fk_user_address_type
    FOREIGN KEY (typeName)
    REFERENCES AddressTypes (typeName)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE OrderAddress
  ADD CONSTRAINT fk_order_address_order
    FOREIGN KEY (orderNumber)
    REFERENCES Orders (orderNumber)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE OrderAddress
  ADD CONSTRAINT fk_order_address_address
    FOREIGN KEY (addressId)
    REFERENCES Address (addressId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE OrderAddress
  ADD CONSTRAINT fk_order_address_type
    FOREIGN KEY (typeName)
    REFERENCES AddressTypes (typeName)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

