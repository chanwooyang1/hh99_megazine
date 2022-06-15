package com.sparta.megazine.service;

import com.sparta.megazine.dto.UserRequestDto;
import com.sparta.megazine.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;



}
