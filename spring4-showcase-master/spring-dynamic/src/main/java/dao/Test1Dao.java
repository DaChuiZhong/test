package dao;

import com.sishuok.spring.entity.SysDictionaryEntity;

import java.util.List;

public interface Test1Dao {

//     @Select("SELECT * FROM sys_dictionary")
     List<SysDictionaryEntity> queryList();

     List<SysDictionaryEntity> queryList1();
}
