package com.study.test.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.study.test.ifs.CrudInterface;
import com.study.test.model.entity.User;
import com.study.test.model.enumclass.UserStatus;
import com.study.test.model.network.Header;
import com.study.test.model.network.Pagination;
import com.study.test.model.network.request.UserApiRequest;
import com.study.test.model.network.response.UserApiResponse;
import com.study.test.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserApiLogicService extends BaseService<UserApiRequest, UserApiResponse, User> {

    // 1. request data
    // 2. user 생성
    // 3. 생성된 데이터 -> UserApiResponse return

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        // 1. request data
        UserApiRequest userApiRequest = request.getData();

        // 2. User 생성
        User user = User.builder().account(userApiRequest.getAccount()).password(userApiRequest.getPassword())
                .status(UserStatus.REGISTERED).phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail()).registeredAt(LocalDateTime.now()).build();

        User newUser = baseRepository.save(user);

        // 3. 생성된 데이터 => userApiResponse return
        return Header.OK(response(newUser));
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        // id -> repository getOne , getById
        return baseRepository.findById(id) // user -> userApiResponse return
                .map(user -> response(user)).map(userApiResponse -> Header.OK(userApiResponse))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        // data
        UserApiRequest userApiRequest = request.getData();

        // id -> user data
        Optional<User> optional = baseRepository.findById(userApiRequest.getId());

        return optional.map(user -> {
            // update
            user.setAccount(userApiRequest.getAccount()).setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus()).setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail()).setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt());

            return user;
        }).map(user -> baseRepository.save(user)).map(user -> response(user))
                .map(userApiResponse -> Header.OK(userApiResponse)).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        Optional<User> optional = baseRepository.findById(id);

        return optional.map(user -> {
            baseRepository.delete(user);

            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));

    }

    private UserApiResponse response(User user) {
        // user -> userApiResponse

        UserApiResponse userApiResponse = UserApiResponse.builder().id(user.getId()).account(user.getAccount())
                .password(user.getPassword()).email(user.getEmail()).phoneNumber(user.getPhoneNumber())
                .status(user.getStatus()).registeredAt(user.getRegisteredAt()).unregisteredAt(user.getUnregisteredAt())
                .build();

        // Header + data return

        return userApiResponse;
    }

    public Header<List<UserApiResponse>> search(Pageable pageable) {

        Page<User> users = baseRepository.findAll(pageable);

        List<UserApiResponse> userApiResponsesList = users.stream().map(user -> response(user))
                .collect(Collectors.toList());

        Pagination pagination = Pagination.builder().totalPages(users.getTotalPages())
                .totalElements(users.getTotalElements()).currentPage(users.getNumber())
                .currentElements(users.getNumberOfElements()).build();

        return Header.OK(userApiResponsesList, pagination);
    }

}
