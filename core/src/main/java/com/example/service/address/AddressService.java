package com.example.service.address;

import com.example.domain.address.Address;

public interface AddressService {

    /**
     * @param address
     * @return
     */
    Integer saveOne(Address address);

    /**
     * @param addressId
     * @return
     */
    Address findOneById(Short addressId);

}
