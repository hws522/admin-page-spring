package com.study.test.controller.api;

import com.study.test.controller.CrudController;
import com.study.test.model.entity.Partner;
import com.study.test.model.network.request.PartnerApiRequest;
import com.study.test.model.network.response.PartnerApiResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {
}
