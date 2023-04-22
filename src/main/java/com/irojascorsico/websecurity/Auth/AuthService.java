package com.irojascorsico.websecurity.Auth;

import java.util.List;

import org.springframework.stereotype.Service;

import com.irojascorsico.websecurity.Users.User;
import com.irojascorsico.websecurity.Users.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    public User getUserById(Integer id)
    {
        return userRepository.getReferenceById(id);
    }

    public void deleteUser(Integer id)
    {
        userRepository.deleteById(id);
    }

    public void saveUser(User user)
    {
        userRepository.save(user);
    }
}
