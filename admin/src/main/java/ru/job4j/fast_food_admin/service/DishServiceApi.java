package ru.job4j.fast_food_admin.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.fast_food_domains.model.Dish;

import javax.annotation.PreDestroy;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DishServiceApi implements DishService {

    @Value("${dish.url}")
    private String url;

    private final RestTemplate restTemplate;

    public DishServiceApi(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Optional<Dish> save(Dish dish) {
        return Optional.ofNullable(
                restTemplate.postForEntity(
                        url, dish, Dish.class
                ).getBody()
        );
    }

    @Override
    public List<Dish> findAll() {
        return getList(String.format(
                "%s", url
        ));
    }

    private List<Dish> getList(String format) {
        List<Dish> dishes = restTemplate.exchange(
                format, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Dish>>() {
                }
        ).getBody();
        return dishes == null ? Collections.emptyList() : dishes;
    }

    @Override
    public Optional<Dish> findById(int id) {
        return Optional.ofNullable(restTemplate.getForEntity(
                String.format("%s/%d", url, id),
                Dish.class
        ).getBody());
    }


    @Override
    public Optional<Dish> update(Dish dish) {
        System.out.println("DishServiceApi update()");
        return Optional.ofNullable(
                restTemplate.exchange(
                        String.format("%s", url),
                        HttpMethod.PUT,
                        new HttpEntity<>(dish),
                        Dish.class
                ).getBody()
        );
    }

    @Override
    public boolean deleteDish(int id) {
        return restTemplate.exchange(
                String.format("%s/%d", url, id),
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    @PreDestroy
    @Override
    public void close() throws Exception {
    }
}
