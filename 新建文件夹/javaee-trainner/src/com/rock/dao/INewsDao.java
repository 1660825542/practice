package com.rock.dao;

import com.rock.entities.News;

import java.util.List;

public interface INewsDao {
    public List<News> queryAllNews();
}
