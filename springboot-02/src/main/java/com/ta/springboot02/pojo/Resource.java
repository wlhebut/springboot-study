package com.ta.springboot02.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    private Integer id;
    private String url;
    private String perm;
    private boolean power;

}
