package com.youzan.cloud.dy.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shizhicheng
 * @version 0.1.0
 * @create 2021-05-28 09:47
 * @since 0.1.0
 **/
@CrossOrigin
@RestController
@RequestMapping("/game")
public class GameController {

    /**
     * 嵌入式页面商家端（B端）配置游戏界面
     * @param modelAndView
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/index", method= RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {
        modelAndView.setViewName("/game/index");

        return modelAndView;
    }
}
