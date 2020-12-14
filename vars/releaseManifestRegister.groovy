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

    def creds = credentials('github')

    withCredentials(
            [sshUserPrivateKey(
                    credentialsId: 'github',
                    keyFileVariable: 'TMP_SSH_KEY',
                    usernameVariable: 'TMP_SSH_USERNAME')]
    ) {
        println "key = ${TMP_SSH_KEY}"
    }

    manifestReader.read(
            new ReadManifestOptions(
                    gitUrl: 'git@github.com:Signpost6/jenkins-example-java-project.git',
                    tempPath: "${env.workspace}/.tmp"
            )
    )

}
