package com.gjh.dao;

import com.gjh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Integer> {
//    public User findByUname(String name);
//    public User findByUid(int id);
   public User findByUnameAndUpwd(String name, String upwd);
//    public List<User> findByUnameLike(String name);
//    public List<User> findByUnameOrUage(String name,String age);
//    @Query("from User where uid=?1")
//    public User aa();



}
