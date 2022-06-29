job('nodejs exampleapp') {
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
        shell('npm install')
    }
}
