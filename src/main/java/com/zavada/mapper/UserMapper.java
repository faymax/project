package com.zavada.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.zavada.domain.EditUserRequest;
import com.zavada.domain.RegisterRequest;
import com.zavada.domain.UserProfileRequest;
import com.zavada.entity.UserEntity;
import com.zavada.entity.enumeration.Role;

public interface UserMapper {

	public static User toSecurityUser(UserEntity entity) {
		return new User(entity.getEmail(), entity.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(entity.getRole())));
	}
	
	public static UserEntity registerToUser(RegisterRequest request) {
		UserEntity entity = new UserEntity();
		entity.setEmail(request.getEmail());
		entity.setPassword(request.getPassword());
		entity.setFirstName(request.getFirstName());
		entity.setLastName(request.getLastName());
		entity.setRole(Role.ROLE_USER);
		return entity;
	}
	
	public static UserProfileRequest entityToUserProfile(UserEntity entity) {
		UserProfileRequest request = new UserProfileRequest();
		request.setId(entity.getId());
		request.setEmail(entity.getEmail());
		request.setFirstName(entity.getFirstName());
		request.setLastName(entity.getLastName());
		request.setAge(entity.getAge());
		request.setPhoneNumber(entity.getPhoneNumber());
		
		return request;
	}
	
	// Edit user
	public static EditUserRequest entityToEditUser(UserEntity entity) {
		EditUserRequest request = new EditUserRequest();
		request.setId(entity.getId());
		request.setEmail(entity.getEmail());
		request.setFirstName(entity.getFirstName());
		request.setLastName(entity.getLastName());
		request.setAge(entity.getAge());
		request.setPhoneNumber(entity.getPhoneNumber());
		request.setPassword(entity.getPassword()); // <----
		return request;
	}
	
	public static UserEntity editRequestToEntity(EditUserRequest request) {
		UserEntity entity = new UserEntity();
		entity.setId(request.getId());
		entity.setEmail(request.getEmail());
		entity.setAge(request.getAge());
		entity.setFirstName(request.getFirstName());
		entity.setLastName(request.getLastName());
		entity.setImagePath(request.getFile().getOriginalFilename());
		entity.setPassword(request.getPassword()); // <----
		entity.setRole(Role.ROLE_USER);
		return entity;
	}
	
}
