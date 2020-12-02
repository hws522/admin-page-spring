package com.study.test.controller.api;

import com.study.test.ifs.CrudInterface;
import com.study.test.model.network.Header;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface {

    @Override
    @PostMapping("") // /api/user
    public Header create() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @GetMapping("{id}") // /api/user/{id}
    public Header read(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @PutMapping("") // /api/user
    public Header update() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @DeleteMapping("{id}") // /api/user/{id}
    public Header delete(@PathVariable(name = "id") Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
