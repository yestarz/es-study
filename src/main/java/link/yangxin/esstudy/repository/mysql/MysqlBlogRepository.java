package link.yangxin.esstudy.repository.mysql;

import link.yangxin.esstudy.entity.mysql.MysqlBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author yangxin
 * @date 2020/1/28
 */
public interface MysqlBlogRepository extends JpaRepository<MysqlBlog, Integer> {

    @Query("from MysqlBlog order by createTime")
    List<MysqlBlog> queryAll();

    @Query("from MysqlBlog where title like concat('%',:keyword,'%') or content like concat('%',:keyword,'%') order by createTime")
    List<MysqlBlog> queryBlogs(@Param("keyword") String keyword);

}