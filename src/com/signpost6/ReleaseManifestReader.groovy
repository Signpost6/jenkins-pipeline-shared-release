package com.signpost6

import com.signpost6.model.ReleaseManifest
import groovy.json.JsonSlurper
import org.apache.commons.io.FileUtils
import org.eclipse.jgit.api.Git

class ReleaseManifestReader {

    static ReleaseManifest read(ReadManifestOptions args) {
        def tmp = ".tmp";
        FileUtils.forceMkdir(new File(tmp))

        println "Cloning ${args.gitUrl} into ${tmp}"

        //checkout the git repo containing the release manifest
        Git git = Git.cloneRepository()
                .setURI(args.gitUrl)
                .setDirectory(tmp)
                .call();

        def slurper = new JsonSlurper()
        def manifestJson = slurper.parse(new File(args.manifest))


    }

}

class ReadManifestOptions {
    String manifest = "manifest.json"
    String gitUrl
}