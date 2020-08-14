package com.thoughtworks.bussiness.repository;

import com.thoughtworks.bussiness.dto.BsInfoDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BsInfoRepository extends CrudRepository<BsInfoDto, Integer> {
    List<BsInfoDto> findAll();
}
