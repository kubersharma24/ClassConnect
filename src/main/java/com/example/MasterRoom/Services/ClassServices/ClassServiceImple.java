package com.example.MasterRoom.Services.ClassServices;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateClassDTO.ClassCreationRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateClassDTO.ClassCreationResponseDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.DeleteClassResponse.DeleteClassResponseDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.GetClassRoomWithClassCode.GetClassRoomWithClassCodeRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.GetClassRoomWithHandlerId.GetClassRoomWithHandlerIdRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.GetClassRoomWithHandlerId.GetClassRoomWithHandlerIdResponseDTO;
import com.example.MasterRoom.Model.Entitys.ClassRoom;
import com.example.MasterRoom.Model.Entitys.User;
import com.example.MasterRoom.Repositories.ClassRepository.ClassRepository;
import com.example.MasterRoom.Repositories.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ClassServiceImple implements ClassService {
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ClassCreationResponseDTO createClass(ClassCreationRequestDTO classCreationRequestDTO) {
            // find user in db by email
        ClassCreationResponseDTO response = new ClassCreationResponseDTO();
        ClassRoom classRoom = new ClassRoom();

        try{
            User user = userRepository.findByEmail(classCreationRequestDTO.getHandlerId());
            classRoom.setClassName(classCreationRequestDTO.getClassName());
            classRoom.setDescription(classCreationRequestDTO.getDescription());
            classRoom.setHandlerId(user);
            String s = generateRandomString();
            while(classRepository.existsByClassCode(s)){
                s=generateRandomString();
            }
            response.setClassCode(s);
            classRoom.setClassCode(response.getClassCode());
            classRepository.save(classRoom);
            response.setStatus("ok");
        }catch (Exception e ){
            response.setStatus("Operation Failed");
        }
        return response;
    }

    @Override
    public List<GetClassRoomWithHandlerIdResponseDTO> getClassRoomWithHandlerId(GetClassRoomWithHandlerIdRequestDTO request) {
        PageRequest pageable = PageRequest.of(request.getPage(), request.getSize());
        User user = userRepository.findByEmail(request.getHandlerId());
        Page<ClassRoom> classroomsPage = classRepository.findByHandlerIdId(user.getId(), pageable);
        List<GetClassRoomWithHandlerIdResponseDTO> responseDTOs = classroomsPage.getContent().stream()
                .map(classRoom -> mapToResponseDTO(classRoom))
                .collect(Collectors.toList());
        return responseDTOs;
    }

    @Override
    public GetClassRoomWithHandlerIdResponseDTO getClassRoomWithClassCode(GetClassRoomWithClassCodeRequestDTO request) {
        ClassRoom classroom = classRepository.findByClassCode(request.getClassCode());
        return GetClassRoomWithHandlerIdResponseDTO.builder().classDescription(classroom.getDescription())
                .className(classroom.getClassName())
                .classCode(classroom.getClassCode())
                .build();
    }

    @Override
    public DeleteClassResponseDTO deleteClassWithClassCode(GetClassRoomWithClassCodeRequestDTO request) {

        try{
            ClassRoom byClassCode = classRepository.findByClassCode(request.getClassCode());
            classRepository.delete(byClassCode);
            return new DeleteClassResponseDTO("ok");
        }catch (Exception e){
            return new DeleteClassResponseDTO("Unable to delete check details");
        }
    }

    private GetClassRoomWithHandlerIdResponseDTO mapToResponseDTO(ClassRoom classRoom) {
        GetClassRoomWithHandlerIdResponseDTO responseDTO = new GetClassRoomWithHandlerIdResponseDTO();
        responseDTO.setClassName(classRoom.getClassName());
        responseDTO.setClassCode(classRoom.getClassCode());
        responseDTO.setClassDescription(classRoom.getDescription());
        return responseDTO;
    }
    public static String generateRandomString() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a'); // Generating a random lowercase letter
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }
}

