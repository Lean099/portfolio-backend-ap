package com.leandro.backend.utils;

import java.util.List;

import com.leandro.backend.models.Education;
import com.leandro.backend.models.Project;
import com.leandro.backend.models.Skill;
import com.leandro.backend.models.User;
import com.leandro.backend.models.Work;

import lombok.Data;

@Data
public class DefaultUser {
    private User userData;
    private List<Work> work;
    private List<Education> education;
    private List<Project> project;
    private List<Skill> skill;
}
