package br.com.marcosceola.loginservice.service;

import br.com.marcosceola.loginservice.model.User;
import br.com.marcosceola.loginservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listar() {
        var users = userRepository.findAll();

        if (users.isEmpty()) {
            throw new NoSuchElementException("Nenhum usuario foi encontrado.");
        }

        return users;
    }
}
