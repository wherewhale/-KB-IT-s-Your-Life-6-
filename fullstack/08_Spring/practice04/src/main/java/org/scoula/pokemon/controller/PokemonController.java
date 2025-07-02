package org.scoula.pokemon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.aspectj.weaver.ast.Not;
import org.scoula.pokemon.dto.PokemonApiResponse;
import org.scoula.pokemon.dto.PokemonListResponse;
import org.scoula.pokemon.dto.Type;
import org.scoula.weather.dto.WeatherDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@RestController
@Log4j2
@RequestMapping("/api/pokemon")
@PropertySource({"classpath:/application.properties"})
@Api(tags="Pokemon API") //Swagger 컨트롤러 이름 설정
public class PokemonController {
    @Value("${pokemon.url}")
    private String URL;

    @ApiOperation(value = "포켓몬 목록 상세조회", notes = "포켓몬 목록은 20개 얻는 API")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = PokemonListResponse.class),
        @ApiResponse(code = 400, message = "잘못된 요청입니다."),
        @ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
    })
    @GetMapping({"/list"})
    public ResponseEntity<List<PokemonListResponse>> pokemonList(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromHttpUrl(URL + "/pokemon")
                .queryParam("limit", 20)
                .toUriString();

        // ✅ 응답을 DTO로 매핑
        PokemonApiResponse apiResponse = restTemplate.getForObject(url, PokemonApiResponse.class);
        List<Type> results = apiResponse.getResults();

        if (results == null || results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<PokemonListResponse> detailList = new ArrayList<>();

        for (Type type : results) {
            try {
                PokemonListResponse detail = restTemplate.getForObject(type.getUrl(), PokemonListResponse.class);
                detailList.add(detail);
            } catch (Exception e) {
                log.error("포켓몬 상세 요청 실패: {}", type.getUrl(), e);
            }
        }

        return ResponseEntity.ok(detailList);
    }

    @ApiOperation(value = "포켓몬 상세 정보 조회")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = PokemonListResponse.class),
            @ApiResponse(code = 400, message = "잘못된 요청입니다."),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "포켓몬을 찾을 수 없습니다."),
            @ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
    })
    @GetMapping(value = "/{name}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getPokemonDetail (Model model, @PathVariable(value="name", required = true) String name) {
        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromHttpUrl(URL + "/pokemon/" + name)
                .toUriString();

        try {
            PokemonListResponse pokemon = restTemplate.getForObject(url, PokemonListResponse.class);
            return ResponseEntity.ok(pokemon);
        } catch (HttpClientErrorException.NotFound e) {
            // ✅ JSON 객체로 감싸서 반환
            Map<String, String> error = new HashMap<>();
            error.put("message", "해당 이름의 포켓몬을 찾을 수 없습니다: " + name);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }

    }
}
