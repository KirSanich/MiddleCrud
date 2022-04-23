package com.example.middlecrud.service;

import com.example.middlecrud.entity.Passport;

public interface PassportService {

    void savePassport(Passport passport);
    void deletePassport(Long id);
    Passport getPassport(Long id);
    Passport updatePassport(Passport passport);
}
