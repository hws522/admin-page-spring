package com.study.test.controller.api;

import javax.annotation.PostConstruct;

import com.study.test.controller.CrudController;

import com.study.test.model.network.request.OrderGroupApiRequest;
import com.study.test.model.network.response.OrderGroupApiResponse;
import com.study.test.service.OrderGroupApiLogicService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @PostConstruct
    public void init() {
        this.baseService = orderGroupApiLogicService;
    }
}
