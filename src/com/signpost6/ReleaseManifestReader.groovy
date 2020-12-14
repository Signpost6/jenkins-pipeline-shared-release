package com.signpost6

import com.signpost6.model.ReadManifestOptions
import com.signpost6.model.ReleaseManifest
import groovy.json.JsonSlurper
import org.apache.commons.io.FileUtils
import org.eclipse.jgit.api.Git

class ReleaseManifestReader {

    ReleaseManifest read(ReadManifestOptions args) {

        println "Cloning ${args.gitUrl} into ${args.tempPath}"
        def tmpFile = new File(args.tempPath)
        FileUtils.forceDelete(tmpFile)
        FileUtils.forceMkdir(tmpFile)

        //checkout the git repo containing the release manifest
        Git git = Git.cloneRepository()
                .setURI(args.gitUrl)
                .setDirectory(tmpFile)
                .call();

        def slurper = new JsonSlurper()
        def manifestJson = slurper.parse(new File(args.manifest))


    }

}
