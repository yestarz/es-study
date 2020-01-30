package link.yangxin.esstudy.controller;

import link.yangxin.esstudy.entity.mysql.MysqlBlog;
import link.yangxin.esstudy.repository.mysql.MysqlBlogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yangxin
 * @date 2020/1/28
 */
@Controller
public class IndexController {

    @Resource
    private MysqlBlogRepository mysqlBlogRepository;

    @GetMapping("")
    public String index(){
        List<MysqlBlog> all = mysqlBlogRepository.findAll();
        System.out.println(all);
        return "index.html";
    }


}