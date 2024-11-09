package com.gooodstudy.goodstudyspring.security.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class JwtRequest implements Serializable {

    private String email;
    private String password;

}