package Enotes.project.Service;

import Enotes.project.dto.NoteDto;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    List<NoteDto> getAll();
    Boolean saveNote(NoteDto noteDto);
    Optional<NoteDto> findById(Long id);
    Boolean deleteById(Long id);
    Boolean updateById(Long id ,NoteDto noteDto);
}
