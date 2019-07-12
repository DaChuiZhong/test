package dao;

import com.sishuok.spring.entity.SysDictionaryEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestDao {

//     @Select("SELECT * FROM sys_dictionary")
     List<SysDictionaryEntity> queryList();

     List<SysDictionaryEntity> queryList1();
}
