package com.domingueti.tradebot.modules.User.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domingueti.tradebot.modules.User.dtos.UserDTO;
import com.domingueti.tradebot.modules.User.dtos.UserInsertDTO;
import com.domingueti.tradebot.modules.User.dtos.UserPatchDTO;
import com.domingueti.tradebot.modules.User.services.DeleteUserByIdService;
import com.domingueti.tradebot.modules.User.services.GetUserByIdService;
import com.domingueti.tradebot.modules.User.services.GetUsersByUserIdService;
import com.domingueti.tradebot.modules.User.services.InsertUserService;
import com.domingueti.tradebot.modules.User.services.PatchUserByIdService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

	private GetUsersByUserIdService getUsersByUserIdService;

	private GetUserByIdService getUserByIdService;
	
	private InsertUserService insertUserService;
	
	private DeleteUserByIdService deleteUserByIdService;
	
	private PatchUserByIdService patchUserByIdService;
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<UserDTO>> getUsersByUserId(@PathVariable Long userId) {
		List<UserDTO> users = getUsersByUserIdService.execute(userId);
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
		UserDTO userDTO = getUserByIdService.execute(id);
		return ResponseEntity.ok().body(userDTO);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> insertUser(@RequestBody UserInsertDTO dto) {
		UserDTO userDTO = insertUserService.execute(dto);
		return ResponseEntity.ok().body(userDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
		deleteUserByIdService.execute(id);
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<UserDTO> patchUserById(@PathVariable Long id, @RequestBody UserPatchDTO dto) {
		UserDTO userDTO = patchUserByIdService.execute(id, dto);
		return ResponseEntity.ok().body(userDTO);
	} 
	
}
