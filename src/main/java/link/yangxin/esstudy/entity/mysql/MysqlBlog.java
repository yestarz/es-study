package link.yangxin.esstudy.entity.mysql;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author yangxin
 * @date 2020/1/28
 */
@Data
@Entity
@Table(name = "t_blog")
public class MysqlBlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String author;

    @Column(columnDefinition = "mediumtext")
    private String content;

    private Date createTime;

    private Date updateTime;

}