package com.example.puddyBuddy.dto.shop;

import com.example.puddyBuddy.domain.Store;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "상점 전체 목록 조회 response")
public class StoreListRes {
    public StoreListRes (Store store) {
        this.storeId = store.getStoreId();
        this.storeName = store.getStoreName();
    }
    @Schema(description = "상점 번호", example = "1")
    private Long storeId;

    @Schema(description = "상점 이름", example = "구름 마켓")
    private String storeName;
}
