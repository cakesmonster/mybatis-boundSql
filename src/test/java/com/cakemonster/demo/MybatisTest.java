package com.cakemonster.demo;

import com.cakemonster.demo.model.Tag;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

/**
 * MybatisTest
 *
 * @author cakemonster
 * @date 2022/9/23
 */
public class MybatisTest {

    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        Configuration configuration = session.getConfiguration();
        {
            String statement = "com.cakemonster.demo.dao.TagMapper.selectByPrimaryKey";
            MappedStatement ms = configuration.getMappedStatement(statement);
            System.out.println(ms.getBoundSql("1").getSql());
        }

        {
            Tag tag = new Tag();
            tag.setId("123");
            tag.setTagName("456");
            String statement = "com.cakemonster.demo.dao.TagMapper.insert";
            MappedStatement ms = configuration.getMappedStatement(statement);
            System.out.println(ms.getBoundSql(tag).getSql());
        }
    }

    @Test
    public void test2() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        Configuration configuration = session.getConfiguration();
        String statement = "com.cakemonster.demo.dao.TagMapper.selectTagsByIds";
        MappedStatement ms = configuration.getMappedStatement(statement);

        List<String> ids = Lists.newArrayList("1", "2", "3");
        BoundSql boundSql = ms.getBoundSql(wrapCollection(ids));
        System.out.println(boundSql.getSql());
    }

    @Test
    public void test3() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        Configuration configuration = session.getConfiguration();
        String statement = "com.cakemonster.demo.dao.TagMapper.insertAllTags";
        MappedStatement ms = configuration.getMappedStatement(statement);

        Tag tag = new Tag("1", "2", "3", null, null);
        Tag tag1 = new Tag("4", "5", "6", null, null);
        Tag tag2 = new Tag("7", "8", "9", null, null);
        List<Tag> tags = Lists.newArrayList(tag, tag1, tag2);

        BoundSql boundSql = ms.getBoundSql(wrapCollection(tags));
        System.out.println(boundSql.getSql());
    }

    private Object wrapCollection(final Object object) {
        if (object instanceof Collection) {
            DefaultSqlSession.StrictMap<Object> map = new DefaultSqlSession.StrictMap<>();
            map.put("collection", object);
            if (object instanceof List) {
                map.put("list", object);
            }
            return map;
        } else if (object != null && object.getClass().isArray()) {
            DefaultSqlSession.StrictMap<Object> map = new DefaultSqlSession.StrictMap<>();
            map.put("array", object);
            return map;
        }
        return object;
    }
}
