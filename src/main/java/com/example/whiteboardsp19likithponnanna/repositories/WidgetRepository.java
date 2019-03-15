package com.example.whiteboardsp19likithponnanna.repositories;

import com.example.whiteboardsp19likithponnanna.model.Widget;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository extends CrudRepository<Widget, Long> {
    @Modifying
    @Query(value = "DELETE FROM Widget widget WHERE widget.topic.id=:tid")
            public void deleteWidgetsByTopic_IdIsIn(@Param("tid") Long tid);

}
