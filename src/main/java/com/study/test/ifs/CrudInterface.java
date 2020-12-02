package com.study.test.ifs;

import com.study.test.model.network.Header;

public interface CrudInterface {

    Header create(); // todo request object 추가

    Header read(Long id);

    Header update();

    Header delete(Long id);
}
