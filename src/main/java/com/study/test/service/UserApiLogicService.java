package com.study.test.service;

import com.study.test.ifs.CrudInterface;
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
    public Header<UserApiResponse> create(UserApiRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Header<UserApiResponse> update(UserApiRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Header delete(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
