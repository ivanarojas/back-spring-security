package com.irojascorsico.websecurity.Users;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

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
