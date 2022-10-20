package com.javamentor.qa.platform.dao.impl.dto;

import com.javamentor.qa.platform.dao.abstracts.dto.PaginationDto;
import com.javamentor.qa.platform.dao.util.SingleResultUtil;
import com.javamentor.qa.platform.models.dto.UserDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository("allUsers")
public class UserDtoPaginationDtoImpl implements PaginationDto<UserDto> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int getCountOfAllItems(Map<String, Object> parameters) {
        return Integer.parseInt(SingleResultUtil.getSingleResultOrNull(entityManager.createQuery("""
                select count(u)
                from User u
                where u.isDeleted = false
                """)).orElse(0).toString());
    }

    @Override
    public List<UserDto> getItems(Map<String, Object> parameters) {
        TypedQuery<UserDto> typedQuery = entityManager.createQuery(
                """ 
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
                        group by u.id
                        """,
                UserDto.class
        );

        int itemsOnPage = (int) parameters.get("itemsOnPage");
        int currentPage = (int) parameters.get("currentPage");

        List<UserDto> users = typedQuery.getResultList();

        if (itemsOnPage * currentPage > users.size()) {
            return users;
        } else {
            int index = (currentPage - 1) * itemsOnPage;

            return users.stream()
                    .skip(index)
                    .limit(index + itemsOnPage)
                    .collect(Collectors.toList());
        }
    }
}
