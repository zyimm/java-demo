package com.example.shop.controller.request;

import com.example.shop.common.constants.Page;
import lombok.Data;

@Data
public class PageParamRequest {

    private Long page = Page.DEFAULT_PAGE;

    private Long limit = Page.DEFAULT_LIMIT;
}
