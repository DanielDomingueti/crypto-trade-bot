package com.domingueti.tradebot.modules.User.controllers;

import com.domingueti.tradebot.modules.User.controllers.openapi.UserControllerOpenApi;
import com.domingueti.tradebot.modules.User.dtos.UserDTO;
import com.domingueti.tradebot.modules.User.dtos.UserInsertDTO;
import com.domingueti.tradebot.modules.User.dtos.UserPatchDTO;
import com.domingueti.tradebot.modules.User.dtos.UserWalletDTO;
import com.domingueti.tradebot.modules.User.services.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping
public class UserController implements UserControllerOpenApi {
	
	private GetUsersService getUsersService;

	private GetUserByIdService getUserByIdService;

	private GetUserWalletsService getUserWalletsService;

	private GetUserWalletByUserIdService getUserWalletByUserIdService;

	private InsertUserService insertUserService;

	private DeleteUserByIdService deleteUserByIdService;

	private PatchUserByIdService patchUserByIdService;

	@Override
	@GetMapping("/admin/users/all")
	public ResponseEntity<List<UserDTO>> getUsers() {
		List<UserDTO> users = getUsersService.execute();
		return ResponseEntity.ok().body(users);
	}
	
	@Override
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
		UserDTO userDTO = getUserByIdService.execute(id);
		return ResponseEntity.ok().body(userDTO);
	}

	@GetMapping("/admin/user/wallets")
	public ResponseEntity<List<UserWalletDTO>> getWallets() {

		return null;
	}

	@GetMapping("/admin/user/wallet/{userId}")
	public ResponseEntity<List<UserWalletDTO>> getWalletByUserId(@PathVariable Long userId) {

		return null;
	}

	@Override
	@PostMapping("/admin/user/insert")
	public ResponseEntity<UserDTO> insertUser(@RequestBody UserInsertDTO dto) {
		UserDTO userDTO = insertUserService.execute(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(userDTO);
	}

	@Override
	@DeleteMapping("/admin/user/delete/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
		deleteUserByIdService.execute(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	@PatchMapping("/admin/user/patch/{id}")
	public ResponseEntity<UserDTO> patchUserById(@PathVariable Long id, @RequestBody UserPatchDTO dto) {
		UserDTO userDTO = patchUserByIdService.execute(id, dto);
		return ResponseEntity.ok().body(userDTO);
	} 


}