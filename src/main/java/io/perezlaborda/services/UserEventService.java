package io.perezlaborda.services;

import io.perezlaborda.models.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserEventService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserEventService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long count(){
        return jdbcTemplate.query("SELECT COUNT(1) FROM bench.events", new CountRS());
    }

    public List<UserEvent> findByPk_UserId(String userId) {
        return jdbcTemplate.query("SELECT * FROM bench.events WHERE user_id=?", new Object[]{userId},
                (rs, rowNum) -> new UserEvent(rs.getString("user_id"), rs.getLong("datetime"), rs.getString("country_code"), rs.getString("data")));
    }

    private class CountRS implements ResultSetExtractor<Long> {

        @Override
        public Long extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            long count = -1L;

            while(resultSet.next()){
                count = resultSet.getLong("count");
            }

            return count;
        }
    }
}
