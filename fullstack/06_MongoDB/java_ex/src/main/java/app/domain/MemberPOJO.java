package app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberPOJO {
    private String name;
    private String mbti;
    private String position;
    private int energyLevel;
}
