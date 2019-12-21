package com.gjh.biz;

import com.gjh.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsBiz {
    News getnews(int id);
    Page<News> listNews(Pageable pageable,News news);

}
