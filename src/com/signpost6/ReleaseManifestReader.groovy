package com.signpost6

import com.signpost6.model.ReadManifestOptions
import com.signpost6.model.ReleaseManifest
import groovy.json.JsonSlurper
import org.apache.commons.io.FileUtils
import org.eclipse.jgit.api.Git

class ReleaseManifestReader {

    ReleaseManifest read(ReadManifestOptions args) {
        def tmp = "${env.workspace}/.tmp"

        println "Cloning ${args.gitUrl} into ${tmp}"

        FileUtils.forceMkdir(new File(tmp))

        //checkout the git repo containing the release manifest
        Git git = Git.cloneRepository()
                .setURI(args.gitUrl)
                .setDirectory(tmp)
                .call();

        def slurper = new JsonSlurper()
        def manifestJson = slurper.parse(new File(args.manifest))


    }

}
