package NewProject.Diary.service;

import NewProject.Diary.domain.Diary;
import NewProject.Diary.dto.AddDiaryRequest;
import NewProject.Diary.dto.UpdateDiaryRequest;
import NewProject.Diary.repository.DiaryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DiaryService {
    private final DiaryRepository diaryRepository;

    // 기록 추가
    public Diary save(AddDiaryRequest request) {
        return diaryRepository.save(request.toEntity());
    }

    // 날짜에 대한 글들 조회 x 우선 전체조회 o
    public List<Diary> findAll() {return diaryRepository.findAll();}

    // 하나의 기록에 대한 조회
    public Diary findById(Long id) {
        return diaryRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: " + id));
    }

    // 삭제
    public void delete(Long id){
        diaryRepository.deleteById(id);
    }

    // 수정
    @Transactional
    public Diary update(Long id, UpdateDiaryRequest request){
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: " + id));

        diary.update(request.getTitle(), request.getText());

        return diary;
    }

}
