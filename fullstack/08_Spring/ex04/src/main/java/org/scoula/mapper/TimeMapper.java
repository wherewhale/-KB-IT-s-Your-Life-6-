package org.scoula.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    @Select("SELECT sysdate()") //arg1
    public String getTime();

    public String getTime2();
}
