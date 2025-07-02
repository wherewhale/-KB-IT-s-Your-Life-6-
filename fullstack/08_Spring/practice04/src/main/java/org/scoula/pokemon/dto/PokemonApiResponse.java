package org.scoula.pokemon.dto;

import lombok.Data;

import java.util.List;

@Data
public class PokemonApiResponse {
    private List<Type> results;
}
