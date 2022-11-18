package debug.mapper;

import debug.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author huyb
 * @date 2022-11-14 10:39
 */
public interface UserMapper {

  User getUserById(@Param("userId") Integer userId);
}
