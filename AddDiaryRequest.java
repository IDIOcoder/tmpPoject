package NewProject.Diary.dto;

import NewProject.Diary.domain.Diary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddDiaryRequest {
    private String writeDate;   // 작성일
    private int writeNum;       // 작성순서
    private String title;       // 기록 이름
    private String text;        // 기록 내용

    public Diary toEntity(){
        return Diary.builder()
                .writeDate
                .writeNum
                .title
                .text
                .build();
    }
}
