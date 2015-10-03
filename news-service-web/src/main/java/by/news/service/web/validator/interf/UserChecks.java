package by.news.service.web.validator.interf;

import by.news.service.vo.UserVO;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, UserVO.RegExp.class})
public interface UserChecks {
}
