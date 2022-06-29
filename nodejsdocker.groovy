job('nodejs docker example') {
    scm {
        git('https://github.com/cat44ld/docker-demo.git') { node ->
            node / gitConfigName('belle453')
            node / gitConfigEmail('tracybelle453@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('cat44ld/docker-nodejs-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
