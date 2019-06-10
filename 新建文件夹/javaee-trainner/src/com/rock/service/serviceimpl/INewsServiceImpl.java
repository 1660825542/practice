package com.rock.service.serviceimpl;

import com.rock.dao.INewsDao;
import com.rock.dao.daoimpl.INewsDaoImpl;
import com.rock.entities.News;
import com.rock.service.INewsService;

import java.util.List;

/**
 * @author :老张
 * @version :1.0
 * @Description :
 * @Date :2019-03-25 16:48:44
 */
public class INewsServiceImpl implements INewsService {
    private INewsDao iNewsDao=null;
    public INewsServiceImpl(){
        iNewsDao=new INewsDaoImpl();
    }
    @Override
    public List<News> all() {
        return iNewsDao.queryAllNews();
    }
}
