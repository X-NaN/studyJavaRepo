package com.nana.studyjavarepo.baseAlgorithm.recursion;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 树元数据(表中数据)
 *
 * @author xingnana
 * @create 12/14/20
 */
@Data
@AllArgsConstructor
public class TreeMetaData {
    private Long id;

    private String name;

    private Long parentId;

    private String path;

    private String idPath;
}
