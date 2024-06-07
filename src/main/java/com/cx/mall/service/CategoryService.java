package com.cx.mall.service;

import com.cx.mall.entity.GoodsCategory;
import com.cx.mall.utils.PageQueryUtil;
import com.cx.mall.utils.PageResult;
import com.cx.mall.vo.IndexCategoryVO;
import com.cx.mall.vo.SearchPageCategoryVO;

import java.util.List;

/**
 * @author
 * @date 
 */
public interface CategoryService {
    PageResult getCategorisPage(PageQueryUtil pageUtil);

    String saveCategory(GoodsCategory goodsCategory);

    String updateGoodsCategory(GoodsCategory goodsCategory);

    GoodsCategory getGoodsCategoryById(Long id);

    Boolean deleteBatch(Integer[] ids);

    //返回分类数据(首页调用)
    List<IndexCategoryVO> getCategoriesForIndex();

    //返回分类数据(搜索页调用)
    SearchPageCategoryVO getCategoriesForSearch(Long categoryId);

    //根据parentId和level获取分类列表
    List<GoodsCategory> selectByLevelAndParentIdsAndNumber(List<Long> parentIds, int categoryLevel);
}
