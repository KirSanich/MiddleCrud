package com.example.middlecrud.service.passport;

import com.example.middlecrud.entity.Passport;
import com.example.middlecrud.exceptions.PassportNotFound;
import com.example.middlecrud.repository.PassportRepository;
import com.example.middlecrud.service.PassportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;

    public static final Logger logger = LoggerFactory.getLogger(PassportServiceImpl.class);

    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }


    @Override
    public void savePassport(Passport passport) {
        logger.info("Сохранение паспорта {}", passport);
        passportRepository.save(passport);
    }

    @Override
    public void deletePassport(Long id) {
        logger.info("Удаление паспорта с id {}", id);
        passportRepository.deleteById(id);
    }

    @Override
    public Passport getPassport(Long id) {
        logger.info("Получение паспорта с id {}", id);
        return passportRepository.findById(id).orElseThrow(() -> new PassportNotFound("Паспорта с таким id нет"));
    }

    @Override
    public Passport updatePassport(Passport passport) {
        logger.info("Обновление паспорта с id {}", passport.getId());
        return passportRepository.save(passport);
    }

}
