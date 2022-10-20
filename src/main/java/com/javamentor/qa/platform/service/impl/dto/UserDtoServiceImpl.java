package com.javamentor.qa.platform.service.impl.dto;

import com.javamentor.qa.platform.dao.abstracts.dto.PaginationDto;
import com.javamentor.qa.platform.dao.abstracts.dto.TagDtoDao;
import com.javamentor.qa.platform.dao.abstracts.dto.UserDtoDao;
import com.javamentor.qa.platform.models.dto.UserDto;
import com.javamentor.qa.platform.service.abstracts.dto.UserDtoService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserDtoServiceImpl extends PaginationDtoServiceAbstract<UserDto> implements UserDtoService {
    private final UserDtoDao userDtoDao;
    private final TagDtoDao tagDtoDao;

    public UserDtoServiceImpl(UserDtoDao userDtoDao, TagDtoDao tagDtoDao, Map<String, PaginationDto<UserDto>> paginationDaoMap) {
        super(paginationDaoMap);
        this.userDtoDao = userDtoDao;
        this.tagDtoDao = tagDtoDao;
    }

    @Override
    public Optional<UserDto> getById(UUID id) {
        Optional<UserDto> optionalUserDto = userDtoDao.getById(id);
        if (optionalUserDto.isEmpty()) {
            return optionalUserDto;
        }
        UserDto userDto = optionalUserDto.get();
        userDto.setListTop3TagDto(tagDtoDao.getTop3TagsByUser(id));
        return Optional.of(userDto);
    }
}