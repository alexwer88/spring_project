package ru.project.service;

import ru.project.exception.GroupNotFoundException;

/**
 * Created by aw on 08.04.2017.
 */
public interface ImeiService {

    String getGroupByImei(String imei) throws GroupNotFoundException;
}
