package com.sparta.megazine.dto;

import lombok.Getter;

@Getter
public class PostRequestDto  {
    String title;
    String content;
    String imange_url;
    Long view_count;
}
