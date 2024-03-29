package NewProject.Diary.dto;

import NewProject.Diary.domain.Diary;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DiaryViewResponse {
    private Long writeNum;
    private String title;
    private String text;

    public DiaryViewResponse(Diary diary) {
        this.writeNum = diary.getWriteNum();
        this.title = diary.getTitle();
        this.text = diary.getText();
    }
}
