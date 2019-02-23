package io.perezlaborda.services;

import io.perezlaborda.models.UserEvent;
import io.perezlaborda.models.UserEventPk;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserEventService extends CrudRepository<UserEvent, UserEventPk> {

    List<UserEvent> findByPk_UserId(String userId);
}
