package com.javamentor.qa.platform.dao.impl.dto;

import com.javamentor.qa.platform.dao.abstracts.dto.TagDtoDao;
import com.javamentor.qa.platform.dao.impl.repository.ReadWriteDaoImpl;
import com.javamentor.qa.platform.models.dto.RelatedTagDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TagDtoDaoImpl extends ReadWriteDaoImpl<RelatedTagDto, Long> implements TagDtoDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<RelatedTagDto> getTopTags() {
        return entityManager.createQuery("""
                        SELECT new com.javamentor.qa.platform.models.dto.RelatedTagDto(t.id, t.description, t.questions.size)
                        FROM Tag t
                        group by t.id, t.description, t.questions.size
                        order by t.questions.size desc"""
                , RelatedTagDto.class).setMaxResults(10).getResultList();
    }
}
