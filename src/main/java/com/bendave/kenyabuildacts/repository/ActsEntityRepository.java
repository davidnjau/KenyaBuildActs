package com.bendave.kenyabuildacts.repository;

import com.bendave.kenyabuildacts.entity.ActsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActsEntityRepository extends JpaRepository<ActsEntity, String> {
}
