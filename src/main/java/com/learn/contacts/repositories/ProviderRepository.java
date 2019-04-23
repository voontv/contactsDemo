package com.learn.contacts.repositories;

import com.learn.contacts.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {

    Iterable<Provider> findAllBy();

    Provider findById(int id);

    Iterable<Provider> findAllByNameProviderContains(String nameProvider);

    @Query("select u from Provider u where u.nameProvider not like :nameProvider")
    Iterable<Provider> findAllByNameProviderNotContaining(String nameProvider);

    @Override
    @Transactional
    @Modifying
    void deleteById(Integer integer);

    @Transactional
    @Modifying
    void deleteAllByNameProviderContains(String nameProvider);

    @Transactional
    @Modifying
    void deleteAllByNumber(String number);

    @Transactional
    @Modifying
    @Query("update Provider set nameProvider = :newNameProvider where id = :id")
    void updateNameProviderWithId(String newNameProvider, int id);
}
