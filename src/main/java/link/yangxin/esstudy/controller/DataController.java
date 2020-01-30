package link.yangxin.esstudy.controller;

import link.yangxin.esstudy.entity.es.EsBlog;
import link.yangxin.esstudy.entity.mysql.MysqlBlog;
import link.yangxin.esstudy.repository.es.EsBlogRepository;
import link.yangxin.esstudy.repository.mysql.MysqlBlogRepository;
import lombok.Data;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Page;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author yangxin
 * @date 2020/1/28
 */
@RestController
public class DataController {

    @Resource
    private MysqlBlogRepository mysqlBlogRepository;

    @Resource
    private EsBlogRepository esBlogRepository;

    @GetMapping("/blogs")
    public Object blog() {
        List<MysqlBlog> all = mysqlBlogRepository.queryAll();
        return all;
    }

    @PostMapping("/search")
    public Object search(@RequestBody Param param) {
        Map<String, Object> map = new HashMap<>();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        if (param.getType().equals("mysql")) {
            List<MysqlBlog> mysqlBlogs = mysqlBlogRepository.queryBlogs(param.getKeyword());
            map.put("list", mysqlBlogs);
        } else if (param.getType().equals("es")) {
            BoolQueryBuilder builder = QueryBuilders.boolQuery();
            builder.should(QueryBuilders.matchPhraseQuery("title", param.getKeyword()));
            builder.should(QueryBuilders.matchPhraseQuery("content", param.getKeyword()));
            String query = builder.toString();
            System.out.println(query);
            Page<EsBlog> page = ( Page<EsBlog>) esBlogRepository.search(builder);
            List<EsBlog> content = page.getContent();
            map.put("list", content);
        } else {
            return "i dont understant";
        }
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        map.put("duration", totalTimeMillis);
        return map;
    }

    @GetMapping("/blog/{id}")
    public Object detail(@PathVariable("id") Integer id) {
        Optional<MysqlBlog> optional = mysqlBlogRepository.findById(id);
        return optional.orElse(null);
    }

    @Data
    public static class Param {
        private String type;// mysql or es
        private String keyword;
    }
}