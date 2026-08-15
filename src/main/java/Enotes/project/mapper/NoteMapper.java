package Enotes.project.mapper;

import Enotes.project.Model.Note;
import Enotes.project.dto.NoteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface NoteMapper {
    @Mapping(source = "category.id", target = "categoryId")
    Note toEntity(NoteDto noteDto);
    NoteDto toDto(Note note);
    List<Note> toEntity(List<NoteDto> noteDtos);
    List<NoteDto> toDto(List<Note> notes);

}
