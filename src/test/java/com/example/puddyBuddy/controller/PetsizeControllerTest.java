package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.controller.PetsizeController;
import com.example.puddyBuddy.domain.BreedTag;
import com.example.puddyBuddy.dto.petsize.PetsizeInfoReq;
import com.example.puddyBuddy.dto.petsize.PetsizeInfoRes;
import com.example.puddyBuddy.response.BaseResponse;
import com.example.puddyBuddy.service.PetsizeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PetsizeControllerTest {

    @Mock
    private PetsizeService petsizeService;

    @InjectMocks
    private PetsizeController petsizeController;

    @Test
    public void testGetPercentages() {
        // 가상의 입력 데이터
        PetsizeInfoReq petsizeInfoReq = new PetsizeInfoReq();
        BreedTag breedTag = new BreedTag();
        breedTag.setBreedTagId(21L);
        petsizeInfoReq.setBreedTag(breedTag);
        petsizeInfoReq.setPetsizeId(1L);

        // 서비스 동작 가상으로 설정
        // 서비스 메서드에서 실제 계산이 이루어지도록 합니다.
        PetsizeInfoRes expectedResponse = new PetsizeInfoRes();
        when(petsizeService.getPercentages(anyLong(), anyLong())).thenReturn(expectedResponse);

        // 컨트롤러 메서드 호출
        BaseResponse<PetsizeInfoRes> response = petsizeController.getPercentages(petsizeInfoReq);

        // 서비스 메서드가 예상대로 호출되었는지 확인
        verify(petsizeService, times(1)).getPercentages(eq(21L), eq(1L));

        // 컨트롤러 응답의 유효성 확인
        assertNotNull(response);

        // 서비스 메서드에서 반환된 객체와 예상 객체의 값이 일치하는지 확인
        assertEquals(expectedResponse, response.getData());

        // 결과값 출력
        System.out.println("기댓값 : " + expectedResponse);
        System.out.println("실제 결과값 : " + response.getData());

        // 추가로 각 동작에서 발생하는 상태 변화 출력
        // 서비스 메서드가 어떻게 호출되었는지 확인
        System.out.println("서비스 메서드 어떻게 호출 - 품종 번호: " + verify(petsizeService, times(1)).getPercentages(eq(21L), anyLong()));
        System.out.println("서비스 메서드 어떻게 호출 - 펫 사이즈 번호: " + verify(petsizeService, times(1)).getPercentages(anyLong(), eq(1L)));

        // 가상의 입력값이 어떻게 변하는지 확인
        System.out.println("가상의 입력값 변화 - 품종 번호: " + petsizeInfoReq.getBreedTag().getBreedTagId());
        System.out.println("가상의 입력값 변화 - 펫 사이즈 번호: " + petsizeInfoReq.getPetsizeId());

        // 서비스 메서드에서 어떻게 호출되는지 확인
        System.out.println("서비스 메서드 호출 - 품종 번호: " + anyLong());
        System.out.println("서비스 메서드 호출 - 펫 사이즈 번호: " + anyLong());

        // 서비스 메서드의 반환값이 어떻게 설정되는지 확인
        System.out.println("서비스 반환값 설정 - 반환값: " + expectedResponse);
    }
}