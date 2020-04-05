package com.machun.springbootjackson.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @BeforeEach
    void setUp() {
        System.out.println("UserController Test Begin");
    }

    @AfterEach
    void tearDown() {
        System.out.println("UserController Test End");
    }

    @Test
    void getUserInfo() {
        System.out.println("get one test");
        assertEquals(12,4);
    }


    @Test
    void getAllUserInfo() {
        System.out.println("get all test");
        assertEquals(12,12);
    }
}