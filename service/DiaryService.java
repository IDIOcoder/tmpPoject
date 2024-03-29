package NewProject.Diary.service;

import NewProject.Diary.domain.Diary;
import NewProject.Diary.dto.AddDiaryRequest;
import NewProject.Diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DiaryService {
    private DiaryRepository diaryRepository;

    // 기록 추가
    public Diary save(AddDiaryRequest request) {
        return diaryRepository.save(request.toEntity());
    }

    // 날짜에 대한 글들 조회
    public List<Diary> findAll() {return diaryRepository.findAll();}

}
