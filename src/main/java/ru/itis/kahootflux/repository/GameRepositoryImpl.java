package ru.itis.kahootflux.repository;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import ru.itis.kahootflux.data.Game;
import ru.itis.kahootflux.data.Player;

import java.math.BigDecimal;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Component
public class GameRepositoryImpl {
    private final ReactiveMongoTemplate mongoTemplate;

    public GameRepositoryImpl(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    private static final String PLAYER_ID_FORMAT = "players.%s";
    private static final String ID_KEY = "_id";
    private static final String PIN_KEY = "pin";

    public Mono<Boolean> existsByIdAndPlayerId(String gameId, String playerId) {
        Query query = new Query();
        query.addCriteria(where(String.format(PLAYER_ID_FORMAT, playerId)).exists(true)
                .andOperator(where(ID_KEY).is(gameId))
        );
        return mongoTemplate.exists(query, Game.class);
    }

    public Mono<Boolean> existsByPin(int pin) {
        Query query = new Query(where(PIN_KEY).is(pin));
        return mongoTemplate.exists(query, Game.class);
    }

    public Mono<Game> save(Game game) {
        return mongoTemplate.save(game);
    }

    public Mono<Game> findById(String id) {
        return mongoTemplate.findById(id, Game.class);
    }

    public Mono<Player> addPlayer(String id, String playerId, String name) {
        String playerKey = String.format(PLAYER_ID_FORMAT, playerId);
        Player player = new Player(name, BigDecimal.ZERO);
        Update update = new Update().set(playerKey, player);
        return mongoTemplate.updateFirst(query(where(ID_KEY).is(id)), update, Game.class)
                .map(r -> player);
    }

}
