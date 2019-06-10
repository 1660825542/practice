package com.rock.dao.daoimpl;

import com.rock.dao.IQuestionDao;
import com.rock.entities.Question;
import com.rock.util.JDBCUtil;

import java.util.List;

/**
 * @author :老张
 * @version :1.0
 * @Description :
 * @Date :2019-03-22 13:54:44
 */
public class IQuestionDaoImpl implements IQuestionDao {
    private JDBCUtil util;
    public IQuestionDaoImpl(){
        util=new JDBCUtil();
    }
    @Override
    public List<Question> allQuestions() {
        return util.queryAll(Question.class,"select * from question");
    }
}
