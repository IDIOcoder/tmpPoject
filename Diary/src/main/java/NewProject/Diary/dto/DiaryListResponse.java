package NewProject.Diary.dto;

import NewProject.Diary.domain.Diary;
import lombok.Getter;

@Getter
public class DiaryListResponse {
    private final Long writeNum;
    private final String title;
    private final String text;

    public DiaryListResponse(Diary diary) {
        this.title = diary.getTitle();
        this.text = diary.getText();
        this.writeNum = diary.getId();
    }
}
