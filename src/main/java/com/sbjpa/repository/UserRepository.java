package com.sbjpa.repository;

import com.sbjpa.dao.UserDao;
import com.sbjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//继承JpaRepository来完成对数据库的操作
//@RepositoryDefinition(domainClass = User.class,idClass = Integer.class)
public interface UserRepository extends JpaRepository<User,Integer> ,JpaSpecificationExecutor,UserDao {
    User findByLastName(String lastName);

    List<User> getByLastNameStartingWithAndIdLessThan(String lastName,Integer id);

    @Query("select u from User u where u.id = (select max(u2.id) from User u2)")
    User getMaxIdUser();

    @Query("select  u from User u where u.lastName = ?1 and u.email = ?2")
    User testQueryAnnotationParams(String lastName,String email);

    @Query("select  u from User u where u.lastName = :lastName and u.email = :email")
    User testQueryAnnotationParams2(@Param("email")String email,@Param("lastName")String lastName);

    @Query(value = "select count(id) from table_user",nativeQuery = true)
    long getTotalCount();

    @Modifying
    @Query("update User u set u.lastName=:lastName where u.id=:id")
    public void updateUser(@Param("lastName")String lastName,@Param("id")Integer id);

}
