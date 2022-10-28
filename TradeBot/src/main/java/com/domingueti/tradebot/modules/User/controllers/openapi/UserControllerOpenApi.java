package com.domingueti.tradebot.modules.User.controllers.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.domingueti.tradebot.modules.User.dtos.UserDTO;
import com.domingueti.tradebot.modules.User.dtos.UserInsertDTO;
import com.domingueti.tradebot.modules.User.dtos.UserPatchDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Users")
public interface UserControllerOpenApi {

	@ApiOperation("Fetch all users")
	ResponseEntity<List<UserDTO>> getUsers();

	@ApiOperation("Fetch user by ID")
	ResponseEntity<UserDTO> getUserById(@ApiParam(value = "User ID", example = "1") Long id);

	@ApiOperation("Insert a new user")
	ResponseEntity<UserDTO> insertUser(@ApiParam(value = "JSON body for UserInsertDTO") UserInsertDTO dto);

	@ApiOperation("Delete an user by ID")
	ResponseEntity<Void> deleteUserById(@ApiParam(value = "User ID", example = "1") Long id);

	@ApiOperation("Update an user by ID")
	ResponseEntity<UserDTO> patchUserById(@ApiParam(value = "User ID", example = "1") 
		Long id, UserPatchDTO dto);

}