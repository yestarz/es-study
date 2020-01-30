package link.yangxin.esstudy.repository.es;

import link.yangxin.esstudy.entity.es.EsBlog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author yangxin
 * @date 2020/1/28
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, Integer> {

}
