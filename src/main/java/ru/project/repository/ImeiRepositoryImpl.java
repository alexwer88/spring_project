package ru.project.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.Yaml;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Репозиторий получени данных
 * Created by aw on 09.04.2017.
 */

@Repository
public class ImeiRepositoryImpl {

    /**
     * Map<[tac], [group]>
     */
    private Map<String, String> indexedTacGroup;

    @PostConstruct
    public void init() {
        Resource resource = new ClassPathResource("tac_groups.yaml");
        InputStream resourceInputStream = null;
        try {
            resourceInputStream = resource.getInputStream();
        } catch (IOException e) {
           throw new RuntimeException();
        }

        Yaml yaml = new Yaml();
        Map<String, Map<String, List<String>>> tacGroups = (Map<String, Map<String, List<String>>>) yaml.load(resourceInputStream);

        indexedTacGroup = new HashMap<>();
        tacGroups.get("tac_groups").forEach((group, list) -> list
                .forEach(tac -> indexedTacGroup.put(tac, group)));
    }

    public String getGroup(String tac) {
        return indexedTacGroup.get(tac);
    }
}
