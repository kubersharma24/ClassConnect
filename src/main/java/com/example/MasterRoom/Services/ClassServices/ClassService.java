package com.example.MasterRoom.Services.ClassServices;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateClassDTO.ClassCreationRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateClassDTO.ClassCreationResponseDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.GetClassRoomWithHandlerId.GetClassRoomWithHandlerIdRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.GetClassRoomWithHandlerId.GetClassRoomWithHandlerIdResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClassService {
    ClassCreationResponseDTO createClass(ClassCreationRequestDTO classCreationRequestDTO);

    List<GetClassRoomWithHandlerIdResponseDTO> getClassRoomWithHandlerId(GetClassRoomWithHandlerIdRequestDTO request);
}
