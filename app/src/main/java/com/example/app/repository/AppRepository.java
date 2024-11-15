package com.example.app.repository;

import com.example.app.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface AppRepository extends JpaRepository<App, Long>{

    default App findByIdOrElseThrow(Long id) {// 바로 Board Entity를 반환받을 수 있게끔
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }


}
