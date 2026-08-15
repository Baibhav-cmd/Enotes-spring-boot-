package Enotes.project.Controller;

import Enotes.project.Service.NoteService;
import Enotes.project.dto.NoteDto;
import Enotes.project.utils.CommonUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/note")
@AllArgsConstructor
public class NoteController {
    private static final Logger log = LoggerFactory.getLogger(NoteController.class);

    private final NoteService noteService;

    @GetMapping("/")
    public ResponseEntity<?> getAll() {

        List<NoteDto> notes = noteService.getAll();

        if (CollectionUtils.isEmpty(notes)) {
            return ResponseEntity.noContent().build();
        }


        return CommonUtils.createSuccessResponseNote(notes, HttpStatus.OK, "Categories fetched successfully");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {

        Optional<NoteDto> noteDto =noteService.findById(id);

        log.info("note not found sucessdully");
        return CommonUtils.createBuilderResponse(noteDto,HttpStatus.FOUND);

    }

    @PostMapping("/")
    public ResponseEntity<?> save(@Valid @RequestBody NoteDto noteDto) {


        Boolean saved = noteService.saveNote(noteDto);

        if (saved) {
            return CommonUtils.createBuilderResponseMessage(HttpStatus.CREATED,"saved success");
        }

        return CommonUtils.createdErrorResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR,"not saved");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable long id,
            @Valid @RequestBody NoteDto noteDto){

        Boolean updated = noteService.updateById(id, noteDto);

        if (updated) {
            return  CommonUtils.createBuilderResponseMessage(HttpStatus.CREATED,"update sucessfully");
        }

        return
                CommonUtils.createdErrorResponseMessage(HttpStatus.BAD_REQUEST,"failed top update");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {

        Boolean deleted = noteService.deleteById(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("note not found");
    }

}
