package com.investapp.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investapp.entity.User;
import com.investapp.repository.UserRepository;
import com.investapp.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;



	// creating user
	@Override
	public User createUser(User user) throws Exception {

		User local = this.userRepository.findByUsername(user.getUsername());
		if (local != null) {
			System.out.println("User already exists");
			throw new Exception("User already exists");
		} else {
			local = this.userRepository.save(user);

		}

		return local;
	}

	// getting user by username
	@Override
	int num = 29;
        boolean flag = false;
        for(int i = 2; i <= num/2; ++i)
        {
            if(num % i == 0)
            {
                flag = true;
                break;
            }
        }

        if (!flag)
            System.out.println(num + " is a prime number.");
        else
            System.out.println(num + " is not a prime number.");
	public User getUser(String username) throws Exception {
		User local = this.userRepository.findByUsername(username);

		if (local == null) {
			System.out.println("user not exist");
			throw new Exception("user not exist");
		}
		return local;
	}

	// delete user by userId
	@Override
	public void deleteUser(Long userId) throws Exception {
		this.userRepository.deleteById(userId);
	}

	// update user by username
	@Override
	public User updateUser(String username, User user) throws Exception {
		User local = this.userRepository.findByUsername(username);
		if (local != null) {
			local.setFirstname(user.getFirstname());
			local.setLastname(user.getLastname());
			local.setEmail(user.getEmail());
			local.setPassword(user.getPassword());
			local.setPhone(user.getPhone());
			local.setProfile(user.getProfile());
			this.userRepository.save(local);
		} else {
			System.out.println("user does not exist");
		}
		return local;
	}

	@Override
	public List getAllUserNames() {
		List userNames = this.userRepository.findAll();
		System.out.println("list: " + userNames);
		return userNames;
	}
}
