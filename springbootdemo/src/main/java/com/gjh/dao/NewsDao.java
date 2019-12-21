package com.gjh.dao;

import com.gjh.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsDao extends JpaRepository<News,Integer>,JpaSpecificationExecutor<News>
{
    public List<News> findByOx(int type);

    @Query("select s  from  News s where new_id = ?1")
    public List<News> findggg(int id);

}
