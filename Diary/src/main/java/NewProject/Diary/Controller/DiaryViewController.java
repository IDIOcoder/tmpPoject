package NewProject.Diary.Controller;

import NewProject.Diary.domain.Diary;
import NewProject.Diary.dto.DiaryListResponse;
import NewProject.Diary.dto.DiaryResponse;
import NewProject.Diary.dto.DiaryViewResponse;
import NewProject.Diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class DiaryViewController {

    private final DiaryService diaryService;

    @GetMapping("/diaries")
    public String getDiaries(Model model) {
        List<DiaryListResponse> diaries = diaryService.findAll()
                .stream()
                .map(DiaryListResponse::new)
                .toList();
        model.addAttribute("diaries", diaries);

        return "main";
    }

    @GetMapping("/diaries/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Diary diary = diaryService.findById(id);
        model.addAttribute("diary", new DiaryViewResponse(diary));

        return "diary";
    }


    @GetMapping("/new-diary")
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("diary", new DiaryViewResponse());
        } else {
            Diary diary = diaryService.findById(id);
            model.addAttribute("diary", new DiaryResponse(diary));
        }

        return "newDiary";
    }
}
