package ru.project.repository.impl;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.Yaml;
import ru.project.exception.LoadDataException;
import ru.project.repository.ImeiRepository;

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
public class ImeiRepositoryImpl implements ImeiRepository {

    private static final String TAC_GROUPS_FILE_NAME = "tac_groups.yaml";

    /**
     * Map<[tac], [group]>
     */
    private Map<String, String> indexedTacGroup;

    @PostConstruct
    public void init() {
        Yaml yaml = new Yaml();
        Map<String, Map<String, List<String>>> tacGroups = (Map<String, Map<String, List<String>>>) yaml
                .load(getResource(TAC_GROUPS_FILE_NAME));

        indexedTacGroup = new HashMap<>();
        tacGroups.get("tac_groups").forEach((group, list) -> list
                .forEach(tac -> indexedTacGroup.put(tac, group)));
    }

    public String getGroup(String tac) {
        return indexedTacGroup.get(tac);
    }

    private InputStream getResource(String fileName) {
        Resource resource = new ClassPathResource(fileName);
        InputStream resourceInputStream;
        try {
            resourceInputStream = resource.getInputStream();
        } catch (IOException e) {
            throw new LoadDataException(e.getMessage());
        }
        return resourceInputStream;
    }
}
