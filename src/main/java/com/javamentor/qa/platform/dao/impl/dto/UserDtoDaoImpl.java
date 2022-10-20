package com.javamentor.qa.platform.dao.impl.dto;

import com.javamentor.qa.platform.dao.abstracts.dto.UserDtoDao;
import com.javamentor.qa.platform.dao.impl.repository.ReadWriteDaoImpl;
import com.javamentor.qa.platform.dao.util.SingleResultUtil;
import com.javamentor.qa.platform.models.dto.UserDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;
import java.util.UUID;


@Repository
public class UserDtoDaoImpl extends ReadWriteDaoImpl<UserDto, UUID> implements UserDtoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<UserDto> getById(UUID id) {
        TypedQuery<UserDto> typedQuery = entityManager
                .createQuery("""
                                select new com.javamentor.qa.platform.models.dto.UserDto(
                                u.id,
                                u.email,
                                u.fullName,
                                u.imageLink,
                                u.city,
                                sum (r.count),
                                u.persistDateTime,
                                (select cast (count (vq.vote) as long) from VoteQuestion vq where vq.user = u.id) + (select cast (count (va.voteType) as long) from VoteAnswer va where va.user = u.id))
                                from User u
                                join Reputation r on r.author = u.id
                                where u.id = :userId
                                group by u.id
                                """,
                        UserDto.class);
        typedQuery.setParameter("userId", id);

        return SingleResultUtil.getSingleResultOrNull(typedQuery);
    }
}
