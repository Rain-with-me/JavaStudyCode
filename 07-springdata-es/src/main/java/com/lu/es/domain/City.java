package com.lu.es.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.annotation.security.DenyAll;
import java.io.Serializable;

/**
 * 城市实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "index")
public class City implements Serializable{

    private static final long serialVersionUID = -1L;

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;
}
