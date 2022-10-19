package com.javamentor.qa.platform.dao.impl.model;

import com.javamentor.qa.platform.dao.abstracts.model.IgnoredTagDao;
import com.javamentor.qa.platform.dao.impl.repository.ReadWriteDaoImpl;
import com.javamentor.qa.platform.models.entity.question.IgnoredTag;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Repository
public class IgnoredTagDaoImpl extends ReadWriteDaoImpl<IgnoredTag, UUID> implements IgnoredTagDao {

    @PersistenceContext
    private EntityManager entityManager;
}
