package com.study.test.controller.api;

import javax.annotation.PostConstruct;

import com.study.test.controller.CrudController;
import com.study.test.model.entity.User;
import com.study.test.model.network.request.UserApiRequest;
import com.study.test.model.network.response.UserApiResponse;
import com.study.test.service.UserApiLogicService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, User> {

}
