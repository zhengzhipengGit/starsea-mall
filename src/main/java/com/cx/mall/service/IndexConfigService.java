package com.cx.mall.service;

import com.cx.mall.entity.IndexConfig;
import com.cx.mall.utils.PageQueryUtil;
import com.cx.mall.utils.PageResult;
import com.cx.mall.vo.IndexConfigGoodsVO;

import java.util.List;

/**
 * @author
 * @date 
 */
public interface IndexConfigService {
    PageResult getConfigsPage(PageQueryUtil pageUtil);

    String saveIndexConfig(IndexConfig indexConfig);

    String updateIndexConfig(IndexConfig indexConfig);

    IndexConfig getIndexConfigById(Long id);

    boolean deleteBatch(Long[] ids);

    //返回固定数量的首页配置商品对象(首页调用)
    List<IndexConfigGoodsVO> getConfigGoodsesForIndex(int configType, int number);

}
