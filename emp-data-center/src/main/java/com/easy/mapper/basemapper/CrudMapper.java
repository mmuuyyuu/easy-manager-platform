package com.easy.mapper.basemapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Packge com.easy.gis.mapper
 * @Autor linNaibin
 * @Description 增删改查mapper
 * @Version 1.0
 * @Date 2020/11/25 15:11
 */
public interface CrudMapper<T> extends BaseMapper {

    /**
     * 获取单条数据
     *
     * @param entity
     * @return
     */
    public T get(T entity);

    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
     *
     * @param entity
     * @return
     */
    public List<T> list(T entity);


    /**
     * 插入数据
     *
     * @param entity
     * @return
     */
    public int insert(T entity);

    public void saves(@Param("list") List<T> list);

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    public int update(T entity);


    /**
     * 删除数据（一般为逻辑删除，更新delflag字段为1）
     *
     * @param entity
     * @return
     */
    public int delete(T entity);

}
