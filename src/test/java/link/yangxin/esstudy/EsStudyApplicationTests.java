package link.yangxin.esstudy;


import link.yangxin.esstudy.entity.es.EsBlog;
import link.yangxin.esstudy.repository.es.EsBlogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsStudyApplicationTests {

    @Resource
    private EsBlogRepository esBlogRepository;

    @Test
    public void contextLoads() {
        Iterable<EsBlog> iterable = esBlogRepository.findAll();
        Iterator<EsBlog> iterator = iterable.iterator();
        System.out.println(iterator.next());
    }

}
