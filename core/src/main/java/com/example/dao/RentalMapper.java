package com.example.dao;

import com.example.domain.Rental;

import java.util.List;

public interface RentalMapper {
    /**
     * @param rentalId
     * @return
     */
    int deleteByPrimaryKey(Integer rentalId);

    /**
     * @param record
     * @return
     */
    int insert(Rental record);

    /**
     * @param rentalId
     * @return
     */
    Rental selectByPrimaryKey(Integer rentalId);

    /**
     * @return
     */
    List<Rental> selectAll();

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(Rental record);
}