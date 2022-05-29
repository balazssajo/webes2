package com.javatpoint.repository;
import com.javatpoint.model.Address;
import org.springframework.data.repository.CrudRepository;
import com.javatpoint.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>
{
}
