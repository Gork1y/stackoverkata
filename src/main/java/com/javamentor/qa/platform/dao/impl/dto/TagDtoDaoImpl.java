package com.javamentor.qa.platform.dao.impl.dto;

import com.javamentor.qa.platform.dao.abstracts.dto.TagDtoDao;
import com.javamentor.qa.platform.dao.impl.repository.ReadWriteDaoImpl;
import com.javamentor.qa.platform.dao.util.SingleResultUtil;
import com.javamentor.qa.platform.models.dto.RelatedTagDto;
import com.javamentor.qa.platform.models.dto.TagDto;
import com.javamentor.qa.platform.models.dto.UserDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

@Repository
public class TagDtoDaoImpl extends ReadWriteDaoImpl<RelatedTagDto, UUID> implements TagDtoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RelatedTagDto> getTop10Tags() {
        return entityManager.createQuery("""
                SELECT new com.javamentor.qa.platform.models.dto.RelatedTagDto(t.id, t.description, t.questions.size)
                FROM Tag t
                GROUP BY t.id, t.description, t.questions.size
                ORDER BY t.questions.size DESC
                """,
                        RelatedTagDto.class)
                .setMaxResults(10)
                .getResultList();
    }

    @Override
    public List<TagDto> getTop3TagsByUser(UUID userId) {
        TypedQuery<TagDto> typedQuery = entityManager
                       .createQuery("""
                select new  com.javamentor.qa.platform.models.dto.TagDto(t.id, t.name, t.description) 
                from Reputation r
                join r.question q 
                join q.tags t
                where r.author.id = :userId
                group by t.id
                order by sum(r.count) desc 
                """,
                        TagDto.class);
        typedQuery.setParameter("userId", userId);
        return typedQuery.setMaxResults(3).getResultList();
    }
}
