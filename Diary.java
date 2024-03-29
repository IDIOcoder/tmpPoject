package NewProject.Diary.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Diary {
    @Id @GeneratedValue
    @Column(name = "diary", updatable = false)
    private int writeNum;
    @Column(name = "write_date", nullable = false)
    private String writeDate;
    @Column(name = "title", nullable = false)
    private String title;
    private String text;

    @Builder
    public Diary(int writeNum, String writeDate, String title, String text){
        this.writeNum = writeNum;
        this.writeDate = writeDate;
        this.title = title;
        this.text = text;
    }

}
