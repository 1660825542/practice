package com.rock.service.serviceimpl;

import com.rock.dao.IQuestionDao;
import com.rock.dao.daoimpl.IQuestionDaoImpl;
import com.rock.entities.Question;
import com.rock.service.IQuestionService;

import java.util.List;

/**
 * @author :老张
 * @version :1.0
 * @Description :
 * @Date :2019-03-22 13:53:28
 */
public class IQuestionServiceImpl  implements IQuestionService {
    IQuestionDao iQuestionDao=null;
    public IQuestionServiceImpl(){
        iQuestionDao=new IQuestionDaoImpl();
    }

    @Override
    public List<Question> allQuestions() {
        return iQuestionDao.allQuestions();
    }
}
