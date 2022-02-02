package com.example.middlecrud.service.user;


import com.example.middlecrud.entity.User;
import com.example.middlecrud.exceptions.UserNotFoundException;
import com.example.middlecrud.repository.UserRepository;
import com.example.middlecrud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        logger.info("Получение списка юзеров");
        return userRepository.findAll();
    }


    @Override
    public void saveUser(User user) {
        logger.info("Попытка сохранения юзера {}", user);
        userRepository.save(user);
    }


    @Override
    public User getUser(Long id) {
        logger.info("Попытка получения данных юзера с id {}", id);
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Юзера с таким id не существует"));
    }

    @Override
    public void deleteUser(Long id) {
        logger.info("Удаление юзера с id {}", id);
        userRepository.deleteById(id);
    }


    @Override
    public User updateUser(User user) {
        logger.info("Изменения юзера с id {}", user.getId());
        return userRepository.save(user);
    }


}
