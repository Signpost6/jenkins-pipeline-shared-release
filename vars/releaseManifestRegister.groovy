import com.signpost6.ReleaseManifestReader
import com.signpost6.model.ReadManifestOptions

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
    def manifestReader = new ReleaseManifestReader();

    manifestReader.read(
            new ReadManifestOptions(gitUrl: 'git@github.com:Signpost6/jenkins-example-java-project.git'))

}
