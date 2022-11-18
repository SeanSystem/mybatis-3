package debug;

import debug.mapper.UserMapper;
import debug.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author huyb
 * @date 2022-11-14 10:44
 */
public class Main {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    SqlSession sqlSession = sessionFactory.openSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    User user = userMapper.getUserById(1);
    sqlSession.commit();
    SqlSession sqlSession1 = sessionFactory.openSession();
    UserMapper mapper = sqlSession1.getMapper(UserMapper.class);
    User userById = mapper.getUserById(1);
    System.out.println(user);
  }
}
