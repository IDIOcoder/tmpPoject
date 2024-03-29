package NewProject.Diary.controller;

import NewProject.Diary.domain.Diary;
import NewProject.Diary.dto.AddDiaryRequest;
import NewProject.Diary.dto.DiaryResponse;
import NewProject.Diary.dto.UpdateDiaryRequest;
import NewProject.Diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DiaryApiController {

    private final DiaryService diaryService;

    @PostMapping(value = "/api/diary")
    public ResponseEntity<Diary> addDiary(@RequestBody AddDiaryRequest request){
        Diary savedDiary = diaryService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedDiary);

    }

    @GetMapping(value = "/api/diaries")
    public ResponseEntity<List<DiaryResponse>> findAllDiaries() {
        List<DiaryResponse> diaries = diaryService.findAll()
                .stream()
                .map(DiaryResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(diaries);
    }

    @GetMapping(value = "/api/diaries/{id}")
    public ResponseEntity<DiaryResponse> findDiary(@PathVariable long id) {
        Diary diary = diaryService.findById(id);

        return ResponseEntity.ok()
                .body(new DiaryResponse(diary));
    }

    @DeleteMapping(value = "/api/diaries/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        diaryService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping(value = "/api/diaries/{id}")
    public ResponseEntity<Diary> updateDiary(@PathVariable long id,
                                               @RequestBody UpdateDiaryRequest request) {
        Diary updateDiary = diaryService.update(id, request);


        return ResponseEntity.ok()
                .body(updateDiary);
    }
}
