package com.study.test.ifs;

import com.study.test.model.network.Header;

public interface CrudInterface<Req, Res> {

    Header<Res> create(Req request); // todo request object 추가

    Header<Res> read(Long id);

    Header<Res> update(Req request);

    Header delete(Long id);
}
