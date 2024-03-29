package NewProject.Diary.dto;

import NewProject.Diary.domain.Diary;
import lombok.Getter;

@Getter
public class DiaryResponse {
    private final String title;
    private final String text;

    public DiaryResponse(Diary diary){
        this.title = diary.getTitle();
        this.text = diary.getText();
    }
}
