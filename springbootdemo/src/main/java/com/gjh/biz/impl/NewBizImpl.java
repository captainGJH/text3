package com.gjh.biz.impl;

import com.gjh.biz.NewsBiz;
import com.gjh.dao.NewsDao;
import com.gjh.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
@Service
public class NewBizImpl implements NewsBiz{
    @Resource
    private NewsDao newsDao;

    @Override
    public News getnews(int id) {
        return null;
    }

    @Override
    public Page<News> listNews(Pageable pageable, News news) {

        return newsDao.findAll(new Specification<News>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<News> root, CriteriaQuery<?> cq, CriteriaBuilder cb)
            {
                List<Predicate> predicates=new ArrayList<>();
                if(!"".equals(news.getTitle())&&news.getTitle()!=null)
                {
                    predicates.add(cb.like(root.<String>get("title"),"%"+news.getTitle()+"%"));
                }
                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        },pageable);
    }


}
