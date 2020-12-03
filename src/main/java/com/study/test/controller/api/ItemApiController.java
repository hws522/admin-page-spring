package com.study.test.controller.api;

import javax.annotation.PostConstruct;

import com.study.test.controller.CrudController;
import com.study.test.model.entity.Item;
import com.study.test.model.network.request.ItemApiRequest;
import com.study.test.model.network.response.ItemApiResponse;
import com.study.test.service.ItemApiLogicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

}
