package com.socialmobile.phoneshopping.service.domain.converter.json;

import com.socialmobile.common.model.Address;
import com.socialmobile.phoneshopping.service.domain.AddressEntity;
import com.socialmobile.phoneshopping.service.domain.converter.Converter;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class AddressConverter implements Converter<Address, AddressEntity> {
    @Override
    public Address fromEntity(final AddressEntity pEntity) {
        Address address = new Address();
        address.setAddressId(pEntity.getAddressId());
        address.setAddressLineOne(pEntity.getAddressLineOne());
        address.setAddressLineTwo(pEntity.getAddressLineTwo());
        address.setCity(pEntity.getCity());
        address.setState(pEntity.getState());
        address.setZipCode(pEntity.getZipCode());

        return address;
    }

    @Override
    public AddressEntity toEntity(final Address pModel) {
        AddressEntity entity = new AddressEntity();
        entity.setAddressId(pModel.getAddressId());
        entity.setAddressLineOne(pModel.getAddressLineOne());
        entity.setAddressLineTwo(pModel.getAddressLineTwo());
        entity.setCity(pModel.getCity());
        entity.setState(pModel.getState());
        entity.setZipCode(pModel.getZipCode());

        return entity;
    }
}
