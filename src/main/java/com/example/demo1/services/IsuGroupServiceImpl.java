package com.example.demo1.services;


import com.example.demo1.exceptions.ServerNotAvailable;
import com.example.demo1.exceptions.UnrealMeaningException;
import com.example.demo1.dto.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Optional;

import static com.example.demo1.utils.Routes.URL_GET_ALL_GROUP;
import static com.example.demo1.utils.Routes.URL_GET_GROUP;


@Stateless
public class IsuGroupServiceImpl implements IsuGroupService {

    @EJB
    private NetworkService networkService;

    private boolean checkValidCountExpelDTO(CountExpelledDTO countExpelledDTO) {
        Optional.ofNullable(countExpelledDTO.getExpelledStudentCount())
                .filter(count -> count >= 0)
                .orElseThrow(() -> new UnrealMeaningException(String.valueOf(countExpelledDTO.getExpelledStudentCount())));
        return true;

    }

    public CountExpelledDTO expelAllStudents(Long groupId) {
        try {
            StudyGroupBase group = networkService.getTarget().path(URL_GET_GROUP)
                    .resolveTemplate("id", groupId).request()
                    .get().readEntity(new GenericType<StudyGroupBase>() {
                    });
            CountExpelledDTO countExpelledDTO = new CountExpelledDTO((long) group.getStudentsCount());
            int fuck = Math.toIntExact(group.getStudentsCount() + group.getShouldBeExpelled() - 1);
            if (fuck <= 0) {
                fuck = 1;
            }
            group.setShouldBeExpelled(fuck);
            group.setStudentsCount(1L);
            return countExpelledDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerNotAvailable(new ErrorDTO("Сервер недоступен"));
        }
    }

    public CountExpelledDTO countExpelledStudents() {
        //get groups info
        System.out.println("AAA!");
        try {
            List<StudyGroupBase> allGroup = networkService.getTarget().path(URL_GET_ALL_GROUP).request()
                    .get().readEntity(new GenericType<List<StudyGroupBase>>() {
                    });
            allGroup.forEach(System.out::println);
            Long countExpellStudent = allGroup.stream().map(StudyGroupBase::getShouldBeExpelled).reduce(0, Integer::sum).longValue();
            CountExpelledDTO countExpelledDTO = new CountExpelledDTO(countExpellStudent);
            checkValidCountExpelDTO(countExpelledDTO);
            return countExpelledDTO;
        } catch (Exception e) {
            System.out.println("BBB!");
            throw new ServerNotAvailable(new ErrorDTO("Сервер недоступен"));
        }

    }

}