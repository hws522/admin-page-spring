package com.study.test.service;

import java.time.LocalDateTime;

import com.study.test.ifs.CrudInterface;
import com.study.test.model.entity.User;
import com.study.test.model.network.Header;
import com.study.test.model.network.request.UserApiRequest;
import com.study.test.model.network.response.UserApiResponse;
import com.study.test.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository UserRepository;

    // 1. request data
    // 2. user 생성
    // 3. 생성된 데이터 -> UserApiResponse return

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        // 1. request data
        UserApiRequest userApiRequest = request.getData();

        // 2. User 생성
        User user = User.builder().account(userApiRequest.getAccount()).password(userApiRequest.getPassword())
                .status("REGISTERED").phoneNumber(userApiRequest.getPhoneNumber()).email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now()).build();

        User newUser = UserRepository.save(user);

        // 3. 생성된 데이터 => userApiResponse return
        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Header delete(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    private Header<UserApiResponse> response(User user) {
        // user -> userApiResponse

        UserApiResponse userApiResponse = UserApiResponse.builder().id(user.getId()).account(user.getAccount())
                .password(user.getPassword()).email(user.getEmail()).phoneNumber(user.getPhoneNumber())
                .registeredAt(user.getRegisteredAt()).unregisteredAt(user.getUnregisteredAt()).build();

        // Header + data return

        return Header.OK(userApiResponse);
    }

}
