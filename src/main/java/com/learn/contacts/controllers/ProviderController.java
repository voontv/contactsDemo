package com.learn.contacts.controllers;

import com.learn.contacts.models.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.learn.contacts.repositories.ProviderRepository;


@RestController
@RequestMapping("/api/providers")
public class ProviderController {

    @Autowired
    private ProviderRepository providerRepository;

    @GetMapping
    Iterable<Provider> getAll() {
        return providerRepository.findAllBy();
    }

    @GetMapping("/{id}")
    Provider getId(@PathVariable int id) {
        return providerRepository.findById(id);
    }

    @GetMapping("/nameprovider")
    Iterable<Provider> getNameProvider(@RequestParam String nameProvider) {
        return providerRepository.findAllByNameProviderContains(nameProvider);
    }

    @GetMapping("/notnameprovider")
    Iterable<Provider> getNotNameProvider(@RequestParam String nameProvider) {
        return providerRepository.findAllByNameProviderNotContaining(nameProvider);
    }

    @DeleteMapping("/{id}")
    void deletedWithId(@PathVariable int id) {
        providerRepository.deleteById(id);
    }

    @DeleteMapping("/name/{nameProvider}")
    void deletedWithNameProvider(@PathVariable String nameProvider) {
        providerRepository.deleteAllByNameProviderContains(nameProvider);
    }

    @DeleteMapping("/number/{number}")
    void deletedWithnumber(@PathVariable String number) {
        providerRepository.deleteAllByNumber(number);
    }

    @PutMapping()
    void put(@RequestBody Provider provider){
        providerRepository.save(provider);
    }

    @PostMapping
    void post(@RequestParam String newNameProvider, @RequestParam int id) {
        providerRepository.updateNameProviderWithId(newNameProvider, id);
    }
}
