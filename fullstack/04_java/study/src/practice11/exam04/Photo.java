package practice11.exam04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Photo {
    private String name; // 촬영자 이름
    private String pose; // 포즈

    @Override
    public String toString() {
        return name + "님이 " + "'" + pose + "' 포즈로 사진을 찍었습니다.";
    }
}
