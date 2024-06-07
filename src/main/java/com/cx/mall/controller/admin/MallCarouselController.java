package com.cx.mall.controller.admin;

import com.cx.mall.common.ServiceResultEnum;
import com.cx.mall.entity.Carousel;
import com.cx.mall.service.CarouselService;
import com.cx.mall.utils.PageQueryUtil;
import com.cx.mall.utils.PageResult;
import com.cx.mall.utils.Result;
import com.cx.mall.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @author
 * @date 
 */
@Api(tags = "轮播图controller")
@Controller
@RequestMapping("/admin")
public class MallCarouselController {

    @Resource
    private CarouselService carouselService;

    @ApiOperation(value = "轮播图页面跳转")
    @GetMapping("/carousels")
    public String carouselPage(HttpServletRequest request) {
        request.setAttribute("path", "mall_carousel");
        return "admin/mall_carousel";
    }

    @ApiOperation(value = "轮播图列表页")
    @RequestMapping(value = "/carousels/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        PageResult carouselPage = carouselService.getCarouselPage(pageUtil);
        return ResultGenerator.genSuccessResult(carouselPage);
    }

    @ApiOperation(value = "轮播图添加")
    @RequestMapping(value = "/carousels/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody Carousel carousel) {
        if (StringUtils.isEmpty(carousel.getCarouselUrl())
                || Objects.isNull(carousel.getCarouselRank())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = carouselService.saveCarousel(carousel);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    @ApiOperation(value = "轮播图修改")
    @RequestMapping(value = "/carousels/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestBody Carousel carousel) {
        if (Objects.isNull(carousel.getCarouselId())
                || StringUtils.isEmpty(carousel.getCarouselUrl())
                || Objects.isNull(carousel.getCarouselRank())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = carouselService.updateCarousel(carousel);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    @ApiOperation(value = "根据id查询轮播图信息")
    @GetMapping("/carousels/info/{id}")
    @ResponseBody
    public Result info(@PathVariable("id") Integer id) {
        Carousel carousel = carouselService.getCarouselById(id);
        if (carousel == null) {
            return ResultGenerator.genFailResult(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }
        return ResultGenerator.genSuccessResult(carousel);
    }

    @ApiOperation(value = "根据id删除多个轮播图")
    @RequestMapping(value = "/carousels/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (carouselService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

}
