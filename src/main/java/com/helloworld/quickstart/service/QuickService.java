// 서비스 레이어에서 사용되는 클래스: QuickMapper를 의존성 주입(Dependency Injection)으로 주입받아서 사용
package com.helloworld.quickstart.service;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.entity.ItemEntity;
import com.helloworld.quickstart.mapper.QuickMapper;
import com.helloworld.quickstart.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
@Slf4j
public class QuickService {
    @Autowired
    private QuickMapper quickMapper;

    @Autowired
    private ItemRepository itemRepository;
    // 아이템 등록 메서드
    public boolean registerItem(ItemDto itemDto){
        // TODO: DB insert
////        Maybatis
//        // 아이템 정보를 해시맵에 담습니다.
//        HashMap<String, Object> paramMap = new HashMap<>();
//
//        paramMap.put("id", itemDto.getId());
//        paramMap.put("name", itemDto.getName());
//
//        // QuickMapper를 사용하여 아이템을 등록합니다.
//        quickMapper.registerItem(paramMap);
//
//        log.info("service ...");

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());

        itemRepository.save(itemEntity);

        return true;
    }
    // 아이템 조회 메서드
    public ItemDto getItemById(String id){
//        Maybatis
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id",id);
//
//        // QuickMapper를 사용하여 아이템을 조회합니다.
//        HashMap<String, Object> res = quickMapper.findById(paramMap);
//
//        // 조회 결과를 ItemDto 객체로 매핑합니다.
//        ItemDto itemDto = new ItemDto();
//        itemDto.setId((String)res.get("ID"));
//        itemDto.setName((String)res.get("NAME"));
//
//        return  itemDto;

//      JPA
        ItemEntity itemEntity = itemRepository.findById(id).get();

        ItemDto itemDto = new ItemDto();

        itemDto.setId(itemEntity.getId());
        itemDto.setName(itemEntity.getName());


        return itemDto;
    }
}
