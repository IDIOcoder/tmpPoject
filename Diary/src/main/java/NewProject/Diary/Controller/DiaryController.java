package NewProject.Diary.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class DiaryController {

    @GetMapping("/Diary")
    public String getDiary(){

        return "main";
    }
    @GetMapping("/newDiary")
    public String newDiary(){
        return "newDiary";
    }
}
