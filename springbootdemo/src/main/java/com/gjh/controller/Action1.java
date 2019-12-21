package com.gjh.controller;

import com.gjh.NotFoundException;
import com.gjh.biz.NewsBiz;
import com.gjh.dao.NewsDao;
import com.gjh.entity.News;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.data.domain.Pageable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class Action1 {
    @Resource
   private NewsDao newsDao;
    @Resource
    private NewsBiz newsBiz;
    @RequestMapping("out")
    public String out(HttpSession session)
    {
        session.removeAttribute("user");
      return "redirect:show";
    }
    @RequestMapping("newsAdd")
    public String newsAdd()
    {

        return "addBook";
    }
    @RequestMapping("addnews")
    public String addnews(News news, Model model)
    {

        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String time=df.format(date);
        news.setTime(time);
        newsDao.save(news);
        model.addAttribute("msg",1);
        return "addBook";
    }


    @RequestMapping("show")
    public String show(Model model, @PageableDefault(size = 8)Pageable pageable, News news)
    {
        List<News> list1=newsDao.findByOx(1);
        List<News> list2=newsDao.findByOx(2);
        List<News> list3=newsDao.findByOx(3);
        List<News> listAll=newsDao.findAll();
        model.addAttribute("list1",list1);
        model.addAttribute("list2",list2);
        model.addAttribute("list3",list3);
        model.addAttribute("news",news);
        model.addAttribute("listAll",newsBiz.listNews(pageable,news));
        return "index";
    }
    @RequestMapping("shownews")
    public String shownews(int id,Model model)
    {

      model.addAttribute("show",newsDao.findggg(id));

        return "newsShow";
    }

@RequestMapping("/")
    public String ooo()
{

    return "redirect:show";
}

}
