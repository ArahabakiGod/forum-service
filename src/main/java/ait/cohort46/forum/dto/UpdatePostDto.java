package ait.cohort46.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePostDto {
    private String title;
    private List<String> tags;
    private String content;
}
