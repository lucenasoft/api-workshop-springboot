package com.lucenasoft.workshopmongo.services;

import com.lucenasoft.workshopmongo.dto.UserDTO;
import com.lucenasoft.workshopmongo.models.UserModel;
import com.lucenasoft.workshopmongo.repositories.UserRepository;
import com.lucenasoft.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public UserModel findById(String id) {
        Optional<UserModel> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("User not found: " + id));
    }

    public UserModel insert(UserModel obj) {
        return userRepository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public UserModel update(UserModel obj) {
        UserModel newObj = findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }

    private void updateData(UserModel newObj, UserModel obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public UserModel fromDTO(UserDTO dto) {
        return new UserModel(dto.getId(), dto.getName(), dto.getEmail());
    }

}
