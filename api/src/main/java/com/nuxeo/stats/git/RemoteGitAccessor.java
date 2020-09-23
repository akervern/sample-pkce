package com.nuxeo.stats.git;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logmanager.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

@ApplicationScoped
public class RemoteGitAccessor {
    private static final Logger log = Logger.getLogger(RemoteGitAccessor.class.getName());

    @ConfigProperty(name = "git.remote.server.url")
    protected String serverUrl;

    @ConfigProperty(name = "git.remote.server.username")
    protected String username;

    @ConfigProperty(name = "git.remote.server.token")
    protected String token;

    public RemoteGitAccessor() {

    }

    public void clone(String repository, File targetFolder) throws GitAPIException, IOException {
        // Create folder
        if (!targetFolder.isDirectory() && !targetFolder.mkdirs()) {
            log.log(Level.SEVERE, "Unable to create folders: %s", targetFolder.getAbsolutePath());
            throw new IOException("Cannot create folder: " + targetFolder.getAbsolutePath());
        }

        // Init empty repository
        try (Git git = Git.init().setBare(false).setDirectory(targetFolder).call(); Repository repo = git.getRepository()) {
            // Configure sparsed checkout
            repo.getConfig().setBoolean("core", null, "sparseCheckout ", true);

            // add remote origin

            // pull changes from master
        }
    }
}
