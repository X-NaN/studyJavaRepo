package com.nana.studyjavarepo.baseAlgorithm.recursion;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点
 *
 * @author xingnana
 * @create 12/14/20
 */
@Data
@NoArgsConstructor
public class TreeNode {
    private Long id;
    private String name;
    private List<TreeNode> children = new ArrayList<>(); //子模块列表

    /**
     * 是否勾选
     */
    private Boolean isCheck;

    /**
     * 模块路径
     */
    private String path;

    public TreeNode(Long id, String name) {
        this.id = id;
        this.name = name;
        this.isCheck = false;
    }
}
