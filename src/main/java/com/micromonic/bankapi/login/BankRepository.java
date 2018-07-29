package com.micromonic.bankapi.login;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<Customer, Integer> {

	Optional<Customer> findById(Long id);



}
