package com.helloworld.quickstart.controller;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.dto.ResponseDto;
import com.helloworld.quickstart.service.QuickService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class QuickController {

    @Autowired
    private QuickService quickService; // QuickService 인스턴스를 주입받음

    // 간단한 로그와 JSON 응답을 반환하는 엔드포인트
    @GetMapping("/dummy")
    public String dummy(){
        log.info("dummy");
        return "{}";
    }
    @GetMapping("/dummy2")
    public String dummy2(){
        log.info("dummy2");
        return "dummy2";
    }

    // 쿼리 매개변수로 전달된 직원 번호와 연도를 로깅하고 "ok" 응답 반환
    @GetMapping("/member")
    public String getMember(@RequestParam("empNo") String empNo,
                            @RequestParam("year") int year ){
        log.info("empNo: {}", empNo);
        log.info("year: {}", year);
        return "ok";
    }

    // 경로 변수로 전달된 회사 ID를 로깅하고 "ok" 응답 반환
    @GetMapping("/company/{id}")
    public String getCompany(@PathVariable("id") String id){
        log.info("id: {}", id);
        return "ok";
    }

    // 요청 본문에 포함된 ItemDto를 받아서 등록하고 그 결과를 응답으로 반환
    @PostMapping("/item")
    public ResponseDto registerItem(@RequestBody ItemDto item) {
        log.info("item: {}", item);
        // QuickService를 사용하여 아이템 등록 수행
        boolean b = quickService.registerItem(item);
        if (b) {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("ok");
            return responseDto;
        }

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("fail");
        return responseDto;
    }

    // 쿼리 매개변수로 전달된 아이템 ID를 사용하여 아이템을 가져옴
    @GetMapping("/item")
    public ItemDto getItem(@RequestParam("id") String id) {
        ItemDto res = quickService.getItemById(id);
        return res;
    }
}
