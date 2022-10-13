package com.javamentor.qa.platform.models.dto;

import com.javamentor.qa.platform.models.entity.question.VoteType;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "вопрос")
public class QuestionDto {
    @Parameter (description = "id вопроса")
    private Long id;
    @Schema(description = "заголовок вопроса")
    private String title;
    @Schema(description = "id автора")
    private Long authorId;
    @Schema(description = "имя автора")
    private String authorName;
    @Schema(description = "ссылка на изображение автора")
    private String authorImageLink;
    @Schema(description = "описание вопроса")
    private String description;
    @Schema(description = "количество просмотров")
    private Long viewCount;
    @Schema(description = "репутация автора")
    private Long authorReputation;
    @Schema(description = "количество ответов на вопрос")
    private Long answersCount;
    @Schema(description = "рейтинг вопроса")
    private Long questionRating;
    @Schema(description = "дата создания вопроса")
    private LocalDateTime persistDateTime;
    @Schema(description = "дата последнего обновления")
    private LocalDateTime lastUpdateDateTime;
    @Schema(description = "кол-во голосов за вопрос")
    private Long votesCount;
    @Schema(description = "голос авторизованного пользователя за вопрос")
    private VoteType voteAuthorizedUser;
//    @Schema(description = "список тэгов")
//    private List<TagDto> tagsList;

}
