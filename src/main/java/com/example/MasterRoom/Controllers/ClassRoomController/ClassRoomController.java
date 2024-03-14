package com.example.MasterRoom.Controllers.ClassRoomController;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateClassDTO.ClassCreationRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateClassDTO.ClassCreationResponseDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.DeleteClassResponse.DeleteClassResponseDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.GetClassRoomWithClassCode.GetClassRoomWithClassCodeRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.GetClassRoomWithHandlerId.GetClassRoomWithHandlerIdRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.GetClassRoomWithHandlerId.GetClassRoomWithHandlerIdResponseDTO;
import com.example.MasterRoom.Model.Entitys.ClassRoom;
import com.example.MasterRoom.Repositories.ClassRepository.ClassRepository;
import com.example.MasterRoom.Services.ClassServices.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class ClassRoomController {

    @Autowired
    private ClassService classService;
    @PostMapping("/classrooms")
    public ResponseEntity<?> createClassroom(@RequestBody ClassCreationRequestDTO classCreationRequestDTO){
        ClassCreationResponseDTO response = classService.createClass(classCreationRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{teacher}/classrooms")
    public ResponseEntity<?> getAllTheClassRoomOfTheTeacherId(@PathVariable("teacher") String handlerId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
        GetClassRoomWithHandlerIdRequestDTO request = GetClassRoomWithHandlerIdRequestDTO.builder().handlerId(handlerId).page(page).size(size).build();
        List<GetClassRoomWithHandlerIdResponseDTO> classrooms = classService.getClassRoomWithHandlerId(request);
        return new ResponseEntity<>(classrooms, HttpStatus.OK);
    }

    @GetMapping("/{teacher}/classrooms/{classroom}")
    public ResponseEntity<?> getClassWithClassCode(@PathVariable("teacher") String handlerId,
                                                   @PathVariable("classroom") String classCode){
        GetClassRoomWithClassCodeRequestDTO request = GetClassRoomWithClassCodeRequestDTO.builder().classCode(classCode).handlerId(handlerId).build();
        GetClassRoomWithHandlerIdResponseDTO response = classService.getClassRoomWithClassCode(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{teacher}/classrooms/{classroom}")
    public ResponseEntity<?> deleteClassWithClassId(@PathVariable("teacher") String handlerId,
                                                   @PathVariable("classroom") String classCode){
        // we are using a different dto temporarily
        GetClassRoomWithClassCodeRequestDTO request = GetClassRoomWithClassCodeRequestDTO.builder().classCode(classCode).handlerId(handlerId).build();
        DeleteClassResponseDTO response = classService.deleteClassWithClassCode(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
