package com.domingueti.tradebot.security.filters;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.User.dtos.UserAuthenticationDTO;
import com.domingueti.tradebot.modules.User.models.User;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;
import com.domingueti.tradebot.security.exceptions.ExpiredPasswordException;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MigratedUserFilter {

    private UserRepository repository;

    @Transactional(readOnly = true)
    public void verifyNullPassword(UserAuthenticationDTO userLogin) {

        User user = repository.findByEmailOrDocument(userLogin.getCredential());

        if (user != null && user.getPassword() == null) {
            throw new ExpiredPasswordException("Sua senha está expirada. Solicite uma nova senha na opção \"Recuperar senha\" abaixo.");
        }

    }

}
