package com.rock.dao.daoimpl;

import com.rock.dao.INewsDao;
import com.rock.entities.News;
import com.rock.util.JDBCUtil;

import java.util.List;

/**
 * @author :老张
 * @version :1.0
 * @Description :
 * @Date :2019-03-25 16:51:30
 */
public class INewsDaoImpl implements INewsDao {
    private JDBCUtil util=null;
    public INewsDaoImpl(){
        util=new JDBCUtil();
    }
    @Override
    public List<News> queryAllNews() {
        String sql="SELECT n.*,t.typename FROM news n LEFT JOIN newstype t ON n.typeid=t.typeid";
        return util.queryAll(News.class,sql);
    }
}
