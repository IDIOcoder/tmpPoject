package NewProject.Diary.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary", updatable = false)
    private long writeNum;
    @Column(name = "write_date", nullable = false)
    private LocalDateTime writeDate;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "text")
    private String text;

    @Builder
    public Diary(long writeNum, LocalDateTime writeDate, String title, String text){
        this.writeNum = writeNum;
        this.writeDate = writeDate;
        this.title = title;
        this.text = text;
    }

    public void update(String title, String text){
        this.title = title;
        this.text = text;
    }

}