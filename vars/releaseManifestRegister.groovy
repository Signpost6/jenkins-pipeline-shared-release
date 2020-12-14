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

}
