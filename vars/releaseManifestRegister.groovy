import com.signpost6.ReadManifestOptions
import com.signpost6.ReleaseManifestReader

/**
 * Determines the current maven version of the project
 *
 * Usage: releaseManifestRegister(
 *  gitUrl: ''
 *  application
 * )
 *
 * @param body
 */

def call(body) {

    if (body != null) {
        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()
    }

    ReleaseManifestReader.read(
            new ReadManifestOptions(gitUrl: 'git@github.com:Signpost6/jenkins-example-java-project.git'))

}
