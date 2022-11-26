package com.domingueti.tradebot.modules.User.controllers;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.domingueti.tradebot.modules.User.controllers.openapi.UserControllerOpenApi;
import com.domingueti.tradebot.modules.User.dtos.UserDTO;
import com.domingueti.tradebot.modules.User.dtos.UserInsertDTO;
import com.domingueti.tradebot.modules.User.dtos.UserPatchDTO;
import com.domingueti.tradebot.modules.User.services.DeleteUserByIdService;
import com.domingueti.tradebot.modules.User.services.GetUserByIdService;
import com.domingueti.tradebot.modules.User.services.GetUsersService;
import com.domingueti.tradebot.modules.User.services.InsertUserService;
import com.domingueti.tradebot.modules.User.services.PatchUserByIdService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController implements UserControllerOpenApi {
	
	private GetUsersService getUsersService;

	private GetUserByIdService getUserByIdService;

	private InsertUserService insertUserService;

	private DeleteUserByIdService deleteUserByIdService;

	private PatchUserByIdService patchUserByIdService;

	@Override
	@GetMapping("/admin/all")
	public ResponseEntity<List<UserDTO>> getUsers() {
		List<UserDTO> users = getUsersService.execute();
		return ResponseEntity.ok().body(users);
	}
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
		UserDTO userDTO = getUserByIdService.execute(id);
		return ResponseEntity.ok().body(userDTO);
	}

	@Override
	@PostMapping("/admin/insert")
	public ResponseEntity<UserDTO> insertUser(@RequestBody UserInsertDTO dto) {
		UserDTO userDTO = insertUserService.execute(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(userDTO);
	}

	@Override
	@DeleteMapping("/admin/delete/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
		deleteUserByIdService.execute(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	@PatchMapping("/admin/patch/{id}")
	public ResponseEntity<UserDTO> patchUserById(@PathVariable Long id, @RequestBody UserPatchDTO dto) {
		UserDTO userDTO = patchUserByIdService.execute(id, dto);
		return ResponseEntity.ok().body(userDTO);
	} 

}