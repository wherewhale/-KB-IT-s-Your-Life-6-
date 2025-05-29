package org.scoula.jdbc_ex.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SushiLogStat {
    private String plateColor;
    private int count;

    @Override
    public String toString() {

        return "최애 접시는 " + plateColor + " ("+ count + "회)";
    }


}
