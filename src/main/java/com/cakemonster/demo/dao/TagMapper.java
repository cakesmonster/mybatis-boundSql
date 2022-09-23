package com.cakemonster.demo.dao;

import com.cakemonster.demo.model.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TagMapper {

    int deleteByPrimaryKey(String id);

    int deleteByQuestionId(String questionId);

    int insert(Tag record);

    int insertAllTags(@Param("tags") List<Tag> tags);

    Tag selectByPrimaryKey(String id);

    List<Tag> selectByQuestionId(String questionId);

    int updateByPrimaryKeySelective(Tag record);

    List<Tag> selectTagsByIds(List<String> ids);

    List<Tag> findTagsInList(List<Integer> ids);
}