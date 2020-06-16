package com.example.service.address;

import com.example.dao.AddressMapper;
import com.example.domain.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Integer saveOne(Address address) {
        return addressMapper.insert(address);
    }

    @Override
    public Address findOneById(Short addressId) {
        return addressMapper.selectByPrimaryKey(addressId);
    }
}
