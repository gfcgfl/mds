package com.zju.nir.file.mapper;

import com.zju.nir.file.model.FdfsFile;
import com.zju.nir.file.model.FdfsFileExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FdfsFileMapper {
    long countByExample(FdfsFileExample example);

    int deleteByExample(FdfsFileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FdfsFile record);

    int insertSelective(FdfsFile record);

    List<FdfsFile> selectByExample(FdfsFileExample example);

    FdfsFile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FdfsFile record, @Param("example") FdfsFileExample example);

    int updateByExample(@Param("record") FdfsFile record, @Param("example") FdfsFileExample example);

    int updateByPrimaryKeySelective(FdfsFile record);

    int updateByPrimaryKey(FdfsFile record);
}