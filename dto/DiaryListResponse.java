package NewProject.Diary.dto;

import NewProject.Diary.domain.Diary;
import lombok.Getter;

@Getter
public class DiaryListResponse {
    private String title;

    public DiaryListResponse(Diary diary) {
        this.title = diary.getTitle();
    }
}
