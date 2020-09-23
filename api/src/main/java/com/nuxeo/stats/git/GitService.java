package com.nuxeo.stats.git;

import org.eclipse.jgit.api.Git;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@ApplicationScoped
public class GitService {

    @ConfigProperty(name = "git.root-path")
    protected String rootPath;

    public static String formatRepositoryPath(String prefix, String projectId) {
        return Paths.get(prefix, projectId + ".git").toString();
    }

    public Path getRepositoryPath(String prefix, String projectId) {
        return Paths.get(rootPath, formatRepositoryPath(prefix, projectId));
    }

    public boolean exists(String prefix, String projectId) {
        return false;
    }

    public void clone(String prefix, String projectId) {

    }

    protected Git openRepository(String prefix, String projectId) throws IOException {
        return Git.open(getRepositoryPath(prefix, projectId).toFile());
    }
}
