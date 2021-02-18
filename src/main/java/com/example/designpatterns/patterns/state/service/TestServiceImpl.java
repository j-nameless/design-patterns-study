package com.example.designpatterns.patterns.state.service;

import org.springframework.stereotype.Service;

/**
 * className TestDaoImpl
 * date 2021/1/15
 *
 * @author JC
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public void changeToSubmitted() {
        System.out.println("users change status to submitted");
    }
}
