package com.nana.studyjavarepo.baseAlgorithm.recursion;

import com.google.gson.Gson;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 递归树
 *
 * @author xingnana
 * @create 12/14/20
 */
public class RecursionTree {

    /**
     * 获取整个树
     *
     * @return
     */
    public List<TreeNode> getTree() {
        List<TreeMetaData> dataList = getTestData();
        return buildTree(dataList);
    }

    /**
     * 获取选中的树
     *
     * @return
     */
    public List<TreeNode> getCheckTree() {
        List<TreeMetaData> dataList = getTestData();
        List<Long> checkedIds = Arrays.asList(2L, 4L);

        return buildCheckedTree(dataList,checkedIds);
    }

    private List<TreeMetaData> getTestData() {
        List<TreeMetaData> dataList = new ArrayList<>();
        TreeMetaData data1 = new TreeMetaData(1L, "aa", 0L, "/a/", "/0/");
        dataList.add(data1);

        TreeMetaData data2 = new TreeMetaData(2L, "bb", 0L, "/b/", "/0/");
        dataList.add(data2);

        TreeMetaData data3 = new TreeMetaData(3L, "aa/a1", 1L, "/a/a1/", "/0/1/");
        dataList.add(data3);

        TreeMetaData data4 = new TreeMetaData(4L, "aa/a1/a2", 3L, "/a/a1/a2/", "/0/1/3/");
        dataList.add(data4);

        return dataList;
    }


    /**
     * 构建树
     */
    private List<TreeNode> buildTree(List<TreeMetaData> dataList) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(dataList)) {
            Iterator<TreeMetaData> iterator = dataList.iterator();

            /** 找到所有父节点*/
            while (iterator.hasNext()) {
                TreeMetaData eachDO = iterator.next();
                if (eachDO.getParentId() == 0) { //找到父节点
                    TreeNode parentNode = new TreeNode(eachDO.getId(), eachDO.getName());
                    parentNode.setPath(eachDO.getPath());
                    treeNodeList.add(parentNode);
                    iterator.remove();
                }
            }

            //找所有父节点的子节点
            if (!treeNodeList.isEmpty()) {
                for (TreeNode parent : treeNodeList) {
                    findChildren(parent, dataList);
                }
            }
        }
        return treeNodeList;
    }

    /**
     * 找到父节点的所有子节点
     *
     * @param parent
     * @param doList
     */
    private void findChildren(TreeNode parent, List<TreeMetaData> doList) {
        Iterator<TreeMetaData> iterator = doList.iterator();
        while (iterator.hasNext()) {
            TreeMetaData eachDO = iterator.next();
            if (Objects.equals(parent.getId(), eachDO.getParentId())) {
                TreeNode nodeVO = new TreeNode(eachDO.getId(), eachDO.getName());
                nodeVO.setPath(eachDO.getPath());
                parent.getChildren().add(nodeVO);
                iterator.remove();
            }
        }

        for (TreeNode child : parent.getChildren()) {
            findChildren(child, doList);
        }

    }

    /**
     * 根据选中的树结点构造树
     */
    private List<TreeNode> buildCheckedTree(List<TreeMetaData> dataList, List<Long> checkedIds) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        if (dataList != null) {
            Iterator<TreeMetaData> iterator = dataList.iterator();
            /** 找到所有父节点*/
            while (iterator.hasNext()) {
                TreeMetaData eachDO = iterator.next();
                /** 父节点parentId=0*/
                if (eachDO.getParentId() == 0) {
                    TreeNode parentNode = new TreeNode(eachDO.getId(), eachDO.getName());
                    parentNode.setIsCheck(false);
                    parentNode.setPath(eachDO.getPath());
                    treeNodeList.add(parentNode);
                    iterator.remove();
                }
            }

            /** 找到父节点的所有子节点*/
            if (!treeNodeList.isEmpty()) {
                for (TreeNode parent : treeNodeList) {
                    findCheckedChildren(parent, dataList, checkedIds);
                }
            }

            /** 找到父节点的所有子节点*/
            if (!treeNodeList.isEmpty()) {
                for (TreeNode parent : treeNodeList) {
                    findCheckedChildren(parent, dataList, checkedIds);
                }
            }
        }

        return treeNodeList;
    }

    /**
     * 根据选中的树结点查找子节点
     *
     * @param parent 父节点
     * @param dataList
     * @param checkedIds 选中节点的id
     */
    private void findCheckedChildren(TreeNode parent, List<TreeMetaData> dataList, List<Long> checkedIds) {
        Iterator<TreeMetaData> iterator = dataList.iterator();
        while (iterator.hasNext()) {
            TreeMetaData eachDO = iterator.next();
            /** 循环 找子节点*/
            if (Objects.equals(parent.getId(), eachDO.getParentId())) {
                TreeNode nodeVO = new TreeNode(eachDO.getId(), eachDO.getName());
                nodeVO.setIsCheck(checkedIds.contains(nodeVO.getId()) ? true : false);
                nodeVO.setPath(eachDO.getPath());
                parent.getChildren().add(nodeVO);
                iterator.remove();
            }
        }

        boolean isAllCheck = true;

        /** 找到父节点的所有子节点 且 若子节点全部选中，则选中父节点 */
        for (TreeNode child : parent.getChildren()) {
            findCheckedChildren(child, dataList, checkedIds);
            if (!child.getIsCheck()) {
                isAllCheck = false;
            }
        }

        if (!CollectionUtils.isEmpty(parent.getChildren())) {
            parent.setIsCheck(isAllCheck);
        } else if (checkedIds.contains(parent.getId())) {
            parent.setIsCheck(true);
        }

    }



    public static void main(String[] args) {
        RecursionTree recursionTree = new RecursionTree();
        Gson gson = new Gson();
        System.out.println("完整树: \n"+gson.toJson(recursionTree.getTree()));
        System.out.println("选中树: \n"+gson.toJson(recursionTree.getCheckTree()));

    }

}
