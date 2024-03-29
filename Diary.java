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
    private int WriteNum;
    @Column(name = "write_date", nullable = false)
    private String WriteDate;
    @Column(name = "title", nullable = false)
    private String title;
    private String text;

    @Builder
    public Diary(String title, String content){
        this.title = title;
        this.text = text;
    }

}
