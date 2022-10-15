package tennis.practice.service;


import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tennis.practice.domain.Board;
import tennis.practice.domain.Member;
import tennis.practice.dto.BoardSaveForm;
import tennis.practice.repository.BoardRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

  public Long addBoard(BoardSaveForm form, Member member) {
    Board board = Board.createBoard(form, member);
    boardRepository.save(board);
    return board.getId();
  }

  public List<Board> getBoardList() {
    return boardRepository.findAll();
  }
}
