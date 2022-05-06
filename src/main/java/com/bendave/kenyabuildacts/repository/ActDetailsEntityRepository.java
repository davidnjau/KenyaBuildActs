package com.bendave.kenyabuildacts.repository;

import com.bendave.kenyabuildacts.entity.ActDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActDetailsEntityRepository extends JpaRepository<ActDetailsEntity, String> {

    List<ActDetailsEntity> findByActId(String id);

}
