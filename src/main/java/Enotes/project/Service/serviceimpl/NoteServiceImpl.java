package Enotes.project.Service.serviceimpl;

import Enotes.project.Model.Note;
import Enotes.project.Repository.NoteRepository;
import Enotes.project.Service.NoteService;
import Enotes.project.dto.NoteDto;
import Enotes.project.mapper.NoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private  final NoteMapper noteMapper;
    private final NoteRepository noteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<NoteDto> getAll() {
        List<Note> allNotes=noteRepository.findAll();
        return noteMapper.toDto(allNotes);
    }

    @Override
    @Transactional
    public Boolean saveNote(NoteDto noteDto) {
        Note note=noteMapper.toEntity(noteDto);
        if(ObjectUtils.isEmpty(note)){
            return false;
        }
        noteRepository.save(note);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<NoteDto> findById(Long id) {
        Note existingNote=noteRepository.findById(id).orElseThrow(()->new RuntimeException("note not exist"));
        NoteDto searchNote=noteMapper.toDto(existingNote);
        return Optional.ofNullable(searchNote);

    }

    @Override
@Transactional
    public Boolean deleteById(Long id) {
        Note existsNote=noteRepository.findById(id).orElseThrow(()->new RuntimeException("note not exist"));
          noteRepository.deleteById(id);
          return true;

    }

    @Override
    @Transactional
    public Boolean updateById(Long id, NoteDto noteDto) {
        Note existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("note not exist"));
        existingNote.setTitle(noteDto.getTitle());
        existingNote.setDescription(noteDto.getDescription());
        noteRepository.save(existingNote);
        return true;
    }

}
