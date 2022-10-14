package com.javamentor.qa.platform.webapp.converters;
import com.javamentor.qa.platform.models.dto.UserRegistrationDto;
import com.javamentor.qa.platform.models.entity.user.User;
import org.mapstruct.*;



@Mapper(componentModel = "spring")
public abstract class UserConverter {

    public abstract User userRegistrationDtoToUser(UserRegistrationDto userRegistrationDto);

    public abstract UserRegistrationDto userToUserRegistrationDto(User user);
}
