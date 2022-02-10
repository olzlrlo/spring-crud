package olzlrlo.springcrud.service;

// Service: 유지보수와 로직 프로세스를 유연하게 처리하기 위한 중간 단계
// 프레임워크 디자인패턴에 들어가며, 프로젝트 규모가 커질수록 관리하기 용이

// Controller -> Service(Interface) -> ServiceImpl -> DAO

import olzlrlo.springcrud.domain.BoardVO;

import java.util.List;

public interface BoardService {
    public void register(BoardVO board) throws Exception;
    public BoardVO read(Integer bno) throws Exception;
    public void modify(BoardVO board) throws Exception;
    public void remove(Integer bno) throws Exception;
    public List<BoardVO> listAll() throws Exception;

}
