package com.example.shop.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ListVO {

    private Object list;

    private long page = 1;

    @JsonProperty("page_limit")
    private long pageLimit;

    @JsonProperty("total_count")
    private long totalCount;

    public ListVO(Object list, long totalCount ,long page, long pageLimit) {
        this.list = list;
        this.page = page;
        this.pageLimit = pageLimit;
        this.totalCount = totalCount;
    }
}
