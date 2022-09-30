package com.domingueti.tradebot.security.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class AdminPrincipalDTO {

    private @Getter Long id;

    private @Getter String name;

    private @Getter String email;

}