-- -----------------------------------------------------
-- Indexes and Unique keys
-- -----------------------------------------------------
CREATE UNIQUE INDEX idx_alo_zc_unique ON Address (addressLineOne, zipCode ASC);

CREATE UNIQUE INDEX idx_order_number_unique ON Orders (orderNumber ASC);

CREATE UNIQUE INDEX idx_un_on_unique ON OrderPlacement (userName, orderId ASC);

CREATE UNIQUE INDEX idx_on_pn_unique ON ProductOrder (productId, orderId  ASC);

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
    FOREIGN KEY (orderId)
    REFERENCES Orders (orderId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE ProductOrder
  ADD CONSTRAINT fk_product_order_order
    FOREIGN KEY (orderId)
    REFERENCES Orders (orderId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE ProductOrder
  ADD CONSTRAINT fk_product_order_product
    FOREIGN KEY (productId)
    REFERENCES Product (productId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE Orders
  ADD CONSTRAINT fk_order_address_billing
    FOREIGN KEY (billingAddress)
    REFERENCES Address (addressId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE Orders
  ADD CONSTRAINT fk_order_address_shipping
    FOREIGN KEY (shippingAddress)
    REFERENCES Address (addressId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
