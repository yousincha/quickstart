// QuickMapper 인터페이스:  인터페이스는 SQL 쿼리를 자바 메서드에 매핑하는 역할을 합니다.

package com.helloworld.quickstart.mapper;

// MyBatis Mapper를 정의하는 인터페이스입니다.
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

// QuickMapper 인터페이스
@Mapper
public interface QuickMapper {

    // 주어진 paramMap에서 id에 해당하는 항목을 찾아 반환합니다.
    HashMap<String, Object> findById(HashMap<String, Object> paramMap);

    // paramMap에 항목을 등록합니다.
    void registerItem(HashMap<String, Object> paramMap);
}