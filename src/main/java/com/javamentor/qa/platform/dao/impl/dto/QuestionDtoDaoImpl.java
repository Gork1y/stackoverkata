package com.javamentor.qa.platform.dao.impl.dto;

import com.javamentor.qa.platform.dao.abstracts.dto.QuestionDtoDao;
import com.javamentor.qa.platform.dao.impl.repository.ReadWriteDaoImpl;
import com.javamentor.qa.platform.dao.util.SingleResultUtil;
import com.javamentor.qa.platform.models.dto.QuestionDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class QuestionDtoDaoImpl extends ReadWriteDaoImpl<QuestionDto, Long> implements QuestionDtoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<QuestionDto> getById(Long questionId, Long authorizedUserId) {
        TypedQuery<QuestionDto> typedQuery = entityManager
            .createQuery("""
                    select new com.javamentor.qa.platform.models.dto.QuestionDto(q.id, q.title, u.id, u.fullName, u.imageLink, q.description,
                    (select count(qv) from QuestionViewed qv where qv.question.id = :questionId),
                    (select sum(ar.count) from Reputation ar where ar.author.id = q.user.id),
                    (select count(ac) from Answer ac where ac.question.id = :questionId),
                    (select sum(qr.count) from Reputation qr where qr.question.id = :questionId),
                    q.persistDateTime, q.lastUpdateDateTime,
                    (select count(vq) from VoteQuestion vq where vq.question.id = :questionId),
                    va.vote)
                    from Question q
                    inner join q.user u
                    left join VoteQuestion va on va.question.id = :questionId and u.id = :authorizedUserId
                    where q.id = :questionId
                    group by q.id, u.id, va
                    """,
                QuestionDto.class);
        typedQuery.setParameter("questionId", questionId);
        typedQuery.setParameter("authorizedUserId", authorizedUserId);

        return SingleResultUtil.getSingleResultOrNull(typedQuery);
    }
}
